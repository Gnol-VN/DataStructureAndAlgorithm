package collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Print the INDICES of elements that sum up to Target
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] twoSum = twoSum(new int[]{2,7,8,9}, 9);
        for(int i: twoSum){
            System.out.print(i+" ");
        }

    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] returnArr = new int[2];
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0 ; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                returnArr[0] = i;
                returnArr[1] = map.get(complement);
                return returnArr;
            }

        }
        return returnArr;
    }
}
