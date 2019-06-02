package headFirstJava.javaCollection;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Long", 20);
        scores.put("Chris", 40);
        scores.put("JJ", 60);
        System.out.println(scores);
        System.out.println(scores.get("Long"));;

    }

}
