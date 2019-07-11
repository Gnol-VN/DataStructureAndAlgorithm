package crackingCodingInterview.Chapter1ArrayAndString;

import java.util.*;

public class TreeParentAndChildren {
    public static void main(String[] args) {
        int[][] tree = {
                {5,3},
                {5,7},
                {3,2},
                {3,4},
                {7,6},
                {7,8}
        };
        System.out.println(findRoot(tree));
    }
    static int findRoot(int[][] tree){
        if(tree.length == 0) return -1;
        if(tree[0].length != 2) return -1;

        int n = tree.length;
        int m = tree[0].length;

        Set<Integer> pSet = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n ; i++){
            pSet.add(tree[i][0]);
        }

        for(int i = 0 ; i < m ; i++){
            map.put(tree[i][1], 0);
        }

        for(Integer parent:pSet){
            if(!map.containsKey(parent))
                return parent;
        }
        return -1;
    }
}
