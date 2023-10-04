package Day5Hashing;

public class KthSmallestElement {
    public int kthSmallestElement(int[] arr, int k) {
        int n = arr.length;
        int[] count = new int[1000001];

        for(int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        int ans = 0;

        for(int i = 0; i < 1000001; i++) {
            if(count[i] != 0) {
                k -= count[i];
            }

            if(k <= 0) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}
