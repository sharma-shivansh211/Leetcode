class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> num = new HashSet<>(Arrays.stream(nums).boxed().toList());
        if(nums.length == num.size()) return false;
        return true;
    }
}