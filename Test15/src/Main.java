import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDate date = null;
        while (date == null) {
            System.out.println("Введите дату в формате ДД.ММ.ГГГГ:");
            String input = scanner.nextLine();
            try {
                date = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Попробуйте снова.");
            }
        }

        String dayOfWeek = getDayOfWeekInRussian(date);

        System.out.println("День недели: " + dayOfWeek);

        scanner.close();
    }

    public static String getDayOfWeekInRussian(LocalDate date) {
        Locale russianLocale = new Locale("ru", "RU");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE", russianLocale);
        return date.format(formatter);
    }
}