package crackingCodingInterview.array;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

public class ArrayExercises {
    public static void main(String[] args) throws Exception {
        int[] arr = {1,2,3,4,5,6};
        int[] arr2 = {1,3,5,4,6,7,32,4,68,8};
        System.out.println(mostFrequent(arr));
        System.out.println(Arrays.toString(commonElement(arr,arr2)));
        System.out.println(Arrays.toString(shiftArray(arr,2)));
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

//    ex2: common elements
    static int[] commonElement(int[] arr1, int[] arr2) throws Exception {
        if(arr1.length == 0 || arr2.length == 0) return new int[0];
        List<Integer> resList = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i],0);
        }
        for (int i = 0; i < arr2.length; i++) {
            if(map.containsKey(arr2[i]))
                resList.add(arr2[i]);
        }
        //Convert to set to truncate duplicate
        Set<Integer> resSet = new HashSet<>(resList);
        int[] resArr = new int[resSet.size()];
        int index = 0;
        //Iterate through Set
        for(Integer i : resSet){
            resArr[index] = i;
            index ++;
        }
        return resArr;
    }

//    ex3: shift array by s index
    static int[] shiftArray(int[] arr, int s){
        if(s ==0) return arr;
        int[] copyArr = Arrays.copyOf(arr,arr.length);
        for (int i = 0; i < arr.length; i++) {
            if(i+s < arr.length){
                arr[i+s] = copyArr[i];
            }
            else{
                arr[i+s-arr.length] = copyArr[i];
            }
        }
        return arr;
    }
}
