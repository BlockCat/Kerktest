package app

import kerktest.results
import kerktest.browser
import react.*
import kerktest.*
import react.dom.div

interface AppState: RState {
    var answers: MutableMap<Question, Answer?>
    //var important: MutableMap<Question, Int>
    var index: Int
}

class App : RComponent<RProps, AppState>() {

    lateinit var questions: List<Question>

    override fun AppState.init() {
        questions = getQuestions()
        answers = questions.associate { Pair(it, null as Answer?) }.toMutableMap()
        //important = mutableMapOf()
        index = 0
    }

    override fun RBuilder.render() {

        div("container") {
            if (state.index < questions.size) {
                val currentQuestion = questions[state.index]
                question(state.index, currentQuestion, state.answers[currentQuestion]) { selectAnswer(it) }
                browser(questions, state.answers) { switchIndex(it) }
            } else {
                results(getChurches(), state.answers)
            }
        }
    }

    private fun selectAnswer(answer: Answer) {
        setState {
            answers[questions[index]] = answer
            //important[questions[index]] = answer.important
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
