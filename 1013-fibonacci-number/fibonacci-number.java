class Solution {
    public int fib(int n) {
        int[] arr = new int[n+1];
        return dpa(arr,n);
        
    }
    public int dpa(int[] arr,int n){
        if(arr[n] != 0) return arr[n];
        if(n == 1) return 1;
        if(n == 0) return 0;
        arr[n] = dpa(arr,n-1) + dpa(arr,n-2);
        return arr[n];
    }
}