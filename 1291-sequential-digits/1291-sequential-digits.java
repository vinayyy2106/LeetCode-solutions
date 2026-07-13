class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q =new LinkedList<>();
        for(int i=1;i<=8;i++){
            q.offer(i);
        }
        List<Integer> li=new ArrayList<>();
        while(!q.isEmpty()){
            int temp=q.poll();
            if(temp>=low && temp<=high){
                li.add(temp);
            }
            int mod=(temp%10)+1;
            if(mod>9)continue;
            int next=(temp*10)+mod;
            q.offer(next);
        }
        return li;

    }
}