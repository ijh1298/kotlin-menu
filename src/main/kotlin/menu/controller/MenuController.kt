package menu.controller

import menu.model.Coach
import menu.model.Menu
import menu.service.ParsingService
import menu.validator.CoachNameValidator
import menu.validator.InputMenuValidator
import menu.view.InputView

class MenuController(
    private val inputView: InputView = InputView(),
) {
    private lateinit var coaches: List<Coach>
    private lateinit var menus: List<Menu>

    fun run() {
        setCoaches()
    }

    private fun setCoaches() {
        var inputCoaches = ""
        loopUntilValid {
            inputCoaches = inputView.inputCoachNames()
            CoachNameValidator(inputCoaches).validate()
        }
        coaches = ParsingService.stringToCoaches(inputCoaches)
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