class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int diag=-1;
        int area=-1;
        for(int[] dim:dimensions){
            int diagonal=dim[0]*dim[0]+dim[1]*dim[1];
            int ar=dim[0]*dim[1];
            if(diagonal>diag){
                diag=diagonal;
                area=ar;
            }
            if(diagonal==diag){
                area=Math.max(area,ar);
            }
        }
        return area;
    }
}