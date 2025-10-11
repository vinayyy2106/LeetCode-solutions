class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                swap(i,j,i,matrix);
            }
        }
        for(int[] row:matrix){
            reverseArray(0,row.length-1,row);
        }
    }
    public void swap(int i,int j,int k,int[][] matrix){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][k];
        matrix[j][k]=temp;
    }
    public void reverseArray(int i,int j,int[] arr){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}