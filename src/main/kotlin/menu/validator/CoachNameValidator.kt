package menu.validator

import menu.service.ParsingService
import menu.utils.Error

class CoachNameValidator(
    private val inputCoachNames: String
) {
    private lateinit var parsedCoachNames: List<String>

    fun validate() {
        parsedCoachNames = ParsingService.splitByComma(inputCoachNames)
        require(isNameInRange()) { Error.COACH_NAME_NOT_IN_RANGE.msg }
        require(isHeadcountInRange()) { Error.COACH_HEADCOUNT_NOT_IN_RANGE.msg }
    }

    private fun isNameInRange() = parsedCoachNames.all { it.length in 2..4 }

    private fun isHeadcountInRange() = parsedCoachNames.size in 2..5
}