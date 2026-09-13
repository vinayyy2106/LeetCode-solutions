class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> li=new ArrayList<>();
        List<int[]> li1=new ArrayList<>();
        int n=img1.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(img1[i][j]==1){
                    li.add(new int[]{i,j});
                }
                if(img2[i][j]==1){
                    li1.add(new int[]{i,j});
                }
            }
        }
        Map<String,Integer> mp=new HashMap<>();
        int count=0;
        for(int[] arr1:li){
            for(int[] arr2:li1){
                int x=(arr1[0]-arr2[0]);
                int y=(arr1[1]-arr2[1]);
                String key=x+"-"+y;
                int c=mp.getOrDefault(key,0)+1;
                mp.put(key,c);
                count=Math.max(c,count);
            }
        }
        return count;
    }
}