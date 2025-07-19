class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        if(t.length()>n)return "";
        int[] arr = new int[128];
        int total_char=t.length();
        int i=0;
        int j=0;
        int start_i=0;
        int win=Integer.MAX_VALUE;
        for(char ch:t.toCharArray()){
            arr[ch ]++;
        }
        while(j<n){
            char ch=s.charAt(j);
            if(arr[ch]>0){
                total_char--;
            }
            arr[ch]--;
            while(total_char==0){
                int currSze=j-i+1;
                if(currSze<win){
                    win=currSze;
                    start_i=i;
                }
                char ch2=s.charAt(i);
                arr[ch2]++;
                if(arr[ch2]>0){
                    total_char++;
                }
                i++;
            }
            j++;
        }
        return win==Integer.MAX_VALUE?"":s.substring(start_i,start_i+win);
    }
}