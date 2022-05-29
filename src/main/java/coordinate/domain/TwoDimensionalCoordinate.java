package coordinate.domain;

import java.util.Objects;

public class TwoDimensionalCoordinate {
    
    final CoordinateValue x;
    final CoordinateValue y;
    
    protected TwoDimensionalCoordinate(double x, double y) {
        this.x = new CoordinateValue(x);
        this.y = new CoordinateValue(y);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoDimensionalCoordinate that = (TwoDimensionalCoordinate) o;
        return x.equals(that.x) && y.equals(that.y);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
