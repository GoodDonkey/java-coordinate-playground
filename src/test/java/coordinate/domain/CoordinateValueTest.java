package coordinate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CoordinateValueTest {
    
    @Test
    @DisplayName("값이 같으면 equals() 는 같은 것으로 판단한다.")
    void equals() {
        CoordinateValue value1 = new CoordinateValue(3);
        CoordinateValue value2 = new CoordinateValue(3);
        Assertions.assertThat(value1.equals(value2)).isTrue();
    }
    
    @Test
    @DisplayName("값 검증을 수행하는지")
    void assertValue() {
        assertThatThrownBy(
                () -> new CoordinateValue(25, new LessThanOrEqualTo24ValueRange()))
                  .isInstanceOf(IllegalArgumentException.class);
        
        Assertions.assertThatNoException()
                  .isThrownBy(() -> new CoordinateValue(24, new LessThanOrEqualTo24ValueRange()));
    }
}