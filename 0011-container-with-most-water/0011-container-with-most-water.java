class Solution {
    public int maxArea(int[] height) {
        int n=height.length-1;
        int l=0;
        int r=n;
        int maxArea=0;
        while(l<r){
            maxArea=Math.max(maxArea,(r-l)*Math.min(height[l],height[r]));
            if(height[l]>height[r]){
                r--;
            }else{
                l++;
            }
        }
        return maxArea;
    }
}