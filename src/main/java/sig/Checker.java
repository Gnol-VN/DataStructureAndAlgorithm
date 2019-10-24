package sig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Checker {
    public static void main(String[] args) {
        String[] B = new String[]{
//                ".....",
//                "...X.",
//                ".....",
//                ".X.X.",
//                "..O.."
                "O"
        };
        char[][] arr =new char[B.length][B.length];
        for (int i = 0; i < B.length; i++) {
            arr[i] = B[i].toCharArray();
        }
        int pts = 0;
        int curX = 0, curY = 0;
        List<Integer>  ptsList = new ArrayList<>();


//        char[][] arr = new char[][]{
//                {'.','.','.','.','.'},
//                {'.','.','.','X','.'},
//                {'.','.','.','.','.'},
//                {'.','X','.','X','.'},
//                {'.','.','O','.','.'}
//        };
//        char[][] arr = new char[][]{
//                {'.','.','X','.','.','.'},
//                {'.','.','.','.','.','.'},
//                {'.','.','.','.','X','.'},
//                {'.','X','.','.','.','.'},
//                {'.','.','X','.','X','.'},
//                {'.','.','.','O','.','.'}
//        };
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j] == 'O'){
                    curX = j;
                    curY = i;
                    break;
                }
            }
        }
        move(pts, curX, curY,arr, ptsList);
        if(ptsList.size() ==0) System.out.println(0);
        else System.out.println(Collections.max(ptsList));
    }

    static void move(int pts, int curX, int curY, char[][] arr, List<Integer> ptsList){
        if (curX - 2 >= 0 && curY - 2 >= 0) {
            if(arr[curY-1][curX-1]=='X' && arr[curY-2][curX-2] == '.'){
                ptsList.add(pts+1);
                move(pts+1, curX-2, curY-2, arr, ptsList);
            }
        }
        if(curX+2 < arr.length && curY-2 >=0){
            if(arr[curY-1][curX+1] =='X' && arr[curY-2][curX+2] =='.'){
                ptsList.add(pts+1);
                move(pts+1, curX+2, curY-2,arr, ptsList);
            }
        }
    }
}
