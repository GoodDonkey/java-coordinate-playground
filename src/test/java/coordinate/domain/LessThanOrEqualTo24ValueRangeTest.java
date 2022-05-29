package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LessThanOrEqualTo24ValueRangeTest {
    
    @ParameterizedTest
    @DisplayName("24 이하인지 검증할 수 있다.")
    @ValueSource(doubles = {1.0, -1.0, 24, 23.9999999})
    void assertValidValueRange(double value) {
        LessThanOrEqualTo24ValueRange range = new LessThanOrEqualTo24ValueRange();
        assertThatNoException().isThrownBy(() -> range.assertValueRange(value));
    }
    
    @ParameterizedTest
    @DisplayName("24 이하인지 검증할 수 있다.")
    @ValueSource(doubles = {25, 24.1, 24.001, 24.000000001})
    void assertInvalidValueRange(double value) {
        LessThanOrEqualTo24ValueRange range = new LessThanOrEqualTo24ValueRange();
        assertThatThrownBy(() -> range.assertValueRange(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}