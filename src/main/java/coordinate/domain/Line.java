package coordinate.domain;

public class Line extends AbstractTwoDimensionalShape{
    
    private EuclideanDistance formula;
    
    public Line(TwoDimensionalCoordinate... coordinates) {
        super(coordinates);
        this.formula = new DefaultFormula();
    }
    
    protected Line(double... xys) {
        super(new TwoDimensionalCoordinate[]{
                new TwoDimensionalCoordinate(xys[0], xys[1]),
                new TwoDimensionalCoordinate(xys[2], xys[3])});
        this.formula = new DefaultFormula();
    }
    
    public final Value euclideanDistance() {
        assert coordinates != null;
        return formula.calculateEuclideanDistance(coordinates[0],
                                                  coordinates[1]);
    }
}
