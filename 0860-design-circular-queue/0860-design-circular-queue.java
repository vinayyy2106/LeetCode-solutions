class MyCircularQueue {
    int[] queue;
    int front = 0, rear = 0, count = 0, size;
    public MyCircularQueue(int k) {
        this.size=k;
        queue = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull())return false;
        queue[rear] = value;
        rear=(rear+1)%size;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())return false;
        front=(front+1)%size;
        count--;
        return true;
    }
    
    public int Front() {
        if(count==0)return -1;
        return queue[front];
    }
    
    public int Rear() {
        if(count==0)return -1;
        return queue[(rear - 1 + size) % size];
    }
    
    public boolean isEmpty() {
        return count==0;
    }
    
    public boolean isFull() {
        return count==size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */