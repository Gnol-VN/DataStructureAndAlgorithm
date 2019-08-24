package crackingCodingInterview.Chapter4TreeAndGraph;

import java.util.*;

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

        //        public boolean contains(int value) {
//            if (this.value == value) {
//                return true;
//            } else {
//                if (value < this.value) {
//                    if (left == null) {
//                        return false;
//                    } else return left.contains(value);
//                } else {
//                    if (right == null) {
//                        return false;
//                    } else return right.contains(value);
//                }
//            }
//        }
        boolean contains(int value) {
            if (this.value == value) {
                return true;
            }
            if (value < this.value) {
                if (this.left != null) {
                    return this.left.contains(value);
                }

            } else {
                if (this.right != null) {
                    return this.right.contains(value);
                }
            }
            return false;
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
            if (left != null) {
                left.printPostOrder();
            }
            if (right != null) {
                right.printPostOrder();
            }
            System.out.print(this.value + " ");

        }

        public static int height(Node node) {
            if (node == null) {
                return 0;
            } else {
                int leftHeight = height(node.left);
                int rightHeight = height(node.right);

                if (leftHeight <= rightHeight) {
                    return rightHeight + 1;
                } else return leftHeight + 1;
            }
        }

        public void BFS() {
            Queue<Node> queue = new LinkedList<>();
            Node tempNode = this;
            while (tempNode != null) {
                System.out.print(tempNode.value + " ");
                queue.add(tempNode.left);
                queue.add(tempNode.right);
                tempNode = queue.poll();
            }
        }


        public boolean isBalanceTree(Node node, int depth) {
            if (node.left == null) {
                depthArr.add(depth);
            }
            if (node.right == null) {
                depthArr.add(depth);
            }
            if (node.left != null) {
                isBalanceTree(node.left, depth + 1);
            }
            if (node.right != null) {
                isBalanceTree(node.right, depth + 1);
            }
            int maxDepth = Collections.max(depthArr);
            int minDepth = Collections.min(depthArr);
            if(maxDepth - minDepth <=1) return true;
            else return false;
        }


    }

    public static List<Integer> depthArr = new ArrayList<>();

    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) {
        Node node = new Node(5);
        node.insert(3);
//        node.insert(1);
        node.insert(2);
        node.insert(4);
        node.insert(7);
        node.insert(6);
        node.insert(8);
        System.out.println("________________ Contain:");
        System.out.println(node.contains(5));
        System.out.println(node.contains(6));
        System.out.println(node.contains(10));
        System.out.println(node.contains(3));
        System.out.println("_______________ Print:");
        node.printInOrder();
        System.out.println();
        node.printPreOrder();
        System.out.println();
        node.printPostOrder();
        System.out.println("_______________ Height:");
        System.out.println(Node.height(node));
        System.out.println("_______________ BFS:");
        node.BFS();
        System.out.println();
        System.out.println("_______________ Depth of tree to check balance:");
        System.out.println(node.isBalanceTree(node,0));;

    }


}


