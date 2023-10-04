package Day6Recursion;

public class FibonnacciNum {
    public int fibonnacciNum(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return fibonnacciNum(n - 1) + fibonnacciNum(n - 2);
    }
}
