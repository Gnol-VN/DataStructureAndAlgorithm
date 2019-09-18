package Chapter10SortingAndSearching;

/**
 * if (r > l)
 * 1. Find the middle point
 * 2. Sort left array
 * 3. Sort right array
 * 4. Merge two halves
 */
class MergeSort {
    void sort(int arr[], int left, int right)
    {
        if (left < right)
        {
            // Find the middle point
            int mid = (left+right)/2;

            // Sort first and second halves
            sort(arr, left, mid);
            sort(arr , mid+1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    void merge(int arr[], int left, int mid, int right) {
        //Find sizes of two sub arrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        //Create temp arrays
        int[] leftTemp = new int[n1];
        int[] rightTemp = new int[n2];

        //Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftTemp[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightTemp[j] = arr[mid + 1 + j];
        }

        //Merge the temp arrays

        //Init indexs of 1st and 2st sub arrays
        int i = 0, j =0;
        //Init index of merged sub array
        int k = left;
        while(i<n1 && j<n2){
            if(leftTemp[i] <= rightTemp[j]){
                arr[k] = leftTemp[i];
                i++;
            }
            else{
                arr[k] = rightTemp[j];
                j++;
            }
            k++;
        }
        //Copy remaining elemetns of temp1 if any
        while(i<n1){
            arr[k] = leftTemp[i];
            i++;
            k++;
        }
        //Copy remaining elemetns of temp2 if any
        while(j<n2){
            arr[k] = rightTemp[j];
            j++;
            k++;
        }

    }
}

public class mergeSortExample {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
