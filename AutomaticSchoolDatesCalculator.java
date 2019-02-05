package javaDateCalculation;

public class AutomaticSchoolDatesCalculator {
    
    public static void main(String[] args) {
        AutomaticSchoolDatesCalculator.DateForecastBasedOnSchoolPeriod(20152, 20181);
    }
    
    /**
     * Displays a date forecast method for year periods of year (or year with semester) 
     * of a determined period of time.
     * @param yearBeginning a year for the init calculation
     * @param  yearEnd a year for the end calculation
     * @version 0.1
     * @author Ali Adame
     */
    public static void DateForecastBasedOnSchoolPeriod(int yearBeginning, int yearEnd) {
        String yearInitString = String.valueOf(yearBeginning).trim();
        // With a predictor of a 5 characters long description we try to tackle another yearly concept based on 
        // two periods one for the first semester of the year, two for the second
        if(yearInitString.length() == 5 && ("1").equals(yearInitString.substring(yearInitString.length()-1))) {
            yearInitString = yearInitString.substring(0, yearInitString.length()-1);
            yearBeginning = Integer.parseInt(yearInitString);
            // Courses start on january en Mexico, during second week of month
            FirstBusinessDayFromMonth.getDateFromFirstMondayOfMonthAndYear(0, yearBeginning); // Month zero is January
        } else if(yearInitString.length() == 5 && ("2").equals(yearInitString.substring(yearInitString.length()-1))) {
            yearInitString = yearInitString.substring(0, yearInitString.length()-1);
            yearBeginning = Integer.parseInt(yearInitString);
            FirstBusinessDayFromMonth.getDateFromFirstMondayOfMonthAndYear(7, yearBeginning); // Month seven is August
        } else if(yearInitString.length() == 4) {
            // Usually, yearly courses start after summer
            FirstBusinessDayFromMonth.getDateFromFirstMondayOfMonthAndYear(7, yearBeginning);
        }
        
        String yearEndString = String.valueOf(yearEnd).trim();
        if(yearEndString.length() == 5 && ("1").equals(yearEndString.substring(yearEndString.length()-1))) {
            yearEndString = yearEndString.substring(0, yearEndString.length()-1);
            yearEnd = Integer.parseInt(yearEndString);
            // Courses of this period end before summer
            LastBusinessDayFromMonth.getDateFromLastBusinessDayOfMonthAndYear(4, yearEnd); // Month four is May
        } else if(yearEndString.length() == 5 && ("2").equals(yearEndString.substring(yearEndString.length()-1))) {
            System.out.println("aca merengues");
            yearEndString = yearEndString.substring(0, yearEndString.length()-1);
            yearEnd = Integer.parseInt(yearEndString);
            // Courses that end on winter usually happen before Christmas
            LastBusinessDayFromMonth.getDateFromLastBusinessDayOfMonthAndYear(11, yearEnd); // Month eleven is December
        } else if(yearEndString.length() == 4) {
            // Usually, yearly courses start end before summer
            LastBusinessDayFromMonth.getDateFromLastBusinessDayOfMonthAndYear(4, yearEnd); // Month four is May
        }
    }
    
}
