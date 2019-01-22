package headFirstJava.javaCollection;

public class ReferenceAndObjectEquality {
    public static void main(String[] args) {

        //Reference equality (by == operand)
        Song1 song_1 = new Song1("Em cua ngay hom qua", "Son Tung");
        Song1 song_2 = song_1;
        System.out.println(song_1 == song_2);

        
    }

}

class Song1{
    private String title;
    private String singer;

    public Song1(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }
}