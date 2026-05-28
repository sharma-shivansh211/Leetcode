class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        int arr[] = new int[a+b];
        int i,j,k;
        for (i = 0, j = 0, k = 0; j < a && k < b; i++) {
            if(nums1[j] <= nums2[k]){
                arr[i] = nums1[j++];
            }else if(nums1[j] > nums2[k]){
                arr[i] = nums2[k++];
            }
        }
        while(j < a){
            arr[i++] = nums1[j++];
        }
        while(k < b){
            arr[i++] = nums2[k++];
        }
        int length = arr.length;
        if(length %2 == 0){
            return (arr[(length)/2] + arr[(length - 1)/2])/2.0;
        }else{
            return (arr[length/2]);
        }
    }
}