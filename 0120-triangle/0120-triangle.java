class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] front=new int[n];
        int[] curr=new int[n];
    for(int i=0;i<n;i++){
        front[i]=triangle.get(n-1).get(i);
    }
    for(int i=n-2;i>=0;i--){
       
        for(int j=i;j>=0;j--){
            int d=triangle.get(i).get(j)+front[j];
            int dg=triangle.get(i).get(j)+front[j+1];
            curr[j]=Math.min(d,dg);;
        }
        front=curr.clone();
    }
    return front[0];
    }
}