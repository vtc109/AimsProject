package hust.soict.hedspi.aims.media.factory;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.Scanner;

public class BookCreation implements MediaCreation{
    @Override
    public Media createMediaFromConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Media title: ");
        String title = sc.nextLine();
        System.out.println("Media category: ");
        String category = sc.nextLine();
        System.out.println("Media price: ");
        float cost = Float.parseFloat(sc.nextLine());
        System.out.println("Book author: ");

        String check;
        String author;
        ArrayList<String> authors = new ArrayList<String>();
        do {
            author = sc.nextLine();
            authors.add(author);
            System.out.println("More authors? (y/n)");
            check = sc.nextLine();
        }while (check.equals("y"));
        return new Book(title, category, cost, authors,2);
    }
}
