package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class TestMediaCompareTo {
    public static void main(String[] args){
        ArrayList<Media> itemList = new ArrayList<Media>();
        Media item1 = new DigitalVideoDisc();
        Media item2 = new CompactDisc();
        Media item3 = new Book();

        item1.setTitle("dvd1");
        item2.setTitle("cd1");
        item3.setTitle("book1");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);

        java.util.Collections.sort((java.util.List) itemList);

        for (int i = 0; i < itemList.size(); i++){
            System.out.println(itemList.get(i).getTitle());
        }
    }
}
