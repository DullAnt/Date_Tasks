public class Main {
    public static void main(String[] args) {
        long executionTime = measureExecutionTime(() -> calculateFactorial(99999999));
        System.out.println("Время выполнения: " + executionTime + " мс");
    }

    public static long calculateFactorial(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;

    }

    public static long measureExecutionTime(Runnable method) {
        long startTime = System.currentTimeMillis();
        method.run();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}