package menu.validator

import menu.service.MenuService
import menu.service.ParsingService
import menu.utils.Error

class InputMenuValidator(
    private val inputMenus: String
) {
    private lateinit var parsedMenus: List<String>

    fun validate(): Boolean {
        if (inputMenus.isEmpty()) return true
        parsedMenus = ParsingService.splitByComma(inputMenus)
        require(isInRange()) { Error.MENU_NUMBER_NOT_IT_RANGE.msg }
        require(isMenuAllIncluded()) { Error.MENU_NOT_EXIST.msg }
        return true
    }

    private fun isInRange() = parsedMenus.size in 0..2

    private fun isMenuAllIncluded() = parsedMenus.all { MenuService.isExistedMenu(it) }
}