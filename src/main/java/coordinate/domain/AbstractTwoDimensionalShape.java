package coordinate.domain;

import java.util.Arrays;
import java.util.HashSet;

public abstract class AbstractTwoDimensionalShape {
    
    protected final TwoDimensionalCoordinate[] coordinates;
    
    /* [ 이 생성자는 2개 이상의 좌표를 받아 2차원 도형을 표현한다. ]
    * 2개 이상의 좌표를 파라미터로 개별로 받게 하는 것이 번거로움.
    * - varargs 사용 시 no-args constructor 로도 동작하므로 상속 클래스의 super()에 인자를 강요할 수 없음.
    * - 그렇다고 따로 coordinate1, coordinate2, coordinates 로 파라미터를 구성하면
    *   - 이 생성자에서 배열을 묶어워야 줘야함
    *   - 상속 클래스의 super(...)도 인자를 넣어주는 데에 번거롭다.
    * 따라서 TwoDimensionalCoordinate[] 를 사용해서 super()에 인자를 강제하고,
    * 간단한 구현만 하기로 한다. */
    protected AbstractTwoDimensionalShape(TwoDimensionalCoordinate[] coordinates) {
        assertNoEqualCoordinates(coordinates);
        assertLengthTwo(coordinates);
        this.coordinates = coordinates;
    }
    
    private AbstractTwoDimensionalShape() { coordinates = null; }
    
    private void assertLengthTwo(TwoDimensionalCoordinate... coordinates) {
        if (coordinates.length < 2) {
            throw new IllegalArgumentException("좌표의 개수는 2개 이상이어야 합니다. :" + coordinates.length + "개 받음");
        }
    }
    
    private void assertNoEqualCoordinates(TwoDimensionalCoordinate... coordinates) {
        HashSet<TwoDimensionalCoordinate> set = new HashSet<>(Arrays.asList(coordinates));
        if (set.size() != coordinates.length) {
            throw new IllegalArgumentException("같은 좌표가 존재합니다.");
        }
    }
    
    public final int numberOfVertices() {
        return coordinates.length;
    }
}
