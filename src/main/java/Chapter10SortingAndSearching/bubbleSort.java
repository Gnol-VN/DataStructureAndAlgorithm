package Chapter10SortingAndSearching;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,4,1,2,3,0,-1,6,-8};
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    step++;
                }
                printarr(arr);
            }

        }
        System.out.println(step);


    }
    private static int step = 0;
    public static void printarr(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");

        }
        System.out.println();

    }
}
