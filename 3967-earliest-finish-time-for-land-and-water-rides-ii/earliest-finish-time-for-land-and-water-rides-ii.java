import java.util.*;

class Solution {

    static class Helper {
        int[] start;
        int[] prefixMinDur;
        int[] suffixMinFinish;
        int n;

        Helper(int[] s, int[] d) {
            n = s.length;

            int[][] rides = new int[n][2];
            for (int i = 0; i < n; i++) {
                rides[i][0] = s[i];
                rides[i][1] = d[i];
            }

            Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

            start = new int[n];
            prefixMinDur = new int[n];
            suffixMinFinish = new int[n];

            for (int i = 0; i < n; i++) {
                start[i] = rides[i][0];
            }

            prefixMinDur[0] = rides[0][1];
            for (int i = 1; i < n; i++) {
                prefixMinDur[i] = Math.min(prefixMinDur[i - 1], rides[i][1]);
            }

            suffixMinFinish[n - 1] =
                    rides[n - 1][0] + rides[n - 1][1];

            for (int i = n - 2; i >= 0; i--) {
                suffixMinFinish[i] = Math.min(
                        suffixMinFinish[i + 1],
                        rides[i][0] + rides[i][1]
                );
            }
        }

        int query(int t) {
            int pos = lowerBound(start, t);

            int ans = Integer.MAX_VALUE;
            if (pos < n) {
                ans = Math.min(ans, suffixMinFinish[pos]);
            }
            if (pos > 0) {
                ans = Math.min(ans, t + prefixMinDur[pos - 1]);
            }

            return ans;
        }

        private int lowerBound(int[] arr, int target) {
            int l = 0, r = arr.length;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (arr[mid] < target) l = mid + 1;
                else r = mid;
            }
            return l;
        }
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        Helper water = new Helper(waterStartTime, waterDuration);
        Helper land = new Helper(landStartTime, landDuration);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            int landFinish = landStartTime[i] + landDuration[i];
            ans = Math.min(ans, water.query(landFinish));
        }
        for (int i = 0; i < waterStartTime.length; i++) {
            int waterFinish = waterStartTime[i] + waterDuration[i];
            ans = Math.min(ans, land.query(waterFinish));
        }
        return ans;
    }
}