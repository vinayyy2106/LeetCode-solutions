class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxValue=0;
        int ans=0;
        for(int cost:costs){
            maxValue=Math.max(maxValue,cost);
        }
        int[] temp= new int[maxValue+1];
        for(int cost:costs){
            temp[cost]++;
        }
        for(int i=1;i<temp.length;i++){
            if(temp[i]!=0){
                if(i<=coins){
                    int count = Math.min(temp[i], coins / i);
                    coins-=(count*i);
                    ans+=count;
                }
            }
        }
        return ans;
    }
}