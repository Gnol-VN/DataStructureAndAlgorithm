package headFirstJava.javaCollection;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric2 {
    public static void main(String[] args) {
        List<Dog> dogArrayList = new ArrayList<>();
        //The line below will create bug, since a List<Animal> is NOT a List<Dog>
//        addMoreElement(dogArrayList);

    }
    static  void addMoreElement(List<Animal> dogList){
        dogList.add(new Cat());
    }
}

class Dog extends Animal{

}
class Cat extends Animal{

}
class Animal{

}
