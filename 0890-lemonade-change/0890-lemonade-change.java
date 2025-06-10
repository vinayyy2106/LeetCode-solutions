class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int five=0;
        int ten=0;
        int twenty=0;
        for(int num:bills){
            if(num==5)five+=1;
            if(num==10){
                if(five>0){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }
            if(num==20){
                if((five>0 && ten>0)){
                    five-=1;
                    ten-=1;
                    twenty++;
                }
                else if(five>2){
                    
                    five-=3;
                    twenty++;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}