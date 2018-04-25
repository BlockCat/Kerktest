package kerktest

import react.*
import react.dom.*
import kotlinx.html.classes
import kotlinx.html.js.onClickFunction
import question.Answer
import question.Question

fun RBuilder.browser(list: List<Question>, answers: Map<Question, Answer>, switchIndex: (Int) -> Unit) {
    div("question-browser") {
        div("list") {
            list.withIndex().forEach { (i, q) ->
                item(i, answers[q]) {switchIndex(it)}
            }
        }
    }
}

private fun RBuilder.item(index: Int, answer: Answer?, switchIndex: (Int) -> Unit) {
    val classes = if (answer != null) "item answered" else "item"

    div(classes) {
        attrs.onClickFunction = {switchIndex(index)}
        +(index + 1).toString()
    }
}
