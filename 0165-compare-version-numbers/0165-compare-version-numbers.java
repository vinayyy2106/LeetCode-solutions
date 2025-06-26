class Solution {
    public int compareVersion(String version1, String version2) {
        String[] words_1 = version1.split("\\.");
        String[] words_2 = version2.split("\\.");
        int n=Math.max(words_1.length,words_2.length);
        // System.out.println(words_1.length);
        // System.out.println(words_2.length);
        for(int i=0;i<n;i++){
            int v1=i < words_1.length ? Integer.parseInt(words_1[i]) : 0;
            int v2=i < words_2.length ? Integer.parseInt(words_2[i]) : 0;
            if(v1==v2){
                continue;
            }else if(v1<v2){
                return -1;
            }else{
                return 1;
            }
        }
        return 0;
    }
}