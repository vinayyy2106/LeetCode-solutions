class Solution {
    public double soupServings(int n) {
        if(n>=5000)return 1.0;
        double[][] arr=new double[n+1][n+1];
        int[][] vals=new int[][]{{100,0},{75,25},{50,50},{25,75}};
        for(double[] ar:arr){
            Arrays.fill(ar,-1.0);
        }
        return helper(arr,n,n,vals);
    }
    public double helper(double[][] arr,int A,int B,int[][] vals){
        if(A<=0 && B<=0)return 0.5;
        if(A<=0)return 1.0;
        if(B<=0)return 0.0;
        if(arr[A][B]!=-1.0)return arr[A][B];
        double prob=0.0;
        for(int i=0;i<vals.length;i++){
            prob+=helper(arr,A-vals[i][0],B-vals[i][1],vals);
        }
        return arr[A][B]=0.25*prob;
    }
}