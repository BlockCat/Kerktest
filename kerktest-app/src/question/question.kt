package kerktest

import kotlinx.html.InputType
import kotlinx.html.classes
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSelectElement
import react.*
import react.dom.*


interface QuestionState : RState {
    var slider: Int
}
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

class QuestionComponent(props: QuestionProps): RComponent<QuestionProps, QuestionState>(props) {

    init {
        state.slider = scaleNumber(props.question.importance)
    }

    override fun componentWillReceiveProps(nextProps: QuestionProps) {
        state.slider = scaleNumber(nextProps.question.importance)

    }

    // Scales the value of [0.5, 3] to be in [0, 100]
    private fun scaleNumber(value: Double): Int {
        // Scale to [50, 100]
        if (value > 1) {
            //scale value to [0, 1]
            var value = (value - 1) / 2.0

            return (value * 50 + 50).toInt()
        } else {
            // scale [0, 1] to [0, 50]
            return (value * 50).toInt()
        }
    }

    private fun inverseScaleNumber(value: Int): Double {
        // Scale [50, 100] to [1, 3]
        if (value > 50) {
            // scale [50, 100] to [0, 100]
            val value = (value - 50) * 2
            // scale [0, 100] to [0, 1] to [0, 2] to [1, 3]
            return ((value / 100.0) * 2) + 1
        } else {
            // scale [0, 50] to [0, 1]
            return value / 50.0
        }
    }

    override fun RBuilder.render() {
        val question = props.question

        div("question") {
            val prefix = if (question.display) {"${props.index + 1}. "} else { "" }

            h1 { +"$prefix${question.question}" }
            div("importance") {
                div("header") {
                    div {+"Onbelangrijk"}
                    div {+"Belangrijk"}
                }
                div("slide-container") {

                    input(InputType.range) {
                        attrs {
                            min = "0"
                            max = "100"
                            defaultValue = "${(question.importance * 100).toInt()}"
                            value = "${state.slider}"
                            classes = setOf("slider")

                            onChangeFunction = {event ->
                                var newValue = (event.target as HTMLInputElement).valueAsNumber.toInt()

                                setState {
                                    slider = newValue
                                }
                                question.importance = inverseScaleNumber(newValue)
                            }
                        }
                    }

                }
            }
            question.answers.withIndex().forEach { (a, it) ->
                answer(a, it)
            }
        }
    }

    private fun setAnswer(answer: Answer) {
        props.onButtonSelect(answer)
    }

    fun RBuilder.answer(index: Int, answer: Answer) {
        if (answer is MultipleChoice) {
            multipleChoice(index, answer)
        } else {
            singleAnswer(index, answer)
        }
    }

    private fun RBuilder.singleAnswer(index: Int, answer: Answer) {
        val classes = if (props.selectedAnswer == answer) setOf("answer", "selected") else setOf("answer")
        div("answer") {
            attrs.classes = classes
            attrs.onClickFunction = {setAnswer(answer)}
            span {
                +answer.text
            }
        }
    }

    private fun RBuilder.multipleChoice(index: Int, answer: MultipleChoice) {
        val classes = if (props.selectedAnswer == answer) setOf("answer", "selected") else setOf("answer")
        div("answer") {
            attrs.classes = classes
            span {
                +answer.text
            }

            div("multiple-choice") {
                select {
                    attrs.onChangeFunction = { event ->
                        val newValue = ((event.target as HTMLSelectElement).value)
                        if (newValue != "None selected") {
                            val newValue = newValue.toInt()
                            setAnswer(answer.answers[newValue])
                        }
                    }
                    option {
                        attrs.value = "None selected"
                        +"-Selecteer kerk-"
                    }
                    answer.answers.withIndex().forEach { (index, answer) ->
                        option("") {
                            attrs.value = "$index"
                            +answer.text
                        }
                    }
                }
            }
        }
    }

}



