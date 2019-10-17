package practice.leetcode;

public class L151ReverseString {
    public static void main(String[] args) {
        String s = "a good   example";
        s = s.trim();
        String[] arr = s.split(" ");
        StringBuilder build = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = arr[i].trim();
            if(arr[i].equals("")) continue;
            build.append(arr[i]);
            build.append(" ");
        }

        System.out.println(build.toString().trim());
    }
}
