package coordinate.domain;

import java.util.Objects;

public class TwoDimensionalCoordinate {
    
    final Value x;
    final Value y;
    
    protected TwoDimensionalCoordinate(double x, double y) {
        this.x = new Value(x, new LessThanOrEqualTo24ValueRange());
        this.y = new Value(y, new LessThanOrEqualTo24ValueRange());
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
