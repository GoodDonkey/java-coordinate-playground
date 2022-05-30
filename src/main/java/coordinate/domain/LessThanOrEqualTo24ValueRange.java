package coordinate.domain;

public class LessThanOrEqualTo24ValueRange implements ValueCondition {
    
    @Override
    public void validate(double value) {
        if (value > 24) {
            throw new IllegalArgumentException("24 이하의 값이어야 합니다.");
        }
    }
}
