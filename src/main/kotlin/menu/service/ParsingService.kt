package menu.service

import menu.model.Coach

object ParsingService {
    fun splitByComma(input: String): List<String> = input.split(',').map { it }

    fun stringToCoaches(input: String): List<Coach> = input.split(',').map { name -> Coach(name) }
}