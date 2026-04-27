import java.io.*;
public class OrderQueue {
    private Order front;
    private Order rear;

    public OrderQueue() {
        front = null;
        rear = null;
    }
    public boolean isEmpty() {
        return front == null;
    }
    public Order getFront() {
        return front;
    }
    public void enqueue(Order o) {
        if (isEmpty()) {
            front = o;
            rear = front;
        }
        else {
            rear.setLink(o);
            rear = o;
        }
    }
    public Order dequeue () throws EmptyQueueException {
        Order answer;
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }
        answer = front;
        front = front.getLink();
        return answer;
    }
    public String peek() throws EmptyQueueException {
        String answer;
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        answer = front.toString();
        return answer;
    }
    public int size() {
        int answer = 0;
        if (isEmpty()) {
            return 0;
        }
        else {
            Order temp = front;
            while (temp != null) {
                answer++;
                temp = temp.getLink();
            }
        }
        return answer;
    }
}
