class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //as discussed in strivers vdeo 
        // int i=m-1;
        // int j=0;
        // while(i!=-1 && j<n){
        //     if(nums1[i]>nums2[j]){
        //         int temp=nums1[i];
        //         nums1[i]=nums2[j];
        //         nums2[j]=temp;
        //         i--;
        //         j++;
        //     }else{
        //         break;
        //         //as arrays are sorted if elements at particular index are as expecte then we can break as other elements would be also at correct place
        //     }
        // }
        // for(int k=0;k<n;k++){
        //     nums1[m+k]=nums2[k];
        // }
        // Arrays.sort(nums1);
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                i--;
                k--;
            }else{
                nums1[k]=nums2[j];
                k--;
                j--;
            }
        }
        while(j>=0){
            nums1[k]=nums2[j];
            j--;
            k--;
        }
    }
}