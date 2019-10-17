package practice.leetcode;

import java.util.Stack;

public class L678ValidParenthesisString {
    public static void main(String[] args) {
        String s = "((*)(*()(())())())()()((()())((()))(*";
        char[] arr = s.toCharArray();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> arterisk = new Stack<>();
        if(arr.length == 0) System.out.println(true);
        if(arr[0] == ')') System.out.println(false);

        for(int i = 0; i < arr.length; i++){
            if(stack1.isEmpty()){
                if(arr[i] == '*') arterisk.push(arr[i]);
                else stack1.push(arr[i]);
            }


            else{
                Character checking = stack1.peek();
                if(checking == '('){
                    if(arr[i] == ')')
                        stack1.pop();
                    if(arr[i] == '(')
                        stack1.push(arr[i]);
                }
                else if(checking == ')'){
                    if(arr[i] == ')')
                        stack1.push(arr[i]);
                    if(arr[i] == '(')
                        stack1.pop();

                }

                if(arr[i] =='*'){
                    arterisk.push(arr[i]);
                }
            }
        }


        if(stack1.size() <= arterisk.size()) System.out.println(true);
        if(stack1.isEmpty()) System.out.println(true);
        else System.out.println(false);
    }
}
