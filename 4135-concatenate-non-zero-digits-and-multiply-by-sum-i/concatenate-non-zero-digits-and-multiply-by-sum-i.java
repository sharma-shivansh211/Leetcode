class Solution {
    public long sumAndMultiply(int n) {
        long soln = 0;
        int sum = 0;
        int a = 0;
        while(n > 0){
            sum += n%10;
            if(n %10 != 0){
                soln += (n%10) * Math.pow(10,a++);
            }
            n = n/10;
        }
        return soln*sum;
    }
}