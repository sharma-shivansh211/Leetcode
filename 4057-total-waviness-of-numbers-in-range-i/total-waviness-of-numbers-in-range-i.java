class Solution {
    public int totalWaviness(int num1, int num2) {
        int w = 0;
        if(num2 < 100) return 0;
        for(int i = num1 ; i <= num2 ; i++){
            int n = String.valueOf(Math.abs(i)).length();
            if(n < 3&& n < 100)
                continue;
            for(int j = n-1, k = n-3; k >= 0 ; j--,k--){
                int a = i/(int)Math.pow(10,j)%10;
                int b = i/(int)Math.pow(10,k+1)%10;
                int c = i/(int)Math.pow(10,k)%10;
                if(a > b && c > b)
                    w++;
                else if(a < b && c < b)
                    w++;
            }
        }
        return w;
    }
}  