public class BinarySearch {
    /**
     * return the index of the value in the array
     */
    static int binarysearch(int arr[], int left, int right, int value) {
        int middle = left + (right - left) / 2;
        if (arr[middle] == value) return middle;
        else if (arr[middle] < value) {
            left = middle;
            return binarysearch(arr, left+1, right, value);
        } else  {
            right = middle;
            return binarysearch(arr, left, right-1, value);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 8, 10, 11, 16, 18, 22};
        System.out.println(binarysearch(arr,0,arr.length-1,22));
    }
}
