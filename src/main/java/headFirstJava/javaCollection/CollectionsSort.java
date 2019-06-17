package headFirstJava.javaCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsSort {
    public static void main(String[] args) {
        List<Song> songList = new ArrayList<>();
        songList.add(new Song("City of Star", "Emma"));
        songList.add(new Song("My Love", "Westlife"));
        songList.add(new Song("Em cua ngay hom qua", "Son Tung MTP"));
        System.out.println("Before title sorting:" + songList);

        Collections.sort(songList);
        System.out.println("After title sorting: " + songList);

        System.out.println("After singer sorting by Comparator");
        SingerComparator singerComparator = new SingerComparator();

        Collections.sort(songList, singerComparator);
        System.out.println(songList);


    }
}

class Song implements Comparable<Song> {
    private String title;
    private String singer;

    public Song(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    public String toString() {
        return title+ ": "+ singer;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    @Override
    public int compareTo( Song o) {
        if (this.title.charAt(0) > o.title.charAt(0)) return 1;
        else if (this.title.charAt(0) < o.title.charAt(0)) return -1;
        else return 0;

        //or
//        return this.title.compareTo(o.title);
    }

    public boolean equals(Object obj) {
        Song compareSong = (Song) obj;
        return (this.title.equals(compareSong.title));
    }

    public int hashCode(){
        return title.hashCode();
    }

}

class SingerComparator implements Comparator<Song>{

    @Override
    public int compare(Song o1, Song o2) {
        return o1.getSinger().compareTo(o2.getSinger());
    }
}