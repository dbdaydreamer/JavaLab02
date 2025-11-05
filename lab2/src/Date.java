package src;

public class Date {
    private int month;
    private int day;
    private int year;


    public Date(int month, int day, int year) {
        if (month >= 1 && month <= 12)
            this.month = month;
        else
            this.month = 1;
        int maxDays = 31;
        if (month == 2) maxDays = 28;
        else if (month == 4 || month == 6 || month == 9 || month == 11) maxDays = 30;

        if (day >= 1 && day <= maxDays)
            this.day = day;
        else
            this.day = 1;
        if (year > 0)
            this.year = year;
        else
            this.year = 2025;

    }

    public void displayDate() {
        System.out.println(month + "/" + day + "/" + year);
    }

}


class DateTest{
    public static void main(String[] args){
        Date date1 = new Date(10, 06, 2025);

        System.out.println("Сегодняшная дата:");
        date1.displayDate();
    }
}