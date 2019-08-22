package crackingCodingInterview.recursion;

public class Largest1s {
    static int area;
    static int maxArea;
    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0, 1, 1},
                {0, 1, 1, 1, 0, 0, 0}};

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[1].length; j++) {
                area = 0;
                spread(mat, i, j);
                if (area > maxArea) maxArea = area;
            }
        }
        System.out.println(maxArea);
    }

    static void spread(int[][] mat, int x, int y) {
        if (mat[x][y] == 1) {
            mat[x][y] = 2;
            area++;
        }
        System.out.println("------------");
        int row = mat.length;
        int col = mat[1].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        if (x + 1 < mat.length && mat[x + 1][y] == 1)  spread(mat, x + 1, y);
        if (x - 1 >= 0 && mat[x - 1][y] == 1)  spread(mat, x - 1, y);
        if (y + 1 < mat[0].length && mat[x][y + 1] == 1)  spread(mat, x, y + 1);
        if (y - 1 >= 0 && mat[x][y - 1] == 1)  spread(mat, x, y - 1);
    }
}
