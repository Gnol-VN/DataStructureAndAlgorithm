package crackingCodingInterview.Chapter4TreeAndGraph;

/**
 * Binary search tree vs binary tree
 * Balance tree vs Unbalanced tree: Balance: the middle value is at the root
 * Do not assume a tree is a perfect tree (number of nodes are exact 2^k - 1
 * Method: Insert, contains, print in-order, preorder, postorder
 * Mấu chốt: check xem Node.left có null hay ko? Node.right có null hay ko?
 */
public class NormalTree {
    public static Boolean aBoolean = false;
    private static class Node {
        Node left;
        Node right;
        double value;

        public Node(double value) {
            this.value = value;
        }

        public void insert(double value) {
            if (this.value > value) {
                if (this.left == null) {
                    this.left = new Node(value);
                } else {
                    this.left.insert(value);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(value);
                } else {
                    this.right.insert(value);
                }
            }
        }

        public boolean contains(int value) {
            if (this.value == value) {
                return true;
            } else {
                if (value < this.value) {
                    if (left == null) {
                        return false;
                    } else return left.contains(value);
                } else {
                    if (right == null) {
                        return false;
                    } else return right.contains(value);
                }
            }
        }

        //Khong co else
        public void printInOrder() {
            if (left != null) {
                left.printInOrder();
            }
            System.out.print(this.value + " ");
            if (right != null) {
                right.printInOrder();
            }
        }

        public void printPreOrder() {
            System.out.print(this.value + " ");
            if (left != null) {
                left.printPreOrder();
            }
            if (right != null) {
                right.printPreOrder();
            }
        }

        public void printPostOrder() {
            if(left != null){
                left.printPostOrder();
            }
            if(right!= null){
                right.printPostOrder();
            }
            System.out.print(this.value +" ");

        }

    }
    public static void main(String[] args) {
        Node node = new Node(5);
        node.insert(3);
        node.insert(2);
        node.insert(2.5);
        node.insert(4);
        node.insert(7);
        node.insert(6);
        node.insert(8);
        System.out.println(node.contains(5));
        System.out.println(node.contains(6));
        System.out.println(node.contains(1));
        System.out.println(node.contains(3));
        System.out.println("Done");
        node.printInOrder();
        System.out.println();
        node.printPreOrder();
        System.out.println();
        node.printPostOrder();


    }
}


