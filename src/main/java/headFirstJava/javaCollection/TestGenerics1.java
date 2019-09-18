package headFirstJava.javaCollection;

import String.CompressString;
import String.UniqueCharacter;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics1<E> {
    void takeSomething(E ttt){

    }

    <M> List<Object> take3(M m){
        return new ArrayList<>();
    }
    TestGenerics1<CompressString> compressStringTestGenerics = new TestGenerics1<>();


    public static void main(String[] args) {
        TestGenerics1<Object> testGenerics = new TestGenerics1<>();
        testGenerics.takeSomething(new UniqueCharacter());
    }

}

