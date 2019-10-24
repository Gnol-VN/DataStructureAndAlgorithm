package guidewire;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Guidewire {
    public static void main(String[] args) {
       String S = "my.song.mp3 100001b\n" +
               "greatSong.flac 1000b\n" +
               "not3.txt 5b\n" +
               "video.mp4 200b\n" +
               "game.exe 100b\n" +
               "mov!e.mkv 10000b";
       int musicSize=0, imageSize=0, movieSize=0, otherSize=0;
        Set<String> musicExt = new HashSet<>();
        musicExt.add("mp3");
        musicExt.add("aac");
        musicExt.add("flac");
        Set<String> imageExt = new HashSet<>();
        imageExt.add("jpg");
        imageExt.add("bmp");
        imageExt.add("gif");
        Set<String> movieExt = new HashSet<>();
        movieExt.add("mp4");
        movieExt.add("avi");
        movieExt.add("mkv");

        String[] lines = S.split("\n");
        for (String line: lines) {
            String fileName = line.split(" ")[0];
            String size = line.split(" ")[1];
            size = size.substring(0,size.length()-1);
            String[] processedFilename = fileName.split("\\.");
            String extension = processedFilename[processedFilename.length-1];

            if(musicExt.contains(extension)) {
                musicSize += Integer.valueOf(size);
            }
            else if(imageExt.contains(extension)) {
                imageSize += Integer.valueOf(size);
            }
            else if(movieExt.contains(extension)) {
                movieSize += Integer.valueOf(size);
            }
            else{
                otherSize += Integer.valueOf(size);
            }
        }
        System.out.println("music "+musicSize+"b" +
                "\nimages "+ imageSize+"b" +
                "\nmovies "+ movieSize+"b" +
                "\nother " + otherSize+"b");
    }
}
