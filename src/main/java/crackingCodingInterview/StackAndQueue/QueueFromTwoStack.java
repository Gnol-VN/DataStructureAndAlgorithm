package crackingCodingInterview.StackAndQueue;

import java.util.Stack;

public class QueueFromTwoStack {
    private Stack<Integer> oldestStack = new Stack<>();
    private Stack<Integer> newestStack = new Stack<>();

    public void enqueue(int value){
        newestStack.push(value);
    }

    public int dequeue(){
        if(oldestStack.isEmpty()){

            while(!newestStack.isEmpty()){
                int peekValue = newestStack.pop();
                oldestStack.push(peekValue);
            }

        }
        System.out.println(oldestStack.peek());
        return oldestStack.pop();
    }

    public static void main(String[] args) {
        QueueFromTwoStack queueFromTwoStack = new QueueFromTwoStack();
        queueFromTwoStack.enqueue(1);
        queueFromTwoStack.enqueue(2);
        queueFromTwoStack.enqueue(3);
        queueFromTwoStack.dequeue();
        queueFromTwoStack.dequeue();
        queueFromTwoStack.dequeue();
        queueFromTwoStack.enqueue(4);
        queueFromTwoStack.enqueue(5);
        queueFromTwoStack.dequeue();
    }

}
