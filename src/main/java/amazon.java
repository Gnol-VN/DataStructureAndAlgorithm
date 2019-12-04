import java.util.*;

//23280704405071
public class amazon {
    // with exactly k unique characters
    public static void main(String[] args) {
        ALNode head = new ALNode(28);
        ALNode original = head;

        head.next =   new ALNode(23);
        head.arbitrary = head.next;
        head = head.next;
        head.next =   new ALNode(28);
        head.arbitrary = head.next;

        head = head.next;
        head.next =   new ALNode(13);
        head.arbitrary = head.next;
        head = head.next;
        head.arbitrary = original;

        head.next = null;
        ALNode newHead = deepCopy(original);
        System.out.println("Long");

        Map<String, Integer> map = new HashMap<>();
        int max = 0;

        for(Map.Entry<String, Integer> i : map.entrySet()){
            if(i.getValue() > max){
                max = i.getValue();
            }
        }



    }

    public static ALNode deepCopy(ALNode head)
    {
        // WRITE YOUR CODE HERE
        ALNode newHead  = new  ALNode(head.value);
        ALNode original = head;
        ALNode walking = newHead;
        while(head.next != null){
            ALNode head1 = new ALNode(head.next.value);
            walking.next = head1;
            head = head.next;
            walking = head1;
        }

        head = original;
        walking = newHead;


        Map<ALNode, Integer> map = new HashMap<>();
        map.put(head, 0);
        int i = 0;
        while(head.next != null){
            i++;
            head = head.next;
            map.put(head,i);
        }
        int length = i+1;
        i=0;
        head = original;

        int index =0;
        walking = newHead;
        ALNode walking1 = newHead;
        while(walking.next != null){
            index =  map.get(head.arbitrary);
            for (int j = 0; j < index; j++) {
                walking1 = walking1.next;
            }
            walking.arbitrary = walking1;
            walking  = walking.next;
            head = head.next;
            walking1 = newHead;
        }
        index =  map.get(head.arbitrary);
        for (int j = 0; j < index; j++) {
            walking1 = walking1.next;
        }
        walking.arbitrary = walking1;
        head = head.next;
        walking1 = newHead;
        return newHead;
    }
}

class ALNode{
    int value;
    ALNode next;
    String name;
    ALNode arbitrary;
    private double d;
    List<Thumb> thumbList = new ArrayList<>();
    public ALNode(int value) {
        this.value = value;
        this.next = null;
        this.arbitrary = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ALNode getNext() {
        return next;
    }

    public void setNext(ALNode next) {
        this.next = next;
    }

    public ALNode getArbitrary() {
        return arbitrary;
    }

    public void setArbitrary(ALNode arbitrary) {
        this.arbitrary = arbitrary;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public ALNode() {
        this.value = -1;
        this.next = null;
        this.arbitrary = null;
    }
}
class Thumb{

}