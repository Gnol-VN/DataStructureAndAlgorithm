package crackingCodingInterview.recursion;

public class FloodColor {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0}
        };

        color(matrix,1,2,2,2);


    }
    static void color(int[][] matrix, int srcColor, int desColor, int x, int y){
        matrix[x][y] = desColor;
        System.out.println("------------");
        int row = matrix.length;
        int col = matrix[1].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        if(y+1 < matrix[1].length && matrix[x][y+1] == srcColor){
            color(matrix,srcColor,desColor,x,y+1);
        }
        if(y-1 > 0 && matrix[x][y-1] == srcColor){
            color(matrix,srcColor,desColor,x,y-1);
        }
        if(x + 1 < matrix.length && matrix[x+1][y] == srcColor){
            color(matrix,srcColor,desColor,x+1,y);
        }
        if(x-1 >0 && matrix[x-1][y] == srcColor){
            color(matrix,srcColor,desColor,x-1,y);
        }

    }
}
