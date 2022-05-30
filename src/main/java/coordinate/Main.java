package coordinate;

import coordinate.application.InputView;
import coordinate.domain.Line;
import coordinate.domain.TwoDimensionalCoordinate;
import coordinate.domain.Value;

public class Main {
    
    public static void main(String[] args) {
        TwoDimensionalCoordinate[] coordinates = InputView.receiveInput();
    
        Line line = new Line(coordinates);
    
        Value distance = line.euclideanDistance();
    
        System.out.println("두 점 사이의 거리는 " + distance);
    }
}
