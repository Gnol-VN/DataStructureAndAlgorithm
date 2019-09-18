package Chapter10SortingAndSearching;

public class selectionsort {
    public static void main(String[] args) {
        int[] arr = {5,4,1,2,3,0,-1,6,-8};
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            printarr(arr);
        }

    }
    private static int step = 0;
    public static void printarr(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);

        }
        System.out.println();

    }
}
