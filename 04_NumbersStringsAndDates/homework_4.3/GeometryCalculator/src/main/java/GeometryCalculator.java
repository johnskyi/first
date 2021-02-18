public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        double circleSquare = Math.PI * Math.pow(Math.abs(radius),2);
        return circleSquare;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        double sphereVolume = (4 * Math.PI * Math.pow(Math.abs(radius),3)) / 3;
        return sphereVolume;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        if (Math.abs(a + b)  > Math.abs(c) && Math.abs(a + c)  > Math.abs(b) && Math.abs(c + b)  > Math.abs(a))
        {
            return true;
        }
        else {
            return false;
        }
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        double triangleSquare = 0.0;
        double p = ( a + b + c) / 2;
        if(isTrianglePossible(a, b, c)) {
            triangleSquare = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        else {triangleSquare = -1.0;}
        return triangleSquare;
    }
}
