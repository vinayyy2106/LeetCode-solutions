class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            if(target>matrix[i][n-1]){
                continue;
            }else{
                for(int j=0;j<n;j++){
                    
                    if(search(matrix[i],target))return true;
                    
                }
            }
            
        }
        return false;
    }
     public boolean search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]>target){
                end=mid-1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}