package crackingCodingInterview.Chapter1ArrayAndString;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PermutationString {
    public static void main(String[] args) {
        System.out.println(isPermutation("long", "gnol"));
    }

    static boolean isPermutation(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int n = arr1.length;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n; i++){
            if(!map.containsKey(arr1[i]))
                map.put(arr1[i], 1);
            else{
                int repitition = map.get(arr1[i]);
                map.put(arr1[i], repitition+1);
            }
        }

        for(int i = 0 ; i < n; i++ ){
            if(!map.containsKey(arr2[i]))
                return false;
            else{
                int repitition = map.get(arr2[i]);
                map.put(arr2[i], repitition+1);
            }
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() %2 !=0)
                return false;
        }

        return true;
    }
}
