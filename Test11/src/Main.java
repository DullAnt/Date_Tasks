import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Формат даты
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate startDate = null;
        while (startDate == null) {
            System.out.println("Введите начальную дату в формате ДД.ММ.ГГГГ:");
            String input = scanner.nextLine();
            try {
                startDate = LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Попробуйте снова.");
            }
        }

        LocalDate endDate = null;
        while (endDate == null) {
            System.out.println("Введите конечную дату в формате ДД.ММ.ГГГГ:");
            String input = scanner.nextLine();
            try {
                endDate = LocalDate.parse(input, formatter);
                if (endDate.isBefore(startDate)) {
                    System.out.println("Конечная дата не может быть раньше начальной. Попробуйте снова.");
                    endDate = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Попробуйте снова.");
            }
        }

        LocalDate randomDate = generateRandomDate(startDate, endDate);

        System.out.println("Случайная дата в указанном диапазоне: " + randomDate.format(formatter));

        scanner.close();
    }

    public static LocalDate generateRandomDate(LocalDate startDate, LocalDate endDate) {
        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();
        long randomEpochDay = startEpochDay + new Random().nextLong(endEpochDay - startEpochDay + 1);
        return LocalDate.ofEpochDay(randomEpochDay);
    }
}