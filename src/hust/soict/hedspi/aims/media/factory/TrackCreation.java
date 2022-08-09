package hust.soict.hedspi.aims.media.factory;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.TrackList;

import java.util.Scanner;

public class TrackCreation implements MediaCreation{
    @Override
    public Media createMediaFromConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Track title: ");
        String title = sc.nextLine();
        System.out.println("Track length: ");
        float length = Float.parseFloat(sc.nextLine());
        return new TrackList(title, length);
    }
}
