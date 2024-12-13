import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        long daysUntilNewYear = daysUntilNewYear();

        System.out.println("До Нового года осталось " + daysUntilNewYear + " дней.");
    }

    public static long daysUntilNewYear() {
        LocalDate today = LocalDate.now();

        LocalDate newYear = LocalDate.of(today.getYear() + 1, 1, 1);

        long daysUntilNewYear = ChronoUnit.DAYS.between(today, newYear);

        return daysUntilNewYear;
    }
}