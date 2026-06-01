class Solution {
    public boolean isPalindrome(int x) {
        if( x < 0)
            return false;
        int n = String.valueOf(Math.abs(x)).length();
        for(int i = n-1, j =0 ; j < i ;i--, j++){
            int a = (x /((int)(Math.pow(10,i))))%10;
            int b = (x /((int)(Math.pow(10,j))))%10;
            if(a !=b )
                return false;
        }
        return true;
    }
}