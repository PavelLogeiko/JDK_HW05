import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        int COUNT = 5; //Количество философов

        System.out.println("\nПять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.");
        System.out.println("\nКаждый философ должен поесть три раза. Ниже представлен результат работы приложения.\n");

        ArrayList<ReentrantLock> forks = new ArrayList<>();
        ArrayList<PhThread> phThreads = new ArrayList<>();

        for (int i = 0; i < COUNT; i++) {
            forks.add(new ReentrantLock());
        }
        for (int i = 0; i < COUNT; i++) {
            phThreads.add(new PhThread("Философ "+(i+1), forks.get(i), forks.get((i + 1) % COUNT)));
        }
        for (int i = 0; i < COUNT; i++) {
            phThreads.get(i).start();
        }
    }
}