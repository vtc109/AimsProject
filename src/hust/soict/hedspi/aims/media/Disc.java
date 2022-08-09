package hust.soict.hedspi.aims.media;

public class Disc extends Media{
    public float length;
    public String director;

    public float getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public Disc(){
        super();
    }

    public Disc (String title, String category, float cost, String director, float length, int media_type){
        super(title, category, cost, media_type);
        this.director = director;
        this.length = length;
    }
}
