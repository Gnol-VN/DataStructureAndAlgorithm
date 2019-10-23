package practice;

public class ReverseHelloWorld {
    public static void main(String[] args) {
        String s = "Hello, world";
        StringBuilder builder = new StringBuilder();
        String[] arr = s.split(" ");
        for (int i = arr.length-1; i >=0; i--) {
            if(arr[i].endsWith(",")){
                builder.append(",");
                arr[i] = arr[i].substring(0, arr[i].length()-1);
            }


            builder.append(arr[i]);
            builder.append(" ");
        }
        System.out.println(builder.toString().trim());
    }
}
