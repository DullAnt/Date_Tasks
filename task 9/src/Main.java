import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

                System.out.print("Введите свой день рождения (в формате ДД.ММ.ГГГГ): ");
                String birthdayString = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate birthday = LocalDate.parse(birthdayString, formatter);
                LocalDate today = LocalDate.now();
                Period period = Period.between(birthday, today);
                int age = period.getYears();
                System.out.println("Текущий возраст: " + age + " лет");

        }
    }
