class Solution {
    public int reverse(int x) {
        boolean negative = x < 0;
        long num = Math.abs((long) x);
        String str = String.valueOf(num);
        str = new StringBuilder(str).reverse().toString();
        long rev = Long.parseLong(str);
        if (negative) {
            rev = -rev;
        }
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) rev;
    }
}