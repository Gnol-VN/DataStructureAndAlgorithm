import java.util.*;

public class other {
    public static void main(String[] args) {
        Map<Character, String> map  = new HashMap<>();
        String moore = "\".-\",\"-...\",\"-.-.\",\"-..\",\".\",\"..-.\",\"--.\",\"....\",\"..\",\".---\",\"-.-\",\".-..\",\"--\",\"-.\",\"---\",\".--.\",\"--.-\",\".-.\",\"...\",\"-\",\"..-\",\"...-\",\".--\",\"-..-\",\"-.--\",\"--..\"";

        String[] m = moore.split(",");
        for (int i = 0; i < 26; i++) {
            String[] split = m[i].split("\"");
            m[i]  = split[1];
        }
        for(int i = 0; i <26;i++){
            int ascii = i+97;
            char c  =  (char)ascii;
            map.put(c,m[i]);
        }
        String a = " a";
        char c = 'a';

    }



}