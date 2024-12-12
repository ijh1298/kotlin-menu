package menu.service

import menu.model.Coach

object ParsingService {
    fun stringToCoaches(input: String): List<Coach> = input.split(',').map { name -> Coach(name) }
}