class Solution {
    public int[] findNSR(int[] height){
        Stack<Integer> st=new Stack<>();
        int n=height.length;
        int[] NSR=new int[n];
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                NSR[i]=n;
            }else{
                while(!st.isEmpty() && height[st.peek()] >=height[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    NSR[i]=n;
                }else{
                    NSR[i]=st.peek();
                }
            }
            st.push(i);
        }
        return NSR;
    }
    public int[] findNSL(int[] height){
        Stack<Integer> st=new Stack<>();
        int n=height.length;
        int[] NSL=new int[n];
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                NSL[i]=-1;
            }else{
                while(!st.isEmpty() && height[st.peek()]>=height[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    NSL[i]=-1;
                }else{
                    NSL[i]=st.peek();
                }
            }
            st.push(i);
        }
        return NSL;
    }
    public int findMax(int[] height){
        //width : NSR[i]-NSL[i]-1
        //height - already undhi
        int[] NSR=findNSR(height);
        int[] NSL=findNSL(height);
        int maxArea=0;
        for(int i=0;i<height.length;i++){
            int w=NSR[i]-NSL[i]-1;
            int h=height[i];
            maxArea=Math.max(maxArea,h*w);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[] height=new int[n];
        for(int i=0;i<n;i++){
            height[i]=matrix[0][i]=='1'?1:0;
        }
        int maxArea=findMax(height);
        for(int row=1;row<m;row++){
            for(int i=0;i<n;i++){
                if(matrix[row][i]=='1'){
                    height[i]+=1;
                }else{
                    height[i]=0;
                }
            }
            maxArea=Math.max(maxArea,findMax(height));
        }
        return maxArea;
    }
}