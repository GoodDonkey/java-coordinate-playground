package coordinate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValueTest {
    
    @Test
    @DisplayName("값이 같으면 equals() 는 같은 것으로 판단한다.")
    void equals() {
        Value value1 = new Value(3);
        Value value2 = new Value(3);
        Assertions.assertThat(value1.equals(value2)).isTrue();
    }
    
    @Test
    @DisplayName("값 검증을 수행하는지")
    void assertValue() {
        assertThatThrownBy(
                () -> new Value(25, new LessThanOrEqualTo24ValueRange()))
                  .isInstanceOf(IllegalArgumentException.class);
        
        Assertions.assertThatNoException()
                  .isThrownBy(() -> new Value(24, new LessThanOrEqualTo24ValueRange()));
    }
}