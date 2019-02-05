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
public class LastBusinessDayFromMonth {
    
    public static void main(String[] args) {
        int monthOfYear = 11; // December
        int year = 2019;
        
        getDateFromLastBusinessDayOfMonthAndYear(monthOfYear, year); // Last monday without Christmas' holyday week
        
        monthOfYear = 4; // May
        
        getDateFromLastBusinessDayOfMonthAndYear(monthOfYear, year); // Last may's Friday calculation
    }
    
    /**
     * Displays a date forecast method for the last business day (Friday) of month (with year) 
     * @param month the month with a 0-11 interval when 0 is January and 11 is December
     * @param year specified as a 4 digit value
     * @return date with the calculation of last business day of month
     * @version 0.1
     * @author Ali Adame
     */
    public static Date getDateFromLastBusinessDayOfMonthAndYear(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);

        calendar.add(Calendar.MONTH, 1);//Used for finding next month
        calendar.set(Calendar.DAY_OF_MONTH, 1);//Setting the Day of month as 1 for starting    
        while (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                   || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) {
            calendar.add(Calendar.DATE, -1); //In the first case decease day by 1 so get the this months last day
        } // Checking whether the last day is saturday or sunday then it will decrease by 1
        while ((calendar.get(Calendar.DAY_OF_MONTH) >= 24 && calendar.get(Calendar.MONTH) == 11) 
                || calendar.get(Calendar.DAY_OF_WEEK) != Calendar.FRIDAY || calendar.get(Calendar.YEAR) != year){
            calendar.add(Calendar.DATE, -1); //In the first case decease day by 1 so get the this months last day
        }
        
        Date lastDayOfMonth = calendar.getTime();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Last Business Day of month "+ (calendar.get(Calendar.MONTH)+1) + " " + sdf.format(lastDayOfMonth));
            
        return lastDayOfMonth;
    }
    
}
