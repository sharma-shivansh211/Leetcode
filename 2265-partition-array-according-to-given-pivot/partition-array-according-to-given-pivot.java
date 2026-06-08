class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int num : nums) {
            if (num < pivot)
                left.add(num);
            else if (num == pivot)
                equal.add(num);
            else
                right.add(num);
        }
        int[] ans = new int[nums.length];
        int k = 0;
        for (int x : left) ans[k++] = x;
        for (int x : equal) ans[k++] = x;
        for (int x : right) ans[k++] = x;
        return ans;
    }
}