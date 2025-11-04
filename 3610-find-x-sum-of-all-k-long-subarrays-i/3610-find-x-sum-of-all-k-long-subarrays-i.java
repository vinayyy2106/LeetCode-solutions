class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> mp = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            }
            PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> (a.count == b.count ? (b.num - a.num) : (b.count - a.count))
            );

            for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                int num = entry.getKey();
                int count = entry.getValue();
                pq.offer(new Pair(num, count));
            }

            int sum = 0;
            int cnt = 0;
            while (!pq.isEmpty() && cnt < x) {
                Pair p = pq.poll();
                sum += p.num * p.count;
                cnt++;
            }

            ans[i] = sum;
        }

        return ans;
    }
    
}
class Pair{
    int num;
    int count;
    public Pair(int num,int count){
        this.num=num;
        this.count=count;
    }
}