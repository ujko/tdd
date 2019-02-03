package fibonacci;

public class Fibonacci {

    public int doFibonacci(int a) {
        if(a < 0) {
            throw new IllegalArgumentException("LIczba powinna być dodatnia");
        }
        if (a<=1) {
            return a;
        }
        return doFibonacci(a - 1)+ doFibonacci(a - 2);
    }

}
