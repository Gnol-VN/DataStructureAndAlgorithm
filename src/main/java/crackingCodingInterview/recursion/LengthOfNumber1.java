package crackingCodingInterview.recursion;

public class LengthOfNumber1 {
    public static void main(String[] args) {
        int[] arr = {0,1,1,1,1,1,1,0,0};
        int length = getLength(arr,1,0);
        System.out.println(length);

    }
    static int getLength(int[] arr, int currentIndex, int currentLength){
        if(arr[currentIndex] ==1){
            currentLength++;
            return getLength(arr, currentIndex + 1, currentLength);
        }
        return currentLength;
    }
}
