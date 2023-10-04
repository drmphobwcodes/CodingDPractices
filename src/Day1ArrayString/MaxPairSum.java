package Day1ArrayString;

public class MaxPairSum {
    public int maxPairSum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, arr[i] + arr[n - 1 - i]);
        }

        return maxSum;
    }
}
