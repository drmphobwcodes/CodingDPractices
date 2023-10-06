package Day1ArrayString;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        // Initialize a boolean variable to keep track of whether or not there are any duplicate elements
        boolean hasDuplicate = false;

        // Iterate through the array using a for loop
        for (int i = 0; i < nums.length; i++) {
            // Check if the current element is equal to any of the previous elements in the array
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) {
                    // If a duplicate element is found, set the hasDuplicate variable to true and exit the loop
                    hasDuplicate = true;
                    break;
                }
            }
            // If a duplicate element was found, exit the loop
            if (hasDuplicate) {
                break;
            }
        }

        // Return true if there are any duplicate elements, false otherwise
        return hasDuplicate;
    }
}
