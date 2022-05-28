package fuel;

public class Sonata extends Car{
    
    public static final double DISTANCE_PER_LITER = 10;
    public final double distance;
    
    public Sonata(double distance) {
        this.distance = distance;
    }
    
    @Override
    double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }
    
    @Override
    double getTripDistance() {
        return distance;
    }
    
    @Override
    String getName() {
        return "Sonata";
    }
}
