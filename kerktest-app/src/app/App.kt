package app

import react.*
import question.Question
import question.question
import question.Answer
import question.getQuestions
import react.dom.div

interface AppState: RState {
    var answers: MutableMap<Question, Answer>
    var index: Int
}

class App : RComponent<RProps, AppState>() {

    val questions = getQuestions()

    override fun AppState.init() {
        answers = mutableMapOf()
        index = 0
    }

    override fun RBuilder.render() {
        div("container") {
            question(questions[state.index]) {
                setState {
                    answers[questions[index]] = it
                    index = if (index + 1 < questions.size) index + 1 else index
                }
            }
        }
    }
}

fun RBuilder.app() = child(App::class) {}
