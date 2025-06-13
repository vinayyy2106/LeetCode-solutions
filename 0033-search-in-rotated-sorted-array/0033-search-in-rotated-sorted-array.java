class Solution {
    public int search(int[] nums, int target) {
        int pivot=findPivot(nums);
        // System.out.println(pivot);//the largest element in the the this array
        if(pivot==-1){
            return binarySearch(nums,target,0,nums.length-1);
        }else{
            if(nums[pivot]==target){
                return pivot;
            }
            else if(target>=nums[0]){
                return binarySearch(nums,target,0,pivot-1);
            }
            else{
                return binarySearch(nums,target,pivot+1,nums.length-1);
            }
        }
        
        
    }
    static int findPivot(int[] arr){
            int start=0;
            int end=arr.length-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                // if(mid>start && mid<end){
                    if(mid<end && arr[mid]>arr[mid+1]){
                        return mid;
                    }
                    if( mid>start && arr[mid]<arr[mid-1]){
                        return mid-1;
                    }
                // }
                if(arr[start]<=arr[mid]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
            return -1;
        }
    static int binarySearch(int[] a,int t,int s,int e){
            while(s<=e){
                int m=s+(e-s)/2;
                if(a[m]>t){
                    e=m-1;
                }else if(a[m]<t){
                    s=m+1;
                }else{
                    // System.out.println(m);
                    return m;
                }
            }
            return -1;
        }
}