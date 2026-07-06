import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (x, y) -> {
            if (x[0] != y[0])
                return x[0] - y[0];
            return y[1] - x[1];
        });

        int count = 1;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] > end) {
                count++;
                end = intervals[i][1];
            }
        }

        return count;
    }
}