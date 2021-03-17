public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize)
    {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = -1; // 指向队列头，元素头的前一个位置
        rear = -1; // 指向队列尾，当前队列的最后一个元素
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void push(int n) {
        if (isFull()) {
            System.out.println("Full");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty");
        }
        front++;
        return arr[front];
    }

    public void showAll() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.println(arr[i]);
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Empty");
        }
        return arr[front + 1];
    }
}
