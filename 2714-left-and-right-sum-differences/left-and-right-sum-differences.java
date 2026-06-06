class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] leftsum = new int[nums.length];
        int[] rightsum = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = 0 ; j < i ; j++){
                leftsum[i] += nums[j];
            }
            for(int j = i+1 ; j < nums.length ; j++){
                rightsum[i] += nums[j];
            }
        }
        int[] ans = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            ans[i]= Math.abs(leftsum[i] - rightsum[i]);
        }
        return ans;
    }
}