package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Scanner;

public class CompactDisc extends Disc implements Playable{
    private String artist;

    private ArrayList<TrackList> trackList = new ArrayList<TrackList>();


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


    public float getLength(){
        float length = 0.0f;
        for (int i = 0; i < trackList.size(); i++){
            length += trackList.get(i).getTrackLength();
        }
        return length;
    }

    public void addTrack(String title, float length){
        boolean check = true;
        for (int i = 0; i < trackList.size(); i++){
            if (this.trackList.get(i).getTrackTittle().equals(title)){
                check = false;
                break;
            }
        }
        if (check){
            trackList.add(new TrackList(title, length));
        }
    }


    public void removeTrack(String title){
        for (int i = 0; i < trackList.size(); i++){
            if (trackList.get(i).getTrackTittle().equals(title)){
                System.out.println("Removed " + trackList.get(i).getTrackTittle() + "\n");
                trackList.remove(i);
                break;
            }
        }
    }



    public CompactDisc(){
        super();
    }


    public CompactDisc(String title, String category, String director, String artist, float cost, float length,
            ArrayList<TrackList> trackLists,int media_type){
        super(title, category, cost, director, length, media_type);
        this.artist = artist;
        this.trackList.addAll(trackLists);
    }



    public Media inputInforCD(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Media title: ");
        String title = sc.nextLine();
        System.out.println("Media category: ");
        String category = sc.nextLine();
        System.out.println("Media price: ");
        float cost = Float.parseFloat(sc.nextLine());
        System.out.println("Director: ");
        String director = sc.nextLine();
        System.out.println("Artist: ");
        String artist = sc.nextLine();
        System.out.println("Add track to CD (y/n)");
        String option = sc.nextLine();
        ArrayList<TrackList> trackLists = new ArrayList<TrackList>();
        while (option.equals("y")){
            System.out.print("Track name: ");
            String trackName = sc.nextLine();
            System.out.print("Track length: ");
            float trackLength = Float.parseFloat(sc.nextLine());
            trackLists.add(new TrackList(trackName, trackLength));
            System.out.println("Add track to CD (y/n)");
            option = sc.nextLine();
        }
        float length = getLength();
        return new CompactDisc(title, category, director, artist, cost,length, trackLists,3);
    }

    @Override
    public void play() {
        for (int i = 0; i < trackList.size(); i++){
            trackList.get(i).play();
        }
    }

    public String toString(){
        return "CD" + "\n" + super.toString() + "\n" + "director: " + this.getDirector() + "\n"
                + "artist: " + this.getArtist() + "\n"
                + "length: " + this.getLength() + "\n";
    }

    @Override
    public int compareTo(Object o) {
        if (this.trackList.size() > ((CompactDisc) o).trackList.size())
            return 1;
        if (this.trackList.size() < ((CompactDisc) o).trackList.size())
            return -1;

        if (this.length > ((CompactDisc) o).getLength())
            return 1;
        if (this.length < ((CompactDisc) o).getLength())
            return -1;

        return 0;
    }
}
