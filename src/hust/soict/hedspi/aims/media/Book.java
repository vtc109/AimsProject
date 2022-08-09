package hust.soict.hedspi.aims.media;

import java.lang.reflect.Array;
import java.util.*;

public class Book extends Media {
    private String content;

    private List<String> contentTokens = new ArrayList<String>();

    private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();

    private ArrayList<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost, ArrayList<String> authors,int media_type) {
        super(title, category, cost, media_type);
        this.authors.addAll(authors);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getContentTokens() {
        return contentTokens;
    }

    public Map<String, Integer> getWordFrequency() {
        return wordFrequency;
    }

    public void addAuthor(String author){        // author co the la 1 nguoi hoac 1 list of authors
        this.authors.add(author);
    }

    public void addAuthor(ArrayList<String> authors){
        this.authors.addAll(authors);
    }

    public ArrayList<String> getAuthors(){
        return this.authors;
    }

    public void removeAuthor(String author){
        this.authors.remove(new String(author));
    }

    public Media inputInforB(){
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

    public Book(){
        super();
    }

    public String toString(){
        return "Book" + "\n" + super.toString() + "\n" + "List of authors: " + this.authors.toString() + "\n"
                + "Content length: " + contentTokens.size() + "\n" + "Word frequency: " + wordFrequency.entrySet();
    }

    public void processContent(){
        contentTokens.addAll(Arrays.asList(content.split("\\s+")));
        java.util.Collections.sort((java.util.List) contentTokens);

        String key;

        for (int i = 0; i < contentTokens.size(); i++){
            key = contentTokens.get(i);
            if (!wordFrequency.containsKey(key))
                wordFrequency.put(key, 1);
            else
                wordFrequency.put(key, wordFrequency.get(key) + 1);
        }
    }
}
