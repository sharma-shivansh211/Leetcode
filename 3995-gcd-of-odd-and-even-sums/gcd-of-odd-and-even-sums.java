class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumeven = 0;
        int sumodd = 0;
        for(int i = 1; i <= n ; i++){
            sumeven+= 2*i;
        }
        for(int i = 0; i < n ; i++){
            sumodd+= 2*i + 1;
        }
        return sumeven - sumodd;
    }
}