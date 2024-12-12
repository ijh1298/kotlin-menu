package menu.model

data class Coach(
    val name: String,
    var dislikedMenus: List<Menu> = emptyList(),
    var weeklyMenus: List<Menu> = emptyList()
) {
    fun setDislikedMenus(menus: List<Menu>) {
        dislikedMenus = menus
    }

    fun setWeeklyMenus(menus: List<Menu>) {
        weeklyMenus = menus
    }

    fun weeklyMenusToString(): String {
        return "[ $name | ${weeklyMenus.map { it.name }.joinToString { " | " }} ]"
    }
}
