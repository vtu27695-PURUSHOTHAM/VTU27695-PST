class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] daysOfWeek = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int totalDays = 0;
        
        // Sum days for past years
        for (int y = 1971; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }
        
        // Sum days for past months in current year
        for (int m = 1; m < month; m++) {
            if (m == 2 && isLeapYear(year)) {
                totalDays += 29;
            } else {
                totalDays += monthDays[m - 1];
            }
        }
        
        // Add remaining days of current month
        totalDays += (day - 1);
        
        return daysOfWeek[totalDays % 7];
    }
    
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
