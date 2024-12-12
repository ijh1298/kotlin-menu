package menu.view

import menu.model.Coach

class OutputView {
    fun printStartMessage() {
        println("점심 메뉴 추천을 시작합니다.")
    }

    fun printResult(coaches: List<Coach>) {
        println("메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        println("[ 카테고리 | ${coaches[0].weeklyMenus.joinToString(" | ") { it.category }} ]")
        coaches.forEach { println(it.weeklyMenusToString()) }
        println("\n추천을 완료했습니다.")
    }
}