package hust.soict.hedspi.aims.media;

public class TrackList extends Media implements Playable{
    private String trackTittle;
    private float trackLength;

//    public String toString(){
//        return "Track: " + this.trackTittle + " - Length: " + this.trackLength;
//    }

    public void setTrackTittle(String trackTittle) {
        this.trackTittle = trackTittle;
    }

    public void setTrackLength(float trackLength) {
        this.trackLength = trackLength;
    }

    public String getTrackTittle() {
        return trackTittle;
    }

    public float getTrackLength() {
        return trackLength;
    }

    public TrackList(String trackTittle, float trackLength) {
        this.trackTittle = trackTittle;
        this.trackLength = trackLength;
    }

    @Override
    public void play() {
        System.out.println("Track title: " + this.getTrackTittle());
        System.out.println("Track length: " + this.getTrackLength());
    }

    public boolean equals(Object o){
        boolean check = false;
        if (this.trackTittle == ((TrackList) o).getTrackTittle() && this.trackLength == ((TrackList) o).getTrackLength())
            check = true;
        return check;
    }


}
