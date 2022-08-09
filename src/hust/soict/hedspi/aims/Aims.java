package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.factory.BookCreation;
import hust.soict.hedspi.aims.media.factory.CDCreation;
import hust.soict.hedspi.aims.media.factory.DVDCreation;
import hust.soict.hedspi.aims.media.factory.MediaCreation;
import hust.soict.hedspi.aims.order.Order;

import java.util.ArrayList;
import java.util.Scanner;

public class Aims {
    Order order = null;
    ArrayList<Order> orders = new ArrayList<Order>();
    ArrayList<Media> listOfItems = new ArrayList<Media>();
    int cout = 0;
    int orderID;
    public void showMenu(){
        int menu = 1;
        int type;
        int ID;
        Scanner sc = new Scanner(System.in);
        while (menu != 0){
            System.out.println("Order Management Application: ");
            System.out.println("-------------------------------");
            System.out.println("1. Create new order");
            System.out.println("2. Add item to the order");
            System.out.println("3. Delete item by id");
            System.out.println("4. Display the items list of order");
            System.out.println("0. Exit");
            System.out.println("-------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            menu = Integer.parseInt(sc.nextLine());
            switch (menu){
                case 1:
                    order = Order.createOrder();
                    if (order != null) {
                        orders.add(order);
                        System.out.println("You have created order. ID: " + cout);
                        cout++;
                    }
                    break;
                case 2:
                    if (cout > 0){
                        System.out.println("Choose order you want to add item: ");
                        for (int i = 0; i < orders.size(); i++) System.out.println("Order " + i); //maybe need order name
                        orderID = Integer.parseInt(sc.nextLine());
                    }
                    else
                        orderID = 0;

                    if (orders.size() == 0) {
                        System.out.println("You have to create order first");
                        break;
                    } else if (orders.size() <= orderID){
                        System.out.println("Khong ton tai order nay");
                        break;
                    }

                    System.out.println("Choose type of media");
                    System.out.println("1. Add DVD");
                    System.out.println("2. Add Book");
                    System.out.println("3. Add CD");
                    type = Integer.parseInt(sc.nextLine());
                    if (type == 1 || type == 2 || type== 3) {
                        orders.get(orderID).addMedia(type);
                    }
                    else
                        System.out.println("Wrong type");
                    break;
                case 3:
                    if (cout > 0){
                        System.out.println("Choose order: ");
                        for (int i = 0; i < orders.size(); i++) System.out.println("Order " + i);
                        orderID = Integer.parseInt(sc.nextLine());
                    }
                    else
                        orderID = 0;
                    if (orders.size() == 0) {
                        System.out.println("You have to create order first");
                        break;
                    } else if (orders.size() <= orderID){
                        System.out.println("Khong ton tai order nay");
                        break;
                    }

                    System.out.println("Choose ID of the item: ");
                    ID = Integer.parseInt(sc.nextLine());
                    orders.get(orderID).removeMediaItemByID(ID);
                    break;
                case 4:
                    for (int i = 0; i < orders.size(); i++)
                        if (orders.get(i) != null) {
                            System.out.println("\nOrder " + i);
                            orders.get(i).showOrderInformation();
                        }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Only choose 0-1-2-3-4");
            }
        }
    }

    public void showAdminMenu(){
        int menu = 1;
        int type;
        int id;
        int ID = 0;
        Media item;
        Scanner sc = new Scanner(System.in);
        while (menu != 0){
            System.out.println("Order Management Application: ");
            System.out.println("-------------------------------");
            System.out.println("1. Create new item");
            System.out.println("2. Delete item by id");
            System.out.println("3. Display the items list");
            System.out.println("0. Exit");
            System.out.println("-------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");
            menu = Integer.parseInt(sc.nextLine());
            switch (menu){
                case 1:
                    System.out.println("Choose type of media");
                    System.out.println("1. DVD");
                    System.out.println("2. Book");
                    System.out.println("3. CD");
                    type = Integer.parseInt(sc.nextLine());
                    if (type == 1 ) {
                        //listOfItems.add(createMedia(new DVDCreation()));
                        item = createMedia(new DVDCreation());
                        item.setID(ID++);
                        listOfItems.add(item);
                    }
                    else if (type == 2) {
                        item = createMedia(new BookCreation());
                        item.setID(ID++);
                        listOfItems.add(item);
                        //listOfItems.add(createMedia(new BookCreation()));
                    }
                    else if (type == 3) {
                        item = createMedia(new CDCreation());
                        item.setID(ID++);
                        listOfItems.add(item);
                        //listOfItems.add(createMedia(new CDCreation()));
                    }
                    else
                        System.out.println("Wrong type");
                    break;
                case 2:
                    for (int i = 0; i < listOfItems.size(); i++){
                        System.out.println("ID: " + listOfItems.get(i).getID() + "\n" + "title: " + listOfItems.get(i).getTitle() + "\n");
                    }

                    System.out.print("Choose ID item to remove: ");
                    id = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < listOfItems.size(); i++){
                        if (id == listOfItems.get(i).getID()){
                            listOfItems.remove(i);
                            break;
                        }
                    }

                    break;
                case 3:
                    for (int i = 0; i < listOfItems.size(); i++){
                        item = listOfItems.get(i);
                        System.out.println("ID: " + item.getID());
                        System.out.println(item.toString());
                    }
                    break;
                default:
                    System.out.println("Only choose 0-1-2-3");
            }
        }
    }

    public void showUserMenu(){
        int ID;
        int menu = 1;
        Media item;
        Scanner sc = new Scanner(System.in);
        while (menu != 0) {
            System.out.println("Order Management Application: ");
            System.out.println("-------------------------------");
            System.out.println("1. Create new order");
            System.out.println("2. Search for an item from the list by title");
            System.out.println("3. Add item to order by id (id in the list of available item of the store)");
            System.out.println("4. Remove item from order by id (id in the order)");
            System.out.println("5. Display the order information");
            System.out.println("0. Exit");
            System.out.println("-------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");
            menu = Integer.parseInt(sc.nextLine());
            switch (menu){
                case 1:
                    order = Order.createOrder();
                    if (order != null) {
                        orders.add(order);
                        System.out.println("You have created order. ID: " + cout);
                        cout++;
                    }
                    break;
                case 2:
                    boolean inList = false;
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    for (int i = 0; i < listOfItems.size(); i++){
                        item = listOfItems.get(i);
                        if (item.search(title)){
                            inList = true;
                            System.out.println("ID: " + item.getID());
                            System.out.println(item);
                        }
                    }
                    if (!inList)
                        System.out.println("No item like that is in the list");
                    break;
                case 3:
                    if (cout > 0){
                        System.out.println("Choose order you want to add item: ");
                        for (int i = 0; i < orders.size(); i++) System.out.println("Order " + i);
                        orderID = Integer.parseInt(sc.nextLine());
                    }
                    else
                        orderID = 0;

                    if (orders.size() == 0) {
                        System.out.println("You have to create order first");
                        break;
                    } else if (orders.size() <= orderID){
                        System.out.println("Khong ton tai order nay");
                        break;
                    }

                    boolean add = false;
                    System.out.println("Choose ID of the item: ");
                    ID = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < listOfItems.size(); i++) {
                        if (listOfItems.get(i).getID() == ID){
                            orders.get(orderID).addItem(listOfItems.get(i));
                            add = true;
                            break;
                        }
                    }
                    if (add) System.out.println("add thanh cong");
                    else System.out.println("Chua add thanh cong (sai ID)");
                    break;
                case 4:
                    if (cout > 0){
                        System.out.println("Choose order: ");
                        for (int i = 0; i < orders.size(); i++) System.out.println("Order " + i);
                        orderID = Integer.parseInt(sc.nextLine());
                    }
                    else
                        orderID = 0;
                    if (orders.size() == 0) {
                        System.out.println("You have to create order first");
                        break;
                    } else if (orders.size() <= orderID){
                        System.out.println("Khong ton tai order nay");
                        break;
                    }

                    boolean rm = false;
                    ArrayList<Media> itemListInOrder = orders.get(orderID).listOfItemInOrder();

                    System.out.println("Choose ID of the item: ");
                    ID = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < itemListInOrder.size(); i++){
                        if (itemListInOrder.get(i).getID() == ID){
                            itemListInOrder.remove(i);
                            rm = true;
                            break;
                        }
                    }

                    if (rm) System.out.println("Remove success");
                    else
                        System.out.println("Remove fail");
                    break;
                case 5:
                    for (int i = 0; i < orders.size(); i++)
                        if (orders.get(i) != null) {
                            System.out.println("\nOrder " + i);
                            orders.get(i).showOrderInformation();
                        }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Only choose 0-1-2-3-4-5");
            }
        }
    }

    public static Media createMedia(MediaCreation mc){
        return mc.createMediaFromConsole();
    }
}
