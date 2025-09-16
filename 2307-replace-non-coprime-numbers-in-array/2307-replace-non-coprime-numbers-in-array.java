class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int num:nums){
            while(!list.isEmpty()){
                int n=list.get(list.size()-1);
                int gcd=gcd(n,num);
                if(gcd==1)break;
                list.remove(list.size() - 1);
                long lcm = (long) n / gcd * num; 
                num=(int)lcm;
            }
            list.add(num);
        }
        return list;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}