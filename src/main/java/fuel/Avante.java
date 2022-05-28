package fuel;

public class Avante extends Car {
    
    public static final double DISTANCE_PER_LITER = 15;
    public final double distance;
    
    
    public Avante(double distance) {
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
        return "Avante";
    }
}
