package Chapter10SortingAndSearching;

public class insertionsort {
    public static void main(String[] args) {
        int[] arr = {5,4,1,2,3,0,-1,6,-8};
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int j = i;
            while(j>0){
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
                j--;
                printarr(arr);

            }
        }
        printarr(arr);
    }
    private static int step = 0;
    public static void printarr(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+",");

        }
        System.out.println();

    }
}
