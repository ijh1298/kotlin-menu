package menu.controller

import menu.model.Coach
import menu.model.Menu
import menu.service.MenuService
import menu.service.ParsingService
import menu.validator.CoachNameValidator
import menu.validator.InputMenuValidator
import menu.view.InputView

class MenuController(
    private val inputView: InputView = InputView(),
) {
    private lateinit var coaches: List<Coach>
    private lateinit var recommendMenus: List<List<Menu>>

    fun run() {
        setCoaches()
        setDislikedMenusForAll()
        setRecommendedMenus()
    }

    private fun setRecommendedMenus() {
        recommendMenus = MenuService.createWeeklyMenu(coaches)
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
        coach.setDislikedMenus(dislikedMenus)
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