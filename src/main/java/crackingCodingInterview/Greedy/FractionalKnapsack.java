package crackingCodingInterview.Greedy;

import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int weight[] = {10, 40, 20, 30};
        int value[] = {60, 40, 100, 120};
        int capacity = 50;
        double knapSackValue= 0;
        int n = weight.length;
        Item[] itemList = new Item[n];
        for (int i = 0; i < n; i++) {
            Item item = new Item(weight[i], value[i]);
            itemList[i] = item;
        }
        //sort
//        Arrays.sort(itemList, (o1, o2) -> {
//            if(o1.ratio > o2.ratio) return 1;
//            else return -1;
//        });
//        //take from smallest ratio to highest, until cannot take more, then break it
//        for (int i = 0; i < n; i++) {
//            if(capacity - itemList[i].weight >0 ){
//                //take
//                capacity = capacity - itemList[i].weight;
//                knapSackValue = knapSackValue + itemList[i].value;
//            }else {
//                //Break the product's weight to fit the remainder of the knapsack
//                //After breaking, add the corresponding value
//                double brokenValue = (Double.valueOf(capacity) / Double.valueOf(itemList[i].weight)) * itemList[i].value;
//                knapSackValue +=  brokenValue;
//                capacity = 0;
//
//            }
//        }
        List<Item> itemList1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            itemList1.add(itemList[i]);
        }
        while(capacity > 0){
            Item item = Collections.max(itemList1, new Comparator<Item>(){
                public int compare(Item i1, Item i2){
                    if(i1.ratio > i2.ratio) return -1;
                    else return 1;
                }
            });
            if(capacity - item.weight >0){
                knapSackValue += item.value;
                capacity -= item.weight;
                itemList1.remove(item);
            }
            else{
                knapSackValue += item.value * capacity / item.weight;
                capacity = 0;
                itemList1.remove(item);
            }
        }
        System.out.println("Knapsack value: "+ knapSackValue);
    }
    static class Item{
        int weight;
        int value;
        double ratio;
        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = Double.valueOf(weight)/ Double.valueOf(value);
        }
    }
}
