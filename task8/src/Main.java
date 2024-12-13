import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дату и время в формате yyyy-MM-dd'T'HH:mm:ss'Z' :");
        String inputDateTime = scanner.nextLine();

        String convertedDateTime = convertTimeZone(inputDateTime, "UTC", "Europe/Moscow");

        System.out.println("Дата и время в часовом поясе Europe/Moscow: " + convertedDateTime);
    }

    public static String convertTimeZone(String dateTime, String fromZone, String toZone) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTime, formatter.withZone(ZoneId.of(fromZone)));

        ZonedDateTime convertedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of(toZone));

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        return convertedDateTime.format(outputFormatter);
    }
}