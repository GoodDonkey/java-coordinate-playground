package fuel;

public class K5 extends Car {
    
    public static final double DISTANCE_PER_LITER = 13;
    public final double distance;
    
    public K5(double distance) {
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
        return "K5";
    }
}
