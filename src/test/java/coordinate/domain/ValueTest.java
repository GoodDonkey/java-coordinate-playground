package coordinate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
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
    
    @ParameterizedTest
    @DisplayName("빼기가 가능한가")
    @CsvSource(value = {"2:4:-2", "10:2:8", "0:0:0", "1.0:1.0:0.0"}, delimiter = ':')
    void subtract(double v1, double v2, double v3) {
        Value value1 = new Value(v1);
        Value value2 = new Value(v2);
        Value value3 = new Value(v3);
    
        assertThat(value1.minus(value2).equals(value3)).isTrue();
        assertThat(value1.minus(value2)).isEqualTo(value3);
    }
    
    @ParameterizedTest
    @DisplayName("빼기가 가능한가 오류테스트")
    @CsvSource(value = {"2:4:-1","10:2:7","500:400:101"}, delimiter = ':')
    void subtractFalse(double v1, double v2, double v3) {
        Value value1 = new Value(v1);
        Value value2 = new Value(v2);
        Value value3 = new Value(v3);
        
        assertThat(value1.minus(value2).equals(value3)).isFalse();
        assertThat(value1.minus(value2)).isNotEqualTo(value3);
    }
    
    @ParameterizedTest
    @DisplayName("곱하기 가능한가")
    @CsvSource(value = {"1:1:1",
                        "3:4:12",
                        "4:5:20",
                        "10.0:10.0:100.0",
                        "10.0:10.0:100"}, delimiter = ':')
    void multiply(double v1, double v2, double v3) {
        Value value1 = new Value(v1);
        Value value2 = new Value(v2);
        Value value3 = new Value(v3);
        
        assertThat(value1.times(value2).equals(value3)).isTrue();
        assertThat(value1.times(value2)).isEqualTo(value3);
    }
    
    @ParameterizedTest
    @DisplayName("곱하기 가능한가 오류테스트")
    @CsvSource(value = {"1:1:2",
                        "3:4:11",
                        "4:5:21",
                        "10.0:10.0:100.1",
                        "10.0:10.0:102"}, delimiter = ':')
    void multiplyFalse(double v1, double v2, double v3) {
        Value value1 = new Value(v1);
        Value value2 = new Value(v2);
        Value value3 = new Value(v3);
        
        assertThat(value1.times(value2).equals(value3)).isFalse();
        assertThat(value1.times(value2)).isNotEqualTo(value3);
    }
    
    @ParameterizedTest
    @DisplayName("제곱이 가능한가")
    @CsvSource(value = {"2:4", "4:16", "6:36", "3.0:9.0", "3:9.0"}, delimiter = ':')
    void square(double v1, double v2) {
        Value value1 = new Value(v1);
        Value value2 = new Value(v2);
    
        assertThat(value1.square().equals(value2)).isTrue();
        assertThat(value1.square()).isEqualTo(value2);
    }
    
    @ParameterizedTest
    @DisplayName("제곱이 가능한가 오류 테스트")
    @CsvSource(value = {"2:3", "4:15", "6:36.1", "3.0:9.2", "4:9.0"}, delimiter = ':')
    void squareFalse(double v1, double v2) {
        Value value1 = new Value(v1);
        Value value2 = new Value(v2);
        
        assertThat(value1.square().equals(value2)).isFalse();
        assertThat(value1.square()).isNotEqualTo(value2);
    }
    
    @ParameterizedTest
    @DisplayName("제곱근을 구할 수 있는가")
    @CsvSource(value = {"4:2", "16:4", "100:10", "9.0:3.0", "9.0:3"}, delimiter = ':')
    void squareRoot(double v1, double v2) {
        Value value1 = new Value(v1);
        Value value2 = new Value(v2);
        
        assertThat(value1.squareRoot().equals(value2)).isTrue();
        assertThat(value1.squareRoot()).isEqualTo(value2);
    }
    
    @ParameterizedTest
    @DisplayName("제곱근을 구할 수 있는가 오류테스트")
    @CsvSource(value = {"4:1", "16:5", "100:14", "9.0:3.3", "9.0:3.000001"}, delimiter = ':')
    void squareRootFalse(double v1, double v2) {
        Value value1 = new Value(v1);
        Value value2 = new Value(v2);
        
        assertThat(value1.squareRoot().equals(value2)).isFalse();
        assertThat(value1.squareRoot()).isNotEqualTo(value2);
    }
}