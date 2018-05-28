package app

import answer.answers
import kerktest.browser
import react.*
import question.Question
import question.question
import question.Answer
import question.getQuestions
import react.dom.div

interface AppState: RState {
    var answers: MutableMap<Question, Answer>
    var important: MutableMap<Question, Int>
    var index: Int
}

class App : RComponent<RProps, AppState>() {

    val questions = getQuestions()

    override fun AppState.init() {
        answers = mutableMapOf()
        important = mutableMapOf()
        index = 0
    }

    override fun RBuilder.render() {

        div("container") {
            if (state.index < questions.size) {
                val currentQuestion = questions[state.index]
                question(state.index, currentQuestion, state.answers[currentQuestion]) { selectAnswer(it) }
                browser(questions, state.answers) { switchIndex(it) }
            } else {
                answers(questions.size, state.answers, state.important)
            }
        }
    }

    private fun selectAnswer(answer: Answer) {
        setState {
            answers[questions[index]] = answer
            important[questions[index]] = answer.important
            index += 1
        }
    }

    private fun switchIndex(newIndex: Int) {
        setState {
            index = newIndex
        }
    }
}

fun RBuilder.app() = child(App::class) {}
