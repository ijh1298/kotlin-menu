package menu.model

data class Coach(
    val name: String,
    var dislikedMenus: List<Menu> = emptyList(),
    var weeklyMenus: List<Menu> = emptyList()
) {
}
