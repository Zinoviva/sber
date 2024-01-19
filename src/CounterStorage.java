import java.io.*;

public class CounterStorage {

    private final String STORAGE_PATH = "counter.dat";

    public void saveCounter(Counter counter) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(STORAGE_PATH))) {
            out.writeInt(counter.getCount());
        }
    }

    public Counter loadCounter() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(STORAGE_PATH))) {
            return new Counter(in.readInt());
        } catch (FileNotFoundException e) {
            return new Counter(0);
        }
    }
}
