class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int c = 0;
        int t = 0;
        for(int i = cost.length-1 ; i >= 0; i--){
            if( t == 2){
                t = 0;
            }else{
                c += cost[i];
                t++;
            }
        }
        return c;
    }
}