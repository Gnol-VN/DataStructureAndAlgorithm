package crackingCodingInterview.Greedy;

import java.util.Arrays;
import java.util.Comparator;

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
        Arrays.sort(itemList, (o1, o2) -> {
            if(o1.ratio > o2.ratio) return 1;
            else return -1;
        });
        //take from smallest ratio to highest, until cannot take more, then break it
        for (int i = 0; i < n; i++) {
            if(capacity - itemList[i].weight >0 ){
                //take
                capacity = capacity - itemList[i].weight;
                knapSackValue = knapSackValue + itemList[i].value;
            }else {
                //Break the product's weight to fit the remainder of the knapsack
                //After breaking, add the corresponding value
                double brokenValue = (Double.valueOf(capacity) / Double.valueOf(itemList[i].weight)) * itemList[i].value;
                knapSackValue +=  brokenValue;
                capacity = 0;

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
