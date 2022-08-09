package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.media.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Order {
    public static final int MAX_NUMBER_ORDERED = 10;
    public static final int MAX_LIMITED_ORDERED = 5;

    public static int MEDIA_DVD = 1;
    public static int MEDIA_BOOK = 2;
    public static int MEDIA_CD = 3;

    public static int nbOrdered = 0;

    private float sum = 0;
    private int ID = 0;

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();



    public static Order createOrder() {
        if (nbOrdered >= MAX_LIMITED_ORDERED)
        {
            System.out.println("You have reached maximum orders");
            return null;
        }
        else {
            nbOrdered ++;
            return new Order();
        }
    }


    public Media createMedia(int media_type){
        Media item;
        Scanner sc = new Scanner(System.in);
        if (media_type == MEDIA_DVD) {
            System.out.println("Add DVD");
            item = new DigitalVideoDisc().inputInforDVD();
            System.out.println("Do you want to play this DVD: (y/n)");
            String ans = sc.nextLine();
            if (ans.equals("y"))
                ((DigitalVideoDisc) item).play();
            return item;
        }
        else if (media_type == MEDIA_BOOK){
            System.out.println("Add book");
            item = new Book().inputInforB();
            return item;
        }
        else if (media_type == MEDIA_CD){
            System.out.println("Add CD");
            item = new CompactDisc().inputInforCD();
            System.out.println("Do you want to play this CD: (y/n)");
            String ans = sc.nextLine();
            if (ans.equals("y"))
                ((CompactDisc) item).play();
            return item;
        }
        return null;
    }

    public void addMedia(int media_type){
        if (nbOrdered < MAX_NUMBER_ORDERED) {
            Media item = createMedia(media_type);
            item.setID(ID++);
            this.itemsOrdered.add(item);
        }
    }

    public void addItem(Media item){
        this.itemsOrdered.add(item);
    }

    public ArrayList<Media> listOfItemInOrder(){
        return this.itemsOrdered;
    }

    public void removeMediaItemByTitle(String title){
        String[] s1 = title.split("\\s+");
        String[] s2;
        Media tmp;
        boolean check = true;
        for (int i = 0; i < itemsOrdered.size(); i++){
            tmp = itemsOrdered.get(i);
            s2 = tmp.getTitle().split("\\s+");
            for (String word : s1){
                check = Arrays.asList(s2).contains(word);
                if (check == false) break;
            }
            if (check) {
                itemsOrdered.remove(i);
                break;
            }
        }
    }

    public void removeMediaItemByID(int ID){
        for (int i = 0; i < itemsOrdered.size(); i++){
            if (itemsOrdered.get(i).getID() == ID){
                itemsOrdered.remove(i);
                break;
            }
        }
    }

    public float totalCost(){
        sum = 0.0f;
        for (int i = 0; i < itemsOrdered.size(); i++)
            sum += itemsOrdered.get(i).getCost();
        return sum - getLuckyItem();
    }

    public void showOrderInformation(){
        Media item;
        for (int i = 0; i < itemsOrdered.size(); i++){
            item = itemsOrdered.get(i);
            System.out.println(item);
        }
        System.out.println("total cost: " + totalCost());
    }


    public float getLuckyItem(){
        if (itemsOrdered.size() > 1) {
            int random = (int) Math.floor(Math.random() * (itemsOrdered.size() - 1));
            System.out.println("Ban duoc free: " + itemsOrdered.get(random).getTitle());
            return itemsOrdered.get(random).getCost();
        }
        return 0.0f;
    }
}
