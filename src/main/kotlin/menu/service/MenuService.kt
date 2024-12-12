package menu.service

import camp.nextstep.edu.missionutils.Randoms
import menu.model.Category
import menu.model.Coach
import menu.model.Menu

object MenuService {
    private val recommendMenus = mutableListOf<Menu>()
    private val usedCategory = MutableList(6) { _ -> 0 } // 각 카테고리 별 사용 횟수

    fun isExistedMenu(menuName: String) = menuName in Category.values().map { it.foods }.flatten()

    fun getCategoryByName(name: String): String {
        if (name in Category.일식.foods) return "일식"
        if (name in Category.한식.foods) return "한식"
        if (name in Category.중식.foods) return "중식"
        if (name in Category.아시안.foods) return "아시안"
        return "양식"
    }

    fun recommendMenuToCoaches(coaches: List<Coach>) {
        val randomCategories = mutableListOf<Int>()
        repeat(5) { randomCategories += getRandomCategory() }

        coaches.forEach { coach ->
            coach.setWeeklyMenus(randomCategories.map { createMenuForCoach(it, coach) })
        }
    }

    private fun getRandomCategory(): Int {
        var randomCategory = Randoms.pickNumberInRange(1, 5)
        while (usedCategory[randomCategory] > 2) { // 두 번 이상 사용한 카테고리인 동안 재설정
            randomCategory = Randoms.pickNumberInRange(1, 5)
        }
        ++usedCategory[randomCategory]

        return randomCategory
    }

    private fun createMenuForCoach(randomCategory: Int, coach: Coach): Menu {
        var selectedMenu = Randoms.shuffle(Category.values()[randomCategory].foods)[0]
        // 이미 추천한 메뉴거나 싫어하는 메뉴인 동안 재설정
        while (selectedMenu in recommendMenus.map { it.name } || selectedMenu in coach.dislikedMenus.map { it.name }) {
            selectedMenu = Randoms.shuffle(Category.values()[randomCategory].foods)[0]
        }

        return Menu(selectedMenu, Category.values()[randomCategory].name)
    }
}