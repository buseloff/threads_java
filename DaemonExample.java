package threads.thread_creation;

public class DaemonExample {
    public static void main(String[] args) {
        Thread threadTimer = new Thread(() -> {
            int time = 0;
            while (true) {
                try {
                    Thread.sleep(500);
                    time++;
                    System.out.println("time: " + time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadTimer.setDaemon(true);
        threadTimer.start();
        System.out.println("main -> sleep");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main -> end");
    }
}
