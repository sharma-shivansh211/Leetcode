class Solution {

    private static final int MAX = 1000;
    private static final int INF = 1_000_000_000;

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        return Math.min(
            solve(landStartTime, landDuration,
                  waterStartTime, waterDuration),
            solve(waterStartTime, waterDuration,
                  landStartTime, landDuration)
        );
    }

    private int solve(int[] firstStart, int[] firstDur,
                      int[] secondStart, int[] secondDur) {

        int[] minDur = new int[MAX + 2];
        int[] minFinish = new int[MAX + 2];

        java.util.Arrays.fill(minDur, INF);
        java.util.Arrays.fill(minFinish, INF);

        for (int i = 0; i < secondStart.length; i++) {
            int s = secondStart[i];
            int d = secondDur[i];

            minDur[s] = Math.min(minDur[s], d);
            minFinish[s] = Math.min(minFinish[s], s + d);
        }

        int[] prefMinDur = new int[MAX + 2];
        int[] suffMinFinish = new int[MAX + 3];

        prefMinDur[0] = minDur[0];
        for (int t = 1; t <= MAX; t++) {
            prefMinDur[t] = Math.min(prefMinDur[t - 1], minDur[t]);
        }

        suffMinFinish[MAX + 1] = INF;
        for (int t = MAX; t >= 0; t--) {
            suffMinFinish[t] =
                Math.min(suffMinFinish[t + 1], minFinish[t]);
        }

        int ans = INF;

        for (int i = 0; i < firstStart.length; i++) {

            int finish = firstStart[i] + firstDur[i];

            int f = Math.min(finish, MAX);

            ans = Math.min(ans,
                    finish + prefMinDur[f]);

            if (f + 1 <= MAX + 1) {
                ans = Math.min(ans,
                        suffMinFinish[f + 1]);
            }
        }

        return ans;
    }
}