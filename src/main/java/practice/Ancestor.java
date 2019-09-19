package practice;

import java.util.ArrayList;
import java.util.List;

public class Ancestor {
    static List<Person> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add(new Person("A"));
        list.add(new Person("B"));
        list.add(new Person("C,A,B"));
        list.add(new Person("D"));
        list.add(new Person("E,C,D"));
        list.add(new Person("I"));
        list.add(new Person("K"));
        list.add(new Person("F,I,K"));
        list.add(new Person("G,E,F"));
        System.out.println(isRelative("C", "G"));

    }

    static class Person {
        Person mom;
        Person dad;
        String name;

        Person(String info) {
            String[] split = info.split(",");
            name = split[0];
            if (split.length > 1) {
                for (Person p : list) {
                    if (p.name.equals(split[1])) {
                        this.dad = p;
                    } else if (p.name.equals(split[2])) {

                        this.mom = p;
                    }
                }
            }
        }
    }

    static boolean isRelative(String nameA, String nameB) {
        List<String> ancestor_A = new ArrayList<>();
        findAncestor(nameA, ancestor_A);
        List<String> ancestor_B = new ArrayList<>();
        findAncestor(nameB, ancestor_B);
        for(String s1: ancestor_A){
            for (String s2: ancestor_B){
                if(s1.equals(s2)) return true;
            }
        }
        return false;
    }

    static Person findByName(String name) {
        for (Person p : list) {
            if (p.name.equals(name)) return p;
        }
        return null;
    }

    static void findAncestor(String name, List<String> ancestor) {
        Person currentPerson = findByName(name);
        if (currentPerson.mom != null) {
            Person mom = currentPerson.mom;
            ancestor.add(mom.name);
            findAncestor(mom.name, ancestor);


        }
        if (currentPerson.dad != null) {
            Person dad = currentPerson.dad;
            ancestor.add(dad.name);
            findAncestor(dad.name, ancestor);
        }
        if(currentPerson.dad == null && currentPerson.mom == null)
            ancestor.add(currentPerson.name);
    }

}