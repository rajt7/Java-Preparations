package OOP;

import java.util.*;

public class Tester {
    public static void main(String[] args){
        Date stockUpdateDate = new Date();
        Calendar calendar = Calendar.getInstance();
        // System.out.println(calendar);
        Date threeMonthsAgo = calendar.getTime();
        System.out.println(threeMonthsAgo);
        // stockUpdateDate = stockUpdateDate.after(threeMonthsAgo);
        // System.out.println(stockUpdateDate);
    }
    
}
