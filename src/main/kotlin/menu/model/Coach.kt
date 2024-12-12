package menu.model

data class Coach(
    val name: String,
    val dislikedMenus: List<Menu>,
    val weeklyMenus: List<Menu>
)
