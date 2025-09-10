package ejercicio_2;

public class ColaArreglo {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public ColaArreglo(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }


    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
            return;
        }
        if (rear == maxSize - 1) { // wrap around
            rear = -1;
        }
        queueArray[++rear] = value;
        nItems++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Indicating queue is empty
        }
        int temp = queueArray[front++];
        if (front == maxSize) { // wrap around
            front = 0;
        }
        nItems--;
        return temp;
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot retrieve top.");
            return -1; // Indicating queue is empty
        }
        return queueArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }
}
