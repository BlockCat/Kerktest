package answer


import react.*
import react.dom.*
import kotlinx.html.classes
import kotlinx.html.js.onClickFunction
import question.Answer
import question.Church
import question.Question
import kotlin.math.roundToInt

fun RBuilder.answers(amountOfQuestions: Int, answers: Map<Question, Answer>, importance: Map<Question, Int>) {
    div("container") {
        div("answers") {
            table {
                thead {
                    th { +"Relevantie" }
                    th { +"Stroming" }
                }
                calculateStuff(answers, importance).forEach { (church, value) ->
                    entry(church, value / amountOfQuestions.toDouble())
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




private fun calculateStuff(answers: Map<Question, Answer>, importance: Map<Question, Int>): List<Pair<Church, Int>> {
    val churches: MutableMap<Church, Int> = mutableMapOf()

    answers.forEach { (q, a) ->
        a.influence.forEach {
            churches[it] = (churches[it] ?: 0) + (importance[q] ?: 1)
        }
    }

    return churches.toList().sortedByDescending { it.second }
}