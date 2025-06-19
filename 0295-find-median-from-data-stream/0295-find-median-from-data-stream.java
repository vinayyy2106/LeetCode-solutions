class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        int minSize=minHeap.size();
        int maxSize=maxHeap.size();
        if(maxSize==0 || num<=maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }else if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
    }
        // else if(minSize==maxSize){
        //     if(num>maxHeap.peek()){
        //         // maxHeap.offer(minHeap.poll());
        //         minHeap.offer(num);
        //     }else{
        //         maxHeap.offer(num);
        //     }
        // }else{
        //     if(minSize==0){
        //         if(num>maxHeap.peek()){
        //             minHeap.offer(num);
        //         }else{
        //             minHeap.offer(maxHeap.poll());
        //             maxHeap.offer(num);
        //         }
        //     }else if(num>=minHeap.peek()){
        //         minHeap.offer(num);
        //     }else{
        //         minHeap.offer(maxHeap.poll());
        //         maxHeap.offer(num);
        //     }
        // }
    }
    
    public double findMedian() {
        int minSize=minHeap.size();
        int maxSize=maxHeap.size();
        if(minSize==maxSize){
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }else{
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */