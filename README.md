
## Value [class]
- 1개의 값을 가진다.
- 1개의 제약조건을 가진다.
- 값을 검증을 수행한다.
- 값이 같은지 비교가능하다
> (계산기 기능 외부화 보류)
- 더할 수 있다.
- 뺼 수 있다.
- 곱할 수 있다.
- 제곱할 수 있다.
- 제곱근을 구할 수 있다.

## ValueCondition [interface]
- 값 조건를 검증한다.

### LessThanOrEquals24ValueRange [class]
- 값이 24 이하인지 검증한다.

## TwoDimensionalCoordinate [class]
- 2개의 값으로 좌표를 표현한다.
- 좌표값이 같은지 비교가능하다.

## AbstractTwoDimensionalShape [abstract class]
- 2개 이상의 좌표값으로 2차원 도형을 표현한다.
- 각 좌표는 같아서는 안된다.

## Line [class]
- 2개의 좌표값을 가지는 선분이다.
- 두 좌표 간의 길이를 계산할 수 있다.

## Rectangle [class]
- 4개의 좌표값을 가지는 직사각형이다.

## Triangle [class]
- 3개의 좌표값을 가지는 삼각형이다.

## EuclideanDistance [interface]
- 두개의 좌표값으로 유클리드 거리를 계산한다.

## SquareArea [interface]
- 좌표값들로 사각형 면적을 계산한다.

## DefaultFormula [class]
- 거리, 면적 구하는 공식을 구현한다.

## InputView [class]

## ResultView [class]
