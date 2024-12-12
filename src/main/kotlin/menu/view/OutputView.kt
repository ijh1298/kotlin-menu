package menu.view

import menu.model.Coach

class OutputView {
    fun printResult(coaches: List<Coach>) {
        println("메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        println("[ 카테고리 | %s ]")
        coaches.forEach { println(it.weeklyMenusToString()) }
    }
}