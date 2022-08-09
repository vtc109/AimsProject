package hust.soict.hedspi.aims.media;

import java.util.Scanner;

public class DigitalVideoDisc extends Disc implements Playable{

//    public String getDirector() {
//        return director;
//    }
//
//    public float getLength() { return length; }


//    public void setDirector(String director) {
//        this.director = director;
//    }
//
//    public void setLength(float length) {
//        this.length = length;
//    }

//    public DigitalVideoDisc(String director, int length){
//        this.director = director;
//        this.length = length;
//    }


    public DigitalVideoDisc(){
        super();
    }



    public DigitalVideoDisc(String title, String category, String director, float length, float cost, int media_type){
        super(title, category, cost, director, length,media_type);
    }

//    public boolean search(String title){
//        boolean check = true;
//        String[] s1 = title.split("\\s+");
//        String[] s2 = this.title.split("\\s+");
//        for (String word : s1){
//            check = Arrays.asList(s2).contains(word);
//            if (!check)
//                return check;
//        }
//        return check;
//    }

    public Media inputInforDVD(){
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

    @Override
    public void play() {
        System.out.println("Playing DVD: " +   this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public String toString(){
        return "DVD" + "\n" + super.toString() + "\n" + "director: " + this.getDirector() + "\n"
                + "length: " + this.getLength() + "\n";
    }

    @Override
    public int compareTo(Object o) {
        if (this.getCost() > ((DigitalVideoDisc) o).getCost())
            return 1;
        if (this.getCost() < ((DigitalVideoDisc) o).getCost())
            return -1;

        return 0;
    }
}
