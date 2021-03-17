public class CircleArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void push(int n) {
        if (isFull()) {
            throw new RuntimeException("Full");
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public int getSize() {
        return (rear + maxSize - front) % maxSize;
    }

    public void showAll() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }

        for (int i = front; i < front + getSize(); i++) {
            System.out.println(arr[i % maxSize]);
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Empty");
        }
        return arr[front];
    }
}
