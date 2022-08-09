package hust.soict.hedspi.aims.media;

import java.util.Arrays;

public abstract class  Media implements Comparable{
    public String title;
    public String category;
    public float cost;

    public int ID;

    public int media_type;

    public Media(String title, String category, float cost, int media_type) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.media_type = media_type;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getCost() {
        return cost;
    }

    public int getMedia_type() {
        return media_type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public String toString(){       //may be to abstract?
        return "title: " + title + "\ncategory: " + category + "\nprice: " + cost;
    }

    public boolean search(String title){
        boolean check = true;
        String[] s1 = title.split("\\s+");
        String[] s2 = this.title.split("\\s+");
        for (String word : s1){
            check = Arrays.asList(s2).contains(word);
            if (!check)
                return check;
        }
        return check;
    }

    public Media(){
        super();
    }

    public boolean equals(Object o){
        return this.ID == ((Media) o).getID();
    }

    public int compareTo(Object o){
        return this.title.compareTo(((Media)o).getTitle());
    }
}
