package menu.validator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputMenuValidatorTest {
    @ParameterizedTest
    @ValueSource(
        strings = [""]
    )
    fun `메뉴 빈 값 입력 가능 검사`(input: String) {
        assertThat(InputMenuValidator(input).validate()).isEqualTo(true)
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["우동,스시,미소시루", "바게트,스파게티,피자,파니니"]
    )
    fun `메뉴 최대 두 개 제한 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> { InputMenuValidator(input).validate() }
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["삼겹살", "불고기,탕후루"]
    )
    fun `존재하지 않는 음식 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> { InputMenuValidator(input).validate() }
    }
}