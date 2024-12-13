import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        LocalDateTime startDateTime = null;
        while (startDateTime == null) {
            System.out.println("Введите начало рабочего дня в формате ДД.ММ.ГГГГ ЧЧ:ММ:СС:");
            String input = scanner.nextLine();
            try {
                startDateTime = LocalDateTime.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты и времени. Попробуйте снова.");
            }
        }

        LocalDateTime endDateTime = null;
        while (endDateTime == null) {
            System.out.println("Введите конец рабочего дня в формате ДД.ММ.ГГГГ ЧЧ:ММ:СС:");
            String input = scanner.nextLine();
            try {
                endDateTime = LocalDateTime.parse(input, formatter);
                if (endDateTime.isBefore(startDateTime)) {
                    System.out.println("Конец рабочего дня не может быть раньше начала. Попробуйте снова.");
                    endDateTime = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты и времени. Попробуйте снова.");
            }
        }

        long workingHours = calculateWorkingHours(startDateTime, endDateTime);

        System.out.println("Количество рабочих часов: " + workingHours);

        scanner.close();
    }

    public static long calculateWorkingHours(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        LocalDateTime current = startDateTime;
        long totalWorkingHours = 0;

        while (current.isBefore(endDateTime)) {
            if (current.getDayOfWeek() != DayOfWeek.SATURDAY && current.getDayOfWeek() != DayOfWeek.SUNDAY) {
                LocalDateTime dayStart = current.withHour(startDateTime.getHour()).withMinute(startDateTime.getMinute()).withSecond(startDateTime.getSecond());
                LocalDateTime dayEnd = current.withHour(endDateTime.getHour()).withMinute(endDateTime.getMinute()).withSecond(endDateTime.getSecond());

                if (current.isEqual(startDateTime)) {
                    dayStart = startDateTime;
                }

                if (current.toLocalDate().isEqual(endDateTime.toLocalDate())) {
                    dayEnd = endDateTime;
                }

                if (dayEnd.isAfter(dayStart)) {
                    totalWorkingHours += Duration.between(dayStart, dayEnd).toHours();
                }
            }

            current = current.plusDays(1).withHour(startDateTime.getHour()).withMinute(startDateTime.getMinute()).withSecond(startDateTime.getSecond());
        }

        return totalWorkingHours;
    }
}