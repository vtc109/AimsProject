package hust.soict.hedspi.aims.media.factory;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.Scanner;

public class DVDCreation implements MediaCreation{
    @Override
    public Media createMediaFromConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Media title: ");
        String title = sc.nextLine();
        System.out.println("Media category: ");
        String category = sc.nextLine();
        System.out.println("Media price: ");
        float cost = Float.parseFloat(sc.nextLine());
        System.out.println("Media director: ");
        String director = sc.nextLine();
        System.out.println("Media length: ");
        float length = Float.parseFloat(sc.nextLine());
        return new DigitalVideoDisc(title, category, director, length, cost, 1);
    }
}
