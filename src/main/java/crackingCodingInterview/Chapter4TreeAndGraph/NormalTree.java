package crackingCodingInterview.Chapter4TreeAndGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        int value;

        public Node(int value) {
            this.value = value;
        }

        public void insert(int value) {
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

        public static int height(Node node){
            if(node == null){
                return 0;
            }else{
                int leftHeight = height(node.left);
                int rightHeight = height(node.right);

                if (leftHeight <= rightHeight) {
                    return rightHeight +1;
                }else return leftHeight+1;
            }
        }
        public void BFS(){
            Queue<Node> queue = new LinkedList<>();
            Node tempNode = this;
            while(tempNode!= null){
                System.out.print(tempNode.value+" ");
                queue.add(tempNode.left);
                queue.add(tempNode.right);
                tempNode = queue.poll();
            }
        }

    }
    public static void main(String[] args) {
        Node node = new Node(5);
        node.insert(3);
        node.insert(1);
        node.insert(2);
        node.insert(4);
        node.insert(7);
        node.insert(6);
        node.insert(8);
        System.out.println(node.contains(5));
        System.out.println(node.contains(6));
        System.out.println(node.contains(10));
        System.out.println(node.contains(3));
        System.out.println("Done");
        node.printInOrder();
        System.out.println();
        node.printPreOrder();
        System.out.println();
        node.printPostOrder();
        System.out.println();
        System.out.println(Node.height(node));
        System.out.println();
        node.BFS();

    }
}


