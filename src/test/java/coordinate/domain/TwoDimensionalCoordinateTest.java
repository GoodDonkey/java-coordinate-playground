package coordinate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoDimensionalCoordinateTest {
    
    @Test
    @DisplayName("좌표값이 같으면 같은 좌표이다.")
    void equals() {
        TwoDimensionalCoordinate coordinate1 = new TwoDimensionalCoordinate(3, 3);
        TwoDimensionalCoordinate coordinate2 = new TwoDimensionalCoordinate(3, 3);
        Assertions.assertThat(coordinate1.equals(coordinate2)).isTrue();
    }
    
    @Test
    @DisplayName("좌표값이 다르면 다른 좌표이다.")
    void notEquals() {
        TwoDimensionalCoordinate coordinate1 = new TwoDimensionalCoordinate(3, 4);
        TwoDimensionalCoordinate coordinate2 = new TwoDimensionalCoordinate(3, 3);
        Assertions.assertThat(coordinate1.equals(coordinate2)).isFalse();
    }
    
    @Test
    @DisplayName("x, y가 바뀌어도 다른 것으로 판단해야한다.")
    void notEquals2() {
        TwoDimensionalCoordinate coordinate1 = new TwoDimensionalCoordinate(3, 4);
        TwoDimensionalCoordinate coordinate2 = new TwoDimensionalCoordinate(4, 3);
        Assertions.assertThat(coordinate1.equals(coordinate2)).isFalse();
    }
}