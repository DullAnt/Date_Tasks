import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дату в формате ГГГГ-ММ-ДД:");
        String dateInput = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateInput);

        System.out.println("Введите локаль (например, ru или en):");
        String localeInput = scanner.nextLine();
        Locale locale = Locale.forLanguageTag(localeInput);

        formatDateWithLocale(date, locale);

        scanner.close();
    }

    public static void formatDateWithLocale(LocalDate date, Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(locale);

        String formattedDate = date.format(formatter);
        System.out.println("Дата в формате локали " + locale.getDisplayName() + ": " + formattedDate);
    }
}