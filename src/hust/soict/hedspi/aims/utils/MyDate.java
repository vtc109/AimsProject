package hust.soict.hedspi.aims.utils;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Scanner;

public class MyDate {
    private int day;
    private int month;
    private int year;
//
    private String s_day;
    private String s_month;
    private String s_year;
//
    private String date;

//
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getDate() {
        return date;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public MyDate() {
        LocalDate imanojikan = LocalDate.now();
        this.year = imanojikan.getYear();
        this.month = imanojikan.getMonthValue();
        this.day = imanojikan.getDayOfMonth();
    }

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate(String date) {
        this.date = date;
    }

    public MyDate(String s_month, String s_day, String s_year) {
        this.s_day = s_day;
        this.s_month = s_month;
        this.s_year = s_year;
    }

    public MyDate accept(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter day");
        int day = Integer.parseInt(sc.nextLine());
        System.out.println("Please enter month");
        int month = Integer.parseInt(sc.nextLine());
        System.out.println("Please enter year");
        int year = Integer.parseInt(sc.nextLine());
        return new MyDate(day, month, year);
    }

    public void print(){
        if (day != 0 && month != 0 && year != 0)
            System.out.println(day + "/" + month + "/" + year);
        else if (date != null)
            System.out.println(date);
        else
            System.out.println(s_month + " " + s_day + " " + s_year);
    }
}
