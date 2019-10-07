package practice;

import java.util.ArrayList;
import java.util.List;

public class SearchInRotateArr {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,0,1,2};
        List<Integer> list = new ArrayList<>();

        binarySearch(nums,0,nums.length-1,list);
        System.out.print(list.get(0));
    }

    private static  void binarySearch(int[] arr, int left, int right, List<Integer> list){
        int mid = (right - left)/2 + left;
        if(left == mid){
            return;
        }
        if(arr[mid] > arr[mid+1]){
            list.add(mid);



            return;
        }
        else{
            binarySearch(arr,left,mid, list);
            binarySearch(arr,mid,right, list);
        }
        return;
    }
}
