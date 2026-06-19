class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int t = 0;
        for(int i = 0 ; i < gain.length ; i++){
            t += gain[i];
            ans = Math.max(t,ans);
        }
        return ans;
    }
}