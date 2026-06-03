import java.util.*;

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        ans = Math.min(ans,
                solve(landStartTime, landDuration,
                      waterStartTime, waterDuration));

        ans = Math.min(ans,
                solve(waterStartTime, waterDuration,
                      landStartTime, landDuration));

        return ans;
    }

    private int solve(int[] firstStart, int[] firstDur,
                      int[] secondStart, int[] secondDur) {

        int m = secondStart.length;

        int[][] rides = new int[m][2];
        for (int i = 0; i < m; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDur[i];
        }

        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

        int[] starts = new int[m];
        int[] prefMinDur = new int[m];
        int[] suffMinFinish = new int[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
        }

        prefMinDur[0] = rides[0][1];
        for (int i = 1; i < m; i++) {
            prefMinDur[i] = Math.min(prefMinDur[i - 1], rides[i][1]);
        }

        suffMinFinish[m - 1] = rides[m - 1][0] + rides[m - 1][1];
        for (int i = m - 2; i >= 0; i--) {
            suffMinFinish[i] = Math.min(
                    suffMinFinish[i + 1],
                    rides[i][0] + rides[i][1]
            );
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {

            int finishFirst = firstStart[i] + firstDur[i];

            int idx = upperBound(starts, finishFirst);

            if (idx > 0) {
                ans = Math.min(
                        ans,
                        finishFirst + prefMinDur[idx - 1]
                );
            }

            if (idx < m) {
                ans = Math.min(
                        ans,
                        suffMinFinish[idx]
                );
            }
        }

        return ans;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}