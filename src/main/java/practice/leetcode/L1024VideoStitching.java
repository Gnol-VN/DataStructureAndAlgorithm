package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1024VideoStitching {
    public static void main(String[] args) {
        L1024VideoStitching l1024VideoStitching = new L1024VideoStitching();
//        int[][] a = new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
//        int[][] a = new int[][]{{0, 4}, {2, 8}};
//        int[][] a = new int[][]{{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};
        int[][] a = new int[][]{{16,18},{16,20},{3,13},{1,18},{0,8},{5,6},{13,17},{3,17},{5,6}};
        System.out.println(l1024VideoStitching.videoStitching(a, 5));
    }

    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (o1, o2) -> {
            if (o1[0] > o2[0]) return 1;
            if (o1[0] == o2[0]) {
                if (o1[1] > o2[1]) return 1;
                else return -1;
            } else return -1;

        });
        if (clips[clips.length - 1][1] < T) return -1;
        if(clips[0][0] != 0) return -1;

        List<Integer> mark = new ArrayList<>();
        for (int i = 0; i < clips.length - 1; i++) {
            if (clips[i][0] != clips[i + 1][0]) mark.add(i);
        }
        mark.add(clips.length - 1);
        List<List<Integer>> filter1 = new ArrayList<>();
        for (int i : mark) {
            List<Integer> l1 = new ArrayList<>();
            l1.add(clips[i][0]);
            l1.add(clips[i][1]);
            filter1.add(l1);
        }
        mark.clear();

        mark.add(0);
        for (int i = 0; i < filter1.size()-1; i++) {
            int max = filter1.get(i).get(1);
            if(max > T) return mark.size();
            for (int j = filter1.size() - 1; j > i; j--) {
                if (filter1.get(j).get(0) <= max) {
                    mark.add(j);
                    i = j-1;
                    break;
                }
                if(j-i == 1) return -1;

            }

        }
        return mark.size();
    }
}
