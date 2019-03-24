package crackingCodingInterview.StackAndQueue;

/**
 * Top 3
 *   ↓
 *   2
 *   ↓
 *   1
 *
 *  Method: Pop, push, peek
 */
public class Stack {
    private static class Node{
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    Node top;
    public void push(int value){
        Node node = new Node(value);
        node.next = top;
        top = node;
    }

    public int peek(){
        return top.value;
    }

    public int pop(){
        int result = top.value;
        top = top.next;
        return result;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(8);
        stack.push(7);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
