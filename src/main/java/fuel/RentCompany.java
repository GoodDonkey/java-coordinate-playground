package fuel;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    
    private List<Car> cars = new ArrayList<>();
    private static final String NEWLINE = System.getProperty("line.separator");
    public static RentCompany create() {
        return new RentCompany();
    }
    
    public void addCar(Car car) {
        cars.add(car);
    }
    
    public String generateReport() {
        StringBuilder string = new StringBuilder();
        for (Car car : cars) {
            string.append(car.getName()).append(" : ");
            string.append((int) car.getChargeQuantity()).append("리터");
            string.append(NEWLINE);
        }
        return string.toString();
    }
}
