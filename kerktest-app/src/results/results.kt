package kerktest


import react.*
import react.dom.*
import kotlin.js.Json
import kotlin.js.json
import kotlin.math.roundToInt

@JsName("gtag")
external fun gtag(method: String, tag: String, payload: Json)

fun RBuilder.results(churches: List<Church>, answers: Map<Question, Answer?>, questionImportance: Map<Question, Double>) {


    div("signpost"){
        div("results") {
            table("table") {
                thead {
                    tr {
                        th { +"Score" }
                        th { +"Stroming" }
                    }
                }
                tbody {
                    answers.toList().forEachIndexed { index, (question, answer) ->
                        val questionIndex = index
                        val importance = answer?.important
                        val answerId = question.answers.indexOf(answer)
                        val payload = json(
                                Pair("Question", "$questionIndex"),
                                Pair("Answer", "$answerId"),
                                Pair("Importance", "$importance"))

                        gtag("config", "UA-121801911-1", json(
                                Pair("custom_map", json(
                                        Pair("dimension2", "Question"),
                                        Pair("metric3", "Answer"),
                                        Pair("metric4", "Importance")
                                ))
                        ))
                        gtag("event", "answers", payload)
                    }

                    // Calculate the maximum amount of points a church can have
                    val completeSum = answers.keys.filter { !it.ignore }.sumByDouble {
                        (questionImportance[it] ?: 1.0) * (answers[it]?.important ?: 1)
                    }

                    calculateStuff(churches, answers, questionImportance).forEach { (church, value) ->
                        entry(church, value / completeSum)
                    }
                }
            }
        }
    }
}

private fun RBuilder.entry(church: Church, value: Double) {
    tr("answer") {
        td { + "${(value * 100).roundToInt()}%" }
        td { + church.n}
    }
}

private fun calculateStuff(churches: List<Church>, answers: Map<Question, Answer?>, questionImportance: Map<Question, Double>): List<Pair<Church, Double>> {
    val churches: MutableMap<Church, Double> = churches.associate { Pair(it, 0.0) }.toMutableMap()

    answers.forEach { (q, a) ->
        a?.influence?.forEach {
            churches[it] = (churches[it] ?: 0.0) + (a.important * (questionImportance[q] ?: 1.0))
        }
    }

    return churches.toList().map { (church, score) -> Pair(church, score) }.sortedByDescending { it.second }
}