package crackingCodingInterview.Chapter10SortingAndSearching;

/**
 * if (r > l)
 * 1. Find the middle point
 * 2. Sort left array
 * 3. Sort right array
 * 4. Merge two halves
 */
class MergeSort {
    void sort(int arr[], int l, int r) {
        if (r > l) {
            int m = (r + l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    void merge(int arr[], int l, int m, int r) {
        //Find sizes of two sub arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        //Create temp arrays
        int[] tempArr1 = new int[n1];
        int[] tempArr2 = new int[n2];

        //Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            tempArr1[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            tempArr2[i] = arr[m + 1 + i];
        }

        //Merge the temp arrays

        //Init indexs of 1st and 2st sub arrays
        int i = 0, j =0;
        //Init index of merged sub array
        int k = 1;
        while(i<n1 && j<n2){
            if(tempArr1[i] <= tempArr2[j]){
                arr[k] = tempArr1[i];
                i++;
            }
            else{
                arr[k] = tempArr2[j];
                j++;
            }
            k++;
        }
        //Copy remaining elemetns of temp1 if any
        while(i<n1){
            arr[k] = tempArr1[i];
            i++;
            k++;
        }
        //Copy remaining elemetns of temp2 if any
        while(j<n2){
            arr[k] = tempArr2[j];
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
