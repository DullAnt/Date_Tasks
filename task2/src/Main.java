import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первую дату в формате ГГГГ-ММ-ДД:");
        String date1Str = scanner.nextLine();
        System.out.println("Введите вторую дату в формате ГГГГ-ММ-ДД:");
        String date2Str = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date1Str, formatter);
        LocalDate date2 = LocalDate.parse(date2Str, formatter);

        String result = compareDates(date1, date2);
        System.out.println(result);
    }

    public static String compareDates(LocalDate date1, LocalDate date2) {
        if (date1.isEqual(date2)) {
            return "Даты равны";
        } else if (date1.isBefore(date2)) {
            return "Первая дата меньше второй";
        } else {
            return "Первая дата больше второй";
        }
    }
}