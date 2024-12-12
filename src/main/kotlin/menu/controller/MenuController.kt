package menu.controller

import menu.model.Coach
import menu.model.Menu
import menu.service.MenuService
import menu.service.ParsingService
import menu.validator.CoachNameValidator
import menu.validator.InputMenuValidator
import menu.view.InputView
import menu.view.OutputView

class MenuController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {
    private lateinit var coaches: List<Coach>

    fun run() {
        setCoaches()
        setDislikedMenusForAll()
        MenuService.recommendMenuToCoaches(coaches)
        outputView.printResult(coaches)
    }

    private fun setCoaches() {
        var inputCoaches = ""
        loopUntilValid {
            inputCoaches = inputView.inputCoachNames()
            CoachNameValidator(inputCoaches).validate()
        }
        coaches = ParsingService.stringToCoaches(inputCoaches)
    }

    private fun setDislikedMenusForAll() {
        coaches.forEach {
            setDislikedMenusForOne(it)
        }
    }

    private fun setDislikedMenusForOne(coach: Coach) {
        var inputDislikedMenus = ""
        loopUntilValid {
            inputDislikedMenus = inputView.inputDislikedMenus(coach.name)
            InputMenuValidator(inputDislikedMenus).validate()
        }
        val dislikedMenus = ParsingService.stringToMenus(inputDislikedMenus)
        coach.dislikedMenus = dislikedMenus
    }

    // 반복 입력받는 로직
    private fun <T> loopUntilValid(action: () -> T): T {
        while (true) {
            try {
                return action()
            } catch (e: IllegalArgumentException) {
                println(e.message + '\n')
            }
        }
    }
}