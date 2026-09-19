class Solution {
    public void duplicateZeros(int[] arr) {
        int[] soln = new int[arr.length];
        for(int i = 0, j = 0; i < arr.length && j < arr.length ; i++ ){
            soln[j++] = arr[i];
            if(j >= arr.length) break;
            if(arr[i] == 0) soln[j++] = arr[i];
        }
        for(int i = 0; i < arr.length  ; i++ ){
            arr[i] = soln[i];
        }
    }
}