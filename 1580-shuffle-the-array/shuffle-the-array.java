class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        int i = 0;
        int j = 0;
        while(i < 2*n){
            arr[i++] = nums[j];
            arr[i++] = nums[j + n];
            j++;
        }
        return arr;
    }
}