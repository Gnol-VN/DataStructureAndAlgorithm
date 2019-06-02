package headFirstJava.javaCollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class HashSetExample {
    public static void main(String[] args) {
        List<Song> songList = new ArrayList<>();
        songList.add(new Song("City of Star", "Emma"));
        songList.add(new Song("My Love", "Westlife"));
        songList.add(new Song("Em cua ngay hom qua", "Son Tung MTP"));
        songList.add(new Song("Em cua ngay hom qua", "Son Tung MTP"));
        songList.add(new Song("Em cua ngay hom qua", "Son Tung MTP"));

        Set<Song> songSet = new HashSet<>();
        songSet.addAll(songList);
        System.out.println("Song List");
        System.out.println(songList);
        System.out.println("Song Set");
        System.out.println(songSet);
        System.out.println(songList.get(2) == songList.get(3)); //False, because song(2) and song(3) stay at different memory.
        // == operand is compare memory



    }
}

