import java.util.Arrays;

class Solution {
    public int minElement(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = (int) Math.log10(nums[i]) + 1;
            int s = 0;
            for (int j = 0; j < temp; j++) {
                s += nums[i] % 10;
                nums[i] = nums[i] / 10;
            }
            nums[i] = s;
        }
        Arrays.sort(nums);
        return nums[0];
    }
}