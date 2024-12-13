import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        LocalDateTime eventDateTime = null;
        while (eventDateTime == null) {
            System.out.println("Введите дату и время события в формате ДД.ММ.ГГГГ ЧЧ:ММ:СС:");
            String input = scanner.nextLine();
            try {
                eventDateTime = LocalDateTime.parse(input, formatter);
                if (eventDateTime.isBefore(LocalDateTime.now())) {
                    System.out.println("Введенная дата и время уже прошли. Попробуйте снова.");
                    eventDateTime = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты и времени. Попробуйте снова.");
            }
        }

        calculateTimeUntilEvent(eventDateTime);

        scanner.close();
    }

    public static void calculateTimeUntilEvent(LocalDateTime eventDateTime) {
        LocalDateTime now = LocalDateTime.now();

        if (eventDateTime.isBefore(now)) {
            System.out.println("Событие уже прошло.");
            return;
        }

        Duration duration = Duration.between(now, eventDateTime);

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        System.out.println("До события осталось: " + hours + " часов, " + minutes + " минут, " + seconds + " секунд.");
    }
}