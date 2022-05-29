package coordinate.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CoordinateValue {
    
    private final double value;
    private final ValueRange valueRange;
    
    public CoordinateValue(double value, ValueRange valueRange) {
        this.valueRange = valueRange;
        valueRange.assertValueRange(value);
        this.value = value;
    }
    
    public CoordinateValue(double value) {
        this.valueRange = new DefaultValueRange();
        valueRange.assertValueRange(value);
        this.value = value;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateValue that = (CoordinateValue) o;
        return Double.compare(that.value, value) == 0;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
