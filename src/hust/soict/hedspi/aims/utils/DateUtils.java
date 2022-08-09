package hust.soict.hedspi.aims.utils;

import java.util.ArrayList;
import java.util.Collections;

public class DateUtils {
    public static int compareDate(MyDate date1, MyDate date2){
        int year1 = date1.getYear();
        int year2 = date2.getYear();

        int month1 = date1.getMonth();
        int month2 = date2.getMonth();

        int day1 = date1.getDay();
        int day2 = date2.getDay();

        if (year2 > year1)
            return 2;
        else if (year2 == year1)
            if (month2 > month1)
                return 2;
            else if (month2 == month1)
                if (day2 > day1)
                    return 2;
                else if (day2 == day1)
                    return 1;
                else
                    return 0;
            else
                return 0;
        else
            return 0;
    }


    public void sortDate(ArrayList<MyDate> listOfDate){
        boolean check = true;
        while (check){
            check = false;
            int i;
            for (i = 0; i < listOfDate.size(); i++){
                if (compareDate(listOfDate.get(i), listOfDate.get(i+1)) == 0){
                    check = true;
                    Collections.swap(listOfDate, i, (i+1));
                }
            }
        }
    }
}
