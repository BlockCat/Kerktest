package question

import kotlinx.html.classes
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*

data class Answer(val text: String,val influence: List<Church>)
data class Question(val question: String, val answers: List<Answer>, var selected: Answer? = null)

interface QuestionState : RState {}
interface QuestionProps: RProps {
    var index: Int
    var question: Question
    var selectedAnswer: Answer?
    var onButtonSelect: (Answer) -> Unit
}

fun RBuilder.question(index: Int, question: Question, selected: Answer?, onButtonSelect: (Answer) -> Unit) = child(QuestionComponent::class) {
    attrs.index = index
    attrs.question = question
    attrs.onButtonSelect = onButtonSelect
    attrs.selectedAnswer = selected
}

class QuestionComponent: RComponent<QuestionProps, QuestionState>() {

    override fun RBuilder.render() {
        val question = props.question

        div("question") {
            h1 { +"${props.index + 1}. ${question.question}" }
            question.answers.withIndex().forEach { (a, it) ->
                answer(a, it)
            }
        }
    }

    private fun setAnswer(answer: Answer) {
        props.onButtonSelect(answer)
    }

    fun RBuilder.answer(index: Int, answer: Answer) {
        val classes = if (props.selectedAnswer == answer) setOf("answer", "selected") else setOf("answer")
        div("answer") {
            attrs.classes = classes
            attrs.onClickFunction = {setAnswer(answer)}
            span {
                +answer.text
            }
        }
    }

}



