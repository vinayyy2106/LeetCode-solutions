class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //as discussed in strivers vdeo 
        int i=m-1;
        int j=0;
        while(i!=-1 && j<n){
            if(nums1[i]>nums2[j]){
                int temp=nums1[i];
                nums1[i]=nums2[j];
                nums2[j]=temp;
                i--;
                j++;
            }else{
                break;
                //as arrays are sorted if elements at particular index are as expecte then we can break as other elements would be also at correct place
            }
        }
        for(int k=0;k<n;k++){
            nums1[m+k]=nums2[k];
        }
        Arrays.sort(nums1);
    }
}