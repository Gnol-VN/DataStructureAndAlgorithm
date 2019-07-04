package crackingCodingInterview.array;

import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArray {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7};
        // Get the Array
        List<Integer> intlist = new ArrayList<>();
        for (int i = 0; i < arr.length; i   ++) {
            intlist.add(arr[i]);
        }
        System.out.println(Arrays.toString(intlist.toArray()));
        System.out.println(intlist.contains(3));

        Integer[] b = intlist.toArray(new Integer[2]);
        System.out.println(b.length);


        int[] arr2 = {1,3,5,7};
        System.out.println(Arrays.equals(arr,arr2)   );

        int[] arr3 = Arrays.copyOf(arr2,arr2.length+3);
        int[] concat=ArrayUtils.addAll(arr,arr2);
        intlist.add(1,8);
    }
}
