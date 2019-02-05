/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaDateCalculation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Ali Adame
 */
public class FirstBusinessDayFromMonth {
    
    public static void main(String[] args) {
        
        int monthOfYear = 0; // January
        int year = 2019;
        
        getDateFromFirstMondayOfMonthAndYear(monthOfYear, year); // Firsts days of month got skipeed due to new year vacation
        
        monthOfYear = 7; year = 2019; // August 2019
        
        getDateFromFirstMondayOfMonthAndYear(monthOfYear, year); // August first monday test
        
    }
    
    /**
     * Displays a date forecast method for the first business day (Monday) of month (with year) 
     * @param month the month with a 0-11 interval when 0 is January and 11 is December
     * @param year specified as a 4 digit value
     * @return date with the calculation of first business day of month
     * @version 0.1
     * @author Ali Adame
     */
    public static Date getDateFromFirstMondayOfMonthAndYear(int month, int year) {
        //Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        
        if(month > 0) {
            calendar.set(year, month-1, 1);
        } else {
            calendar.set(year-1, month+11, 1);
        }
        
        calendar.add(Calendar.MONTH, 1);//Used for finding next month
        calendar.set(Calendar.DAY_OF_MONTH, 1);//Setting the Day of month as 1 for starting    
        while (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                   || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) {
            calendar.add(Calendar.DATE, 1); //In the first case decease day by 1 so get the this months last day
        } // Checking whether the last day is saturday or sunday then it will decrease by 1
        
        while (calendar.get(Calendar.DAY_OF_YEAR) <= 6 || calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DATE, 1); //In the first case decease day by 1 so get the this months last day
        }
        
        Date firstBusinessDayOfMonth = calendar.getTime();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("First Business Day of month "+ (calendar.get(Calendar.MONTH)+1) + " " + sdf.format(firstBusinessDayOfMonth));
        return firstBusinessDayOfMonth;
    }
    
}
