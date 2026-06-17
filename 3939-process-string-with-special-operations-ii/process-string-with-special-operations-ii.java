class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n + 1];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                len[i + 1] = len[i] + 1;
            } else if (c == '*') {
                len[i + 1] = Math.max(0, len[i] - 1);
            } else if (c == '#') {
                len[i + 1] = len[i] * 2;
            } else { // '%'
                len[i + 1] = len[i];
            }

            // prevent overflow if constraints are large
            len[i + 1] = Math.min(len[i + 1], (long) 1e18);
        }

        if (k < 0 || k >= len[n]) return '.';

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            long curLen = len[i + 1];
            long prevLen = len[i];

            if (c >= 'a' && c <= 'z') {
                if (k == curLen - 1) {
                    return c;
                }
            } else if (c == '#') {
                if (k >= prevLen) {
                    k -= prevLen;
                }
            } else if (c == '%') {
                k = curLen - 1 - k;
            }
        }

        return '.';
    }
}