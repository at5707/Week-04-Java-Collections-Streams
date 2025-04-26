import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q1=new LinkedList<>();
    private Queue<Integer> q2=new LinkedList<>();
    public void push(int x) {
        q1.add(x);
    }
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        while (q1.size()>1) {
            q2.add(q1.remove());
        }
        int popped=q1.remove();
        swapQueues();
        return popped;
    }
    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        while (q1.size()>1) {
            q2.add(q1.remove());
        }
        int top=q1.remove();
        q2.add(top);
        swapQueues();
        return top;
    }
    public boolean isEmpty() {
        return q1.isEmpty();
    }
    private void swapQueues() {
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
    }
}
public class StackUsingTwoQueuesDemo {
    public static void main(String[] args) {
        MyStack stack=new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element: "+stack.top());
        System.out.println("Popped element: "+stack.pop());
        System.out.println("Top element: "+stack.top());
    }
}
