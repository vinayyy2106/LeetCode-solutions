class Solution {
    public int maximum69Number (int num) {
        List<Integer> list=new ArrayList<>();
        while(num>0){
            int div=num%10;
            num=num/10;
            list.add(div);
        }
        int count=0;
        int val=0;
        for(int i=list.size()-1;i>=0;i--){
            int n=list.get(i);
            if(n==9){
                val=val*10+n;
                continue;
            }
            else if(n==6 && count==0){
                count++;
                val=val*10+9;
            }else{
                val=val*10+n;
            }
        }
        return val;
    }
}