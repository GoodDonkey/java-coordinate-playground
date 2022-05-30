package coordinate.domain;

import java.util.Objects;

public class Value {
    
    private final double value;
    private final ValueCondition valueCondition;
    
    public Value(double value, ValueCondition valueCondition) {
        this.valueCondition = valueCondition;
        valueCondition.validate(value);
        this.value = value;
    }
    
    public Value(double value) {
        this.valueCondition = new NoValueCondition();
        valueCondition.validate(value);
        this.value = value;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value that = (Value) o;
        return Double.compare(that.value, value) == 0;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
