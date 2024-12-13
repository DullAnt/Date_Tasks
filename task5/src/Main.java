import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите год и месяц: ");
        Scanner year = new Scanner(System.in);
        Scanner month = new Scanner(System.in);

        System.out.println(countWeekendsInMonth(year.nextInt(), month.nextInt()));
    }

    public static int countWeekendsInMonth(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);

        LocalDate firstDayOfMonth = yearMonth.atDay(1);

        LocalDate lastDayOfMonth = yearMonth.atEndOfMonth();

        int weekendsCount = 0;

        for (LocalDate date = firstDayOfMonth; !date.isAfter(lastDayOfMonth); date = date.plusDays(1)) {
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                weekendsCount++;
            }
        }

        return weekendsCount;
    }
}