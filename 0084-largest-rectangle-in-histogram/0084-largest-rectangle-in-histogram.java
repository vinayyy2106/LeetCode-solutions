class Solution {
    public int largestRectangleArea(int[] heights) {
        int max=0;
        int[] rightSmallest=new int[heights.length];
        int[] leftSmallest=new int[heights.length];
        findleftSmallest(leftSmallest,heights);
        findrightSmallest(rightSmallest,heights);
        for(int i=0;i<heights.length;i++){
            max=Math.max(max,(rightSmallest[i]-leftSmallest[i]-1)*heights[i]);
        }
        return max;
    }
    public void findleftSmallest(int[] left,int[] heights){
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i]=-1;
            }else left[i]=st.peek();
            st.push(i);
        }
    }
    public void findrightSmallest(int[] right,int[] heights){
        Stack<Integer> st=new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i]=heights.length;
            }else right[i]=st.peek();
            st.push(i);
        }
    }
}