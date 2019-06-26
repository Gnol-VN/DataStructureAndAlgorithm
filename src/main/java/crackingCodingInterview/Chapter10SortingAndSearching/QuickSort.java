package crackingCodingInterview.Chapter10SortingAndSearching;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {8,3,6,5,7};

        System.out.println("Given Array");
        printArray(arr);

        QuickSort.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; //index của phần tử bé hơn pivot

        //
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; //cuối cùng arr[i+1] là phần tử bé mà GẦN pivot NHẤT
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) { //Điều kiện dừng
            int pi = partition(arr, low, high); // Vị trí pivot sau mỗi lần sort
            sort(arr, low, pi - 1); //sort bên phải pivot. -1 vì không chạm vào pivot nữa
            sort(arr, pi + 1, high); //sort bên trái pivot. +1 vì không chạm vào pivot

        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
