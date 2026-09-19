class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> num = new HashSet<>();
        for(int i = 0 ; i < nums.length ;i++){
            num.add(nums[i]);
        }
        if(nums.length == num.size()) return false;
        return true;
    }
}