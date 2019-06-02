// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
package jsoup;
import java.util.ArrayList;
import java.util.Collections;
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    ArrayList<PossiblePath> list = new ArrayList<>();
    ArrayList<Integer> altitude = new ArrayList<>();
    public int maxOfMinAltitudes(int columnCount, int rowCount,
                                 int[][] mat)
    {
        int maxLengthOfPath = columnCount + rowCount - 1;

        printMatrix(mat, columnCount, rowCount, 0, 0, new int[maxLengthOfPath], 0);
        for (PossiblePath path:list) {
            int minIndex = Collections.min(path.path);
            altitude.add(minIndex);
        }
        return Collections.max(altitude);

    }
    // METHOD SIGNATURE ENDS
    void printMatrix(int mat[][], int columnCount, int rowCount,
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
}
class PossiblePath   {
    public ArrayList<Integer> path = new ArrayList<>();

}