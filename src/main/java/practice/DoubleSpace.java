package practice;


public class DoubleSpace {
    public static void main(String[] args) {
        String s = "  a   b    ced  g  h  ";
        s = s.trim();
        String[] arr = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i <arr.length; i++){
            if(arr[i].equals("")) continue;
            builder.append(arr[i]);
            builder.append(" ");
        }

        System.out.println(builder.toString().trim());
    }
}
