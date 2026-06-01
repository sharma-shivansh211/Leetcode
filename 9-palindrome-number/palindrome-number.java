class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int right = 1;
        while (x / right >= 10) {
            right *= 10;
        }

        int left = 1;

        while (left < right) {
            int a = (x / right) % 10;
            int b = (x / left) % 10;

            if (a != b) return false;

            left *= 10;
            right /= 10;
        }

        return true;
    }
}