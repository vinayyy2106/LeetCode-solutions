class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[] temp=new int[m*n];
        int ind=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                temp[ind]=grid[i][j];
                ind++;
            }
        }
        k %= (m * n);
        int f=0;
        int l=m*n-1;
        while(f<l){
            int t=temp[f];
            temp[f]=temp[l];
            temp[l]=t;
            f++;
            l--;
        }
        f=0;
        l=k-1;
        while(f<l){
            int t=temp[f];
            temp[f]=temp[l];
            temp[l]=t;
            f++;
            l--;
        }
        f=k;
        l=m*n-1;
        while(f<l){
            int t=temp[f];
            temp[f]=temp[l];
            temp[l]=t;
            f++;
            l--;
        }
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> in=new ArrayList<>();
        int i=0;
        while(i<n*m){
            if(i!=0 && i%n==0){
                ans.add(in);
                in=new ArrayList<>();
                in.add(temp[i]);
            }else{
                in.add(temp[i]);
            }
            i++;
        }
        ans.add(in);
        return ans;
    }
}