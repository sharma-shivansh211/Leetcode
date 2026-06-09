class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int[] arr = {1, 2, 3};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int start = 0; start < nums.length; start++) {
            if(nums[start] > max) max = nums[start];
            if(nums[start] < min) min = nums[start];

        }
        long ans = (long)(max - min) * (long)k;
        return ans;
    }
}