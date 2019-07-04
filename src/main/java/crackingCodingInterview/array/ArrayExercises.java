package crackingCodingInterview.array;

import java.util.*;

public class ArrayExercises {
    public static void main(String[] args) {
        int[] arr = {1,3,1,1,4,5,5,5,5,5};
        System.out.println(mostFrequent(arr));
    }

    //    Ex1: Most frequent element in array
    static int mostFrequent(int[] arr) {
        if(arr.length == 0) return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i]) == false){
                map.put(arr[i],1);
            }else{
                int repitition = map.get(arr[i]);
                repitition++;
                map.put(arr[i], repitition);
            }
        }

        int maxRepp = 0, res = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()>maxRepp){
                maxRepp = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
}
