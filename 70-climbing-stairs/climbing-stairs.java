class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        return fib(arr, n);
    }
    public int fib(int[] arr, int n){
        if(arr[n] != 0) return arr[n];
        if(n == 1 || n == 0) return 1;
        arr[n] = fib(arr,n-1) + fib(arr,n-2);
        return arr[n];
    }
}