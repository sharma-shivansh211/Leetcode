class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                boolean duplicate = false;
                for (int k = i; k < j; k++) {

                    if (s.charAt(k) == s.charAt(j)) {
                        duplicate = true;
                        break;
                    }
                }
                if (duplicate) {
                    break;
                }
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}