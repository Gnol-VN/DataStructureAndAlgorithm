package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {
    public static void main(String[] args) {
//        int[] start =  {1,3,0,5,8,5};
//        int[] finish = {2,4,6,7,9,9};
//        int n = start.length;
//        int i = 0;
//        System.out.println(i);
//        for (int j = 1; j < n; j++) {
//            if(start[j] >= finish[i]){
//                System.out.println(j);
//                i = j;
//            }
//        }
        List<Activity> list = new ArrayList<>();
        list.add(new Activity(0,6));
        list.add(new Activity(3,4));
        list.add(new Activity(5,9));
        list.add(new Activity(8,9));
        list.add(new Activity(1,2));
        list.add(new Activity(5,7));

        getJob(list);


    }
    static void getJob(List<Activity> list){
        Collections.sort(list, new Comparator<Activity>(){
            public int compare(Activity a1, Activity a2){
                if(a1.end > a2.end) return 1;
                else return -1;
            }
        });
        int cursor =0;
        System.out.println();
        for (int i = 1; i < list.size()-1; i++) {
            if(list.get(cursor).end <= list.get(i).start){
                System.out.println(i);
                cursor = i;
            }
        }
    }
    static class Activity{
        int start;
        int end;
        public Activity(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

}
