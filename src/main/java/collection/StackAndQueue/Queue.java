package collection.StackAndQueue;


/**
 * Head 5 <- 4 <- 3 <- 2 <- 1 Tail
 * Method: enqueue, dequeue
 */
public class Queue {
    private static class Node{
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    Node head;
    Node tail;

    public void enqueue(int value){
        Node node = new Node(value);
        if(head == null){
            tail = node;
            head = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    public int dequeue(){
        int result = head.value;
        head = head.next;
        return result;
    }
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println("DONE");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
