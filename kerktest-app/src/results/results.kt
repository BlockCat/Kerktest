package kerktest


import react.*
import react.dom.*
import kotlin.math.roundToInt

fun RBuilder.results(churches: List<Church>, answers: Map<Question, Answer?>, importance: Map<Question, Int>) {
    div("container") {
        div("results") {
            table {
                thead {
                    tr {
                        th { +"Score" }
                        th { +"Stroming" }
                    }
                }
                tbody {
                    calculateStuff(churches, answers, importance).forEach { (church, value) ->
                        entry(church, value / answers.keys.sumByDouble { it.importance })
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




private fun calculateStuff(churches: List<Church>, answers: Map<Question, Answer?>, importance: Map<Question, Int>): List<Pair<Church, Int>> {
    val churches: MutableMap<Church, Double> = churches.associate { Pair(it, 0.0) }.toMutableMap()

    answers.forEach { (q, a) ->
        a?.influence?.forEach {
            churches[it] = (churches[it] ?: 0.0) + (importance[q] ?: 1) * q.importance
        }
    }

    return churches.toList().map { (church, score) -> Pair(church, score.toInt()) }.sortedByDescending { it.second }
}