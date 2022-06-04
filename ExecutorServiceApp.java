package threads.thread_creation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceApp {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int w = i;
            service.execute(() -> {
                    System.out.println(w + " - Begin");
            try {
                Thread.sleep(100 + (int) (3000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(w + " - End");

            });
        }
        service.shutdown();
    }
}
