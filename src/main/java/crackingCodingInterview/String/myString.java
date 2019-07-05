package crackingCodingInterview.String;

public class myString {
    public static void main(String[] args) {
        String a = new String();
        System.out.println(a.isEmpty());
        a.concat("abc");
        a.trim();
        String str1 = "Hello, how how how are you";
        boolean str2 = str1.replace("Hello", "what").contains("abc");
        System.out.println(str2);
        String name = "Long Do Thanh";
        System.out.println(name.substring(5,7));
    }
}
