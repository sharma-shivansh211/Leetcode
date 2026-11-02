
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] arr = nums.clone();
        for(int i = nums.length-1 ; i >= 0 ; i--){
            int a = i - k;
            if(a < 0) a = nums.length + a;
            nums[i] = arr[a];
        }
    }
}