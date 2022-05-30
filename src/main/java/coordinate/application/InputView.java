package coordinate.application;

import coordinate.domain.TwoDimensionalCoordinate;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    
    public static TwoDimensionalCoordinate[] receiveInput() {
        System.out.println("좌표를 입력하세요");
        String input = scanner.nextLine();
        
        String[] split = input.split("-");
        String[] coordinateArray1 = split[0].replaceAll("[()]", "").split(",");
        String[] coordinateArray2 = split[1].replaceAll("[()]", "").split(",");
    
        TwoDimensionalCoordinate coordinate1 = new TwoDimensionalCoordinate(Double.parseDouble(
                coordinateArray1[0]), Double.parseDouble(coordinateArray1[1]));
        TwoDimensionalCoordinate coordinate2 = new TwoDimensionalCoordinate(Double.parseDouble(
                coordinateArray2[0]), Double.parseDouble(coordinateArray2[1]));
        
        return new TwoDimensionalCoordinate[]{coordinate1, coordinate2};
    }
}
