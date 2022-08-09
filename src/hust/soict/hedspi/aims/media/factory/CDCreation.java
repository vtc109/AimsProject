package hust.soict.hedspi.aims.media.factory;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.TrackList;

import java.util.ArrayList;
import java.util.Scanner;

public class CDCreation implements MediaCreation{

    public float getLength(ArrayList<TrackList> trackLists){
        float length = 0.0f;
        for (int i = 0; i < trackLists.size(); i++){
            length += trackLists.get(i).getTrackLength();
        }
        return length;
    }
    @Override
    public Media createMediaFromConsole() {
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
        float length = getLength(trackLists);
        return new CompactDisc(title, category, director, artist, cost, length, trackLists,3);

    }
}
