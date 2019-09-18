package recursion;

/**
 * Find the left bar which is greater than current bar and name it LEFT
 * Find the right bar which is greater than current bar and name it RIGHT
 * Area = current bar * (right - left) +1;
 */
public class LargestRectangleHistogram {
    public static void main(String[] args) {
        int[] hist = {6, 2, 5, 4, 5, 1, 6};
        int right = 0, left = 0;
        int maxArea = 0;
        for (int i = 0; i < hist.length; i++) {
            right = 0;
            left = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (hist[j] >= hist[i]) {
                    left = j;
                }
                else break;
            }
            for (int j = i + 1; j < hist.length; j++) {
                if (hist[j] >= hist[i]) {
                    right = j;
                }
                else break;
            }
            int area = hist[i] * (right - left + 1);
            if (area > maxArea) maxArea = area;

        }
        System.out.println(maxArea);
    }
}

