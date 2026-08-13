class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            if(dig_prod(n) % t == 0) return n;
            n=n+1;
        }
    }
    static int dig_prod(int num){
        int product = 1;
        while(num !=0){
            product *= num%10;
            num = num/10;
        }
        return product;
    }
}