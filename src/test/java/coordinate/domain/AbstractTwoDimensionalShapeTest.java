package coordinate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AbstractTwoDimensionalShapeTest {
    
    @Test
    @DisplayName("1개의 좌표만 넣으면 예외가 발생해야 한다.")
    void test1() {
        assertThatThrownBy(() -> new MockTwoDimensionalShape(new TwoDimensionalCoordinate(3, 3))).isInstanceOf(
                IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("같은 좌표가 들어가면 예외가 발생해야 한다.")
    void test2() {
        assertThatThrownBy(() -> new MockTwoDimensionalShape(new TwoDimensionalCoordinate(3, 3),
                                                             new TwoDimensionalCoordinate(3, 3))).isInstanceOf(
                IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("서로 다른 좌표 2개를 넣으면 도형을 생성할 수 있다.")
    void test4() {
        assertThatNoException().isThrownBy(() -> new MockTwoDimensionalShape(new TwoDimensionalCoordinate(3, 3),
                                                                             new TwoDimensionalCoordinate(4, 4)));
        
    }
    
    @Test
    @DisplayName("서로 다른 좌표 3개 이상 넣어도 도형을 생성할 수 있다.")
    void test5() {
        assertThatNoException().isThrownBy(() -> new MockTwoDimensionalShape(new TwoDimensionalCoordinate(3, 3),
                                                                             new TwoDimensionalCoordinate(4, 4),
                                                                             new TwoDimensionalCoordinate(5, 5)));
        
    }
    
    @Test
    @DisplayName("2차원 도형의 좌표의 개수를 구할 수 있다.")
    void test3() {
        MockTwoDimensionalShape mockTwoDimensionalShape =
                new MockTwoDimensionalShape(new TwoDimensionalCoordinate(3, 3),
                                            new TwoDimensionalCoordinate(4, 4));
        Assertions.assertThat(mockTwoDimensionalShape.numberOfVertices()).isEqualTo(2);
    }
    
    @Test
    @DisplayName("상속체는 no-args constructor 를 사용할 수 없다.")
    void test6() {
        assertThatThrownBy(MockTwoDimensionalShape::new).isInstanceOf(RuntimeException.class);
    }
    
    class MockTwoDimensionalShape extends AbstractTwoDimensionalShape {
        
        public MockTwoDimensionalShape(TwoDimensionalCoordinate... coordinates) {
            super(coordinates);
        }
    }
}