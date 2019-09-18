package String;

import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String text = "long    long long   longg  long    ";
        WordCloudData actual = new WordCloudData(text);
        actual.populateWordsToCounts(text);
        actual.getWordsToCounts();
        System.out.println("grape".compareToIgnoreCase("orange"));
        HashSet<Integer> set = new HashSet<>();
        set.add(7);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(2);
        for(Integer i : set){
            System.out.println(i);
        }

    }
    public static class WordCloudData {

        private Map<String, Integer> wordsToCounts = new HashMap<>();

        private void populateWordsToCounts(String inputString) {

            // count the frequency of each word
            // inputString = inputString.toLowerCase();
            inputString = inputString.trim();
            char[] arr = inputString.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                Character c = arr[i];
                if ( !((c >=97 && c<=122) || (c>=65 && c<= 90))) {
                    arr[i] = ' ';
                }
            }
            boolean hit = false;
            for(int i = 0 ; i < arr.length;i++){
                if(hit && arr[i] == ' '){
                    arr[i] = '\0';
                }else if(arr[i] == ' '){
                    hit = true;
                }else {
                    hit = false;
                }
            }
            inputString = String.valueOf(arr);
            System.out.println(inputString);
            String[] strings = inputString.split(" ");
            for (String s : strings) {
                s = s.trim();
                s = s.toLowerCase();
                if (!wordsToCounts.containsKey(s))
                    wordsToCounts.put(s, 1);
                else {
                    wordsToCounts.put(s, wordsToCounts.get(s) + 1);
                }

            }


            System.out.println();
        }

        public WordCloudData(String inputString) {
            populateWordsToCounts(inputString);
        }

        public Map<String, Integer> getWordsToCounts() {
            return wordsToCounts;
        }
    }
}
