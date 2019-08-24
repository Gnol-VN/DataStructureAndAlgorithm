package crackingCodingInterview.recursion;

public class GardenOfCarrot2 {
    public static void main(String[] args) {
        int maxArea = 0;
        int[][] mat = {
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0}
        };

        int[] height = new int[mat.length];
        height = mat[0];
        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == mat[i - 1][j] && mat[i][j] == 1) {
                    height[j]++;
                } else {
                    if (mat[i][j] == 1)
                        height[j] = 1;
                }
                if (mat[i][j] == 0) {
                    height[j] = 0;
                }

            }
            int area = 0;
            for (int j = 0; j < height.length; j++) {
                int leftIndex = j, rightIndex = j;
                while (leftIndex - 1 >= 0 && height[leftIndex - 1] >= height[j]) {
                    leftIndex = leftIndex - 1;
                }


                while (rightIndex + 1 < height.length && height[rightIndex + 1] >= height[j]) {
                    rightIndex = rightIndex + 1;
                }

                area = height[j] * (rightIndex - leftIndex + 1);
                if (area > maxArea) maxArea = area;
            }
        }

        System.out.println(maxArea);

    }
}
