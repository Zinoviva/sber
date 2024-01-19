import java.io.IOException;
import java.util.Scanner;

public class CounterApp {

    private final Counter counter;
    private final CounterStorage storage;

    public CounterApp() throws IOException {
        storage = new CounterStorage();
        counter = storage.loadCounter();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Счетчик загружен, значение" + "  " + counter.getCount());
        System.out.println("Введите одну из доступных команд: ");
        System.out.println("/inc - повышает количество счетчика на 1");
        System.out.println("/reset - сбрасывает значение счетчика");
        System.out.println("/stop - завершает выполнение программы и сохраняет значение счетчика");

        String input;

        while (true) {
            System.out.print("> ");
            input = scanner.nextLine();

            switch (input) {
                case "/inc" -> {
                    counter.increment();
                    saveCounterToStorage();
                    System.out.println("Операция выполнена!");
                    System.out.println("Текущее значение счетчика: " + counter.getCount());
                }
                case "/reset" -> {
                    counter.reset();
                    saveCounterToStorage();
                    System.out.println("Операция выполнена! Счетчик обнулен");
                }
                case "/stop" -> {
                    System.out.println("Текущее значение счетчика: " + counter.getCount() + ". Останавливаем программу");
                    return;
                }
                default ->
                        System.out.println("Неизвестная команда, вот список доступных /inc, /reset, /stop");
            }

        }
    }

    private void saveCounterToStorage() {  //для выз сохр
        try {
            storage.saveCounter(counter);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }



}
