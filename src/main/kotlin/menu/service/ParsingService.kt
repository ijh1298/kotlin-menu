package menu.service

import menu.model.Coach
import menu.model.Menu

object ParsingService {
    fun splitByComma(input: String): List<String> = input.split(',').map { it }

    fun stringToCoaches(inputCoachNames: String): List<Coach> {
        return inputCoachNames.split(',').map { name -> Coach(name) }
    }

    fun stringToMenus(inputMenuNames: String): List<Menu> {
        return inputMenuNames.split(',').map { name -> Menu(name, MenuService.getCategoryByName(name)) }
    }
}