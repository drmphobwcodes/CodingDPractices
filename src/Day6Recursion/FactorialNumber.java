package Day6Recursion;

public class FactorialNumber {
    public int factorialNumber(int n) {
        if(n == 0) {
            return 1;
        }

        return n * factorialNumber(n - 1);
    }
}
