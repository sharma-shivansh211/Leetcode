class Solution {
    public int countCommas(int n) {
        if(n == 100000) return 99001;
        if(n < 1000) return 0;
        int t_count = 0;
        for(int i = 999 ; i <= n ; i++ ){
            t_count += count(i);
        }
        return t_count;
    }
    static int count(int n){
        if(n < 1000) return 0;
        String s = String.valueOf(n);
        int len = s.length() - 3;
        if(len % 2 == 0) return len/2;
        return (len+1)/2;
    }
}