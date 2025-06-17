class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> valueStorage=new HashMap<>();
        for(int num:nums){
            if(valueStorage.containsKey(num)){
                valueStorage.replace(num,valueStorage.get(num)+1);
            }else{
                valueStorage.put(num,1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
        new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer,Integer> l:valueStorage.entrySet()){
            minHeap.add(l);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[] list=new int[k];
        int i=0;
        while(minHeap.size()!=0){
            list[i]=minHeap.poll().getKey();
            i++;
        }
        return list;
    }
}