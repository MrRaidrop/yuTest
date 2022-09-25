public class ThreadExercise1 {
    //让步join
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (true) {
                    System.out.println("hi" + count);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (count == 10) {
                        break;
                    }
                    count++;
                }
            }
        });
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            System.out.println("hello" + i);
            if (i == 5) {
                t.start();
                t.join();
            }
        }
    }
}
