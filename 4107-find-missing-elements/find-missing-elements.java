import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> soln = new ArrayList<>();
        if (nums.length == 0) {
            return soln;
        }
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                continue;
            }
            while (prev + 1 < nums[i]) {
                prev++;
                soln.add(prev);
            }
            prev = nums[i];
        }
        return soln;
    }
}