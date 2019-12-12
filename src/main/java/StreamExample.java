import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream is an API for processing Collection and its elements
 *
 */
public class StreamExample {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(2,3,4,5);
        List<Integer> squareNum = number.stream().map(o -> {
            return o*o;
        }).collect(Collectors.toList());

        List<String> names = Arrays.asList("Vietnam", "Ireland", "United States", "Singapore");
        List<String> namesWith7Characters = names.stream().filter(o->{
            if(o.length() == 7) return true;
            else return false;
        }).collect(Collectors.toList());

        List<String> sortedNames = names.stream().sorted((o1,o2)->{
            if (o1.charAt(0) > o2.charAt(0)) return 1;
            else return -1;
        }).collect(Collectors.toList());


        List<Integer> duplicateNumber = Arrays.asList(2,4);
        duplicateNumber.forEach(o->{
            o = o*o; //Square
        });
        System.out.println("Long");

    }


}
