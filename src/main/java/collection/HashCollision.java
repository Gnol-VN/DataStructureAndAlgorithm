package collection;

import java.util.ArrayList;
import java.util.List;

public class HashCollision{
    public static void main(String[] args){
        Hash hashMap = new Hash();
        hashMap.put(100, "Long");
        hashMap.put(10, "Tam");
        System.out.println(hashMap.get(100));
        System.out.println(hashMap.get(10));
    }
}

class Hash{
    List<Bucket> buckets;
    int numberOfBuckets;
    public Hash(){
        buckets = new ArrayList<Bucket>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new Bucket());
        }
        numberOfBuckets = 10;
    }
    void put(int key, String value){
        int bucketToSelect = key % numberOfBuckets;
        buckets.get(bucketToSelect).elementList.add(new Element(key,value));
    }

    String get(int key){
        int bucketToSelect = key % numberOfBuckets;
        Bucket bucket = buckets.get(bucketToSelect);
        for(Element e: bucket.elementList){
            if(e.key == key){
                return e.content;
            }
        }
        return null;
    }
}

class Bucket{
    List<Element> elementList;
    public Bucket(){
        elementList = new ArrayList<>();
    }
}

class Element{
    int key;
    String content;
    public Element(int key, String content){
        this.key = key;
        this.content = content;
    }
}
