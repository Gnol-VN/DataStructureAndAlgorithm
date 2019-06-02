
import java.util.ArrayList;
import java.util.Collections;


public class MatrixTraversal {


    static ArrayList<PossiblePath> list = new ArrayList<>();
    static ArrayList<Integer> altitude = new ArrayList<>();

    private static void printMatrix(int mat[][], int columnCount, int rowCount,
                                    int i, int j, int path[], int idx) {
        path[idx] = mat[i][j];

        if (i == columnCount - 1) {
            PossiblePath possiblePath = new PossiblePath();
            for (int k = j + 1; k < rowCount; k++) {
                path[idx + k - j] = mat[i][k];
            }
            for (int l = 0; l < idx + rowCount - j; l++) {
                possiblePath.path.add(path[l]);

            }
            list.add(possiblePath);
            System.out.println();
            return;
        }

        if (j == rowCount - 1) {
            PossiblePath possiblePath = new PossiblePath();

            for (int k = i + 1; k < columnCount; k++) {
                path[idx + k - i] = mat[k][j];
            }
            for (int l = 0; l < idx + columnCount - i; l++) {
                possiblePath.path.add(path[l]);
            }
            list.add(possiblePath);

            System.out.println();
            return;
        }
        printMatrix(mat, columnCount, rowCount, i + 1, j, path, idx + 1);

        printMatrix(mat, columnCount, rowCount, i, j + 1, path, idx + 1);
    }

    // Driver code
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int mat[][] = {{6, 1, 6},
                {4, 5, 7}, {2, 3, 8}};
        int maxLengthOfPath = m + n - 1;

        printMatrix(mat, m, n, 0, 0, new int[maxLengthOfPath], 0);
        for (PossiblePath path : list) {
            int minIndex = Collections.min(path.path);
            altitude.add(minIndex);
        }
        System.out.println(Collections.max(altitude));
//        System.out.println(list);
    }

}

class PossiblePath {
    public ArrayList<Integer> path = new ArrayList<>();


}