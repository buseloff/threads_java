package threads.thread_creation;

public class DoubleJoinApp {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.err.println("t1 - " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.err.println("t2 - " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            System.err.println("1");
            thread1.join();
            System.err.println("2");
            thread2.join();
            System.err.println("3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
