package question

import kotlinx.html.classes
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*

data class Answer(val text: String,val influence: List<Church>)
data class Question(val question: String, val answers: List<Answer>, var selected: Answer? = null)

interface QuestionState : RState {
    var answer: Answer
}
interface QuestionProps: RProps {
    var question: Question
    var onButtonSelect: (Answer) -> Unit
}

fun RBuilder.question(question: Question, onButtonSelect: (Answer) -> Unit) = child(QuestionComponent::class) {
    attrs.question = question
    attrs.onButtonSelect = onButtonSelect
}

class QuestionComponent: RComponent<QuestionProps, QuestionState>() {

    override fun QuestionState.init(props: QuestionProps) {
        if (props.question.selected != null)
            state.answer = props.question.selected!!
    }

    override fun RBuilder.render() {
        val question = props.question

        div("question") {
            h1 { +question.question }
            question.answers.withIndex().forEach { (a, it) ->
                answer(a, it)
            }
        }
    }

    private fun setAnswer(answer: Answer) {
        props.onButtonSelect(answer)
        setState {
            this.answer = answer
        }
    }

    fun RBuilder.answer(index: Int, answer: Answer) {
        val classes = if (state.answer == answer) setOf("answer", "selected") else setOf("answer")
        div("answer") {
            attrs.classes = classes
            attrs.onClickFunction = {setAnswer(answer)}
            span {
                +answer.text
            }
        }
    }

}



