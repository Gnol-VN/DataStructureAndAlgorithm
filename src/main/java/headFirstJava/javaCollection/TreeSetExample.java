package headFirstJava.javaCollection;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        Book b1 = new Book("Head first Java");
        Book b2 = new Book("Clean Code");
        Book b3 = new Book("UML introduction");
        TreeSet<Book> treeSet = new TreeSet<Book>();
        TreeSet<Book> t1reeSet = new TreeSet<Book>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return 0;
            }
        });
//        TreeSet<Book> treeSet = new TreeSet<Book>(new BookComparator());
        treeSet.add(b1);
        treeSet.add(b2);
        treeSet.add(b3);
        System.out.println(treeSet);

    }
}

class Book implements Comparable<Book>{
    String title;

    public Book(String title) {
        this.title = title;
    }
    public String toString(){
        return title;
    }

    @Override
    public int compareTo( Book o) {
        return this.title.compareTo(o.title);
    }
}

class BookComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        return o1.title.compareTo(o2.title);
    }
}