package recursion;

public class GardenOfCarrot {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0, 1, 1},
                {0, 1, 1, 1, 0, 0, 0}
        };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[1].length; j++) {
                if(matrix[i][j] == 1){
                    for (int k = i ; k < matrix.length; k++) {
                        for (int l = j; l < matrix[1].length; l++) {
                            int x1 = i;
                            int y1 = j;
                            int x2 = k;
                            int y2 = l;
                            checkRectangle(matrix,x1,y1,x2,y2);
                        }
                    }
                }
            }
        }
        
    }

    static void checkRectangle(int[][] mat, int x1, int y1, int x2, int y2){
        int area = 0;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <=  y2; j++) {
                if(mat[i][j] == 1) area ++;
                else area =0;
            }
        }
        if(area>3)
        System.out.println(area);
    }
}
