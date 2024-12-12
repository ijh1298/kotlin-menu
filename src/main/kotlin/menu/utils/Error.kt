package menu.utils

enum class Error(val msg: String) {
    COACH_HEADCOUNT_NOT_IN_RANGE("[ERROR] 코치는 최소 2명 이상, 최대 5명 이하로 입력해야 합니다."),
    COACH_NAME_NOT_IN_RANGE("[ERROR] 코치 이름은 최소 2글자 이상, 최대 4글자 이하로 입력해야 합니다."),

    MENU_NUMBER_NOT_IT_RANGE("[ERROR] 못 먹는 메뉴는 최소 0개 이상, 최대 2개 이하로 입력해야 합니다."),
    MENU_NOT_EXIST("[ERROR] 존재하지 않은 메뉴를 입력했습니다.")
}