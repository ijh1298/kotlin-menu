package menu.validator

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CoachNameValidatorTest {
    @ParameterizedTest
    @ValueSource(
        strings = ["준혁", "토미,제임스,포코,준혁,민수,영희"]
    )
    fun `코치 인원 2-5명 범위 벗어남 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> { CoachNameValidator(input).validate() }
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["우아한테크코스", "한,글,자"]
    )
    fun `코치 이름 2-4글자 범위 벗어남 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> { CoachNameValidator(input).validate() }
    }
}