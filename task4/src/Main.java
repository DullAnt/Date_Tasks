import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите год: ");
        Scanner year = new Scanner(System.in);
        System.out.println(isLeapYear(year.nextInt()));
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}