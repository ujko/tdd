package calc;

public class Calculator {

    public int add(int a, int b) {
//        return Math.addExact(a, b);
        if(a == 0 && b == 0) {
            return 0;
        }
        if((a == Integer.MAX_VALUE || b == Integer.MAX_VALUE) && a == -b) {
            return 0;
        }
        int d = Math.abs(a) + Math.abs(b);
        if(d <= 0) {
            throw new ArithmeticException("Za duze liczby");
        }
    return a + b;
    }

    public double div(double a, double b) {
        if(b == 0.0) {
            throw new IllegalArgumentException("Nie dziel przez zero");
        }
        return a / b;
    }
}
