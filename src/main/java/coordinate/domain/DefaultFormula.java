package coordinate.domain;

public class DefaultFormula implements EuclideanDistance, RectangleArea {
    
    @Override
    public Value calculateArea(TwoDimensionalCoordinate[] coordinates) {
        return new Value(0);
    }
    
    @Override
    public Value calculateEuclideanDistance(TwoDimensionalCoordinate coordinate1,
                                            TwoDimensionalCoordinate coordinate2) {
        return coordinate1.x.minus(coordinate2.x).square()
                            .plus(coordinate1.y.minus(coordinate2.y).square())
                            .squareRoot();
    }
}
