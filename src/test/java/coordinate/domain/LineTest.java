package coordinate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    
    @Test
    @DisplayName("2개의 좌표값을 가지는가?")
    void length() {
        Line line = new Line(1, 2, 3, 4);
        int size = line.numberOfVertices();
    
        assertThat(size).isEqualTo(2);
    }
    
    @Test
    @DisplayName("2개의 좌표값을 가지는가? 오류테스트")
    void lengthFalse() {
        assertThatThrownBy(() -> new Line(1, 2, 3)).isInstanceOf(ArrayIndexOutOfBoundsException.class);
        // 5개 이상의 값을 넣으면 앞의 4개만 사용함. 더 엄격하게 하기에는 좀...
        // 오류 이름도 배열 오류라 좀...
    }
    
    @ParameterizedTest
    @DisplayName("거리를 구할 수 있는가")
    @CsvSource(value = {"1:1:1:3:2", "2:2:5:2:3"}, delimiter = ':')
    void distance(double v1, double v2, double v3, double v4, double v5) {
        Line line = new Line(v1, v2, v3, v4);
        
        assertThat(line.euclideanDistance()).isEqualTo(new Value(v5));
    }
    
    @ParameterizedTest
    @DisplayName("거리를 구할 수 있는가 오류 테스트")
    @CsvSource(value = {"1:1:1:3:100", "2:2:5:2:-1", "1:1:2:2:1.414"}, delimiter = ':')
    void distanceFalse(double v1, double v2, double v3, double v4, double v5) {
        Line line = new Line(v1, v2, v3, v4);
        
        assertThat(line.euclideanDistance()).isNotEqualTo(new Value(v5));
    }
    @ParameterizedTest
    @DisplayName("거리를 구할 수 있는가 근사치 테스트")
    @CsvSource(value = {"1:1:2:2:1.41421356237"}, delimiter = ':')
    void distance2(double v1, double v2, double v3, double v4, double v5) {
        Line line = new Line(v1, v2, v3, v4);
    
        assertThat(line.euclideanDistance().raw()).isEqualTo(v5, offset(0.00000001));
    }
}