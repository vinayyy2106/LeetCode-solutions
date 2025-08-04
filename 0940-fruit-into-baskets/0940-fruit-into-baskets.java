class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length==1 || fruits.length==2)return fruits.length;
        int basketOne=fruits[0];
        int i=1;
        while(i < fruits.length && fruits[i]==basketOne){
            i++;
        }
         if(i == fruits.length) return fruits.length;
        int basketTwo=fruits[i];
        int count=i+1;
        int l=0;
        int h=count;
        while(h<fruits.length && l<fruits.length){
            if(fruits[h]!=basketOne && fruits[h]!=basketTwo){
                int newL = h - 1;
                while (newL > l && fruits[newL - 1] == fruits[newL]) {
                    newL--;
                }
                l = newL;
                basketOne=fruits[l];
                basketTwo=fruits[h];
                count=Math.max(h-l+1,count);
                h++;
            }else{
                count=Math.max(h-l+1,count);
                h++;
            }
        }
        return count;
    }
}