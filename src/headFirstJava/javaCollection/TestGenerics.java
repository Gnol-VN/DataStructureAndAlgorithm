package headFirstJava.javaCollection;

import crackingCodingInterview.Chapter1ArrayAndString.CompressString;
import crackingCodingInterview.Chapter1ArrayAndString.UniqueCharacter;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics<E> {
    void takeSomething(E ttt){

    }

    <M> List<Object> take3(M m){
        return new ArrayList<>();
    }
    TestGenerics<CompressString> compressStringTestGenerics = new TestGenerics<>();


    public static void main(String[] args) {
        TestGenerics<Object> testGenerics = new TestGenerics<>();
        testGenerics.takeSomething(new UniqueCharacter());
    }

}
