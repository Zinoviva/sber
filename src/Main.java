import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            CounterApp counterApp = new CounterApp();
            counterApp.start();
        } catch (IOException e) {
            System.out.println("Ошибка при запуске приложения: " + e.getMessage());
        }
    }
}
