import java.net.SocketOption;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

// 线程1不断输出随机数，线程2按q可以终止线程1

public class ThreadExercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T t1 = new T();
        B t2 = new B(t1);
        Thread t11 = new Thread(t1);
        Thread t22 = new Thread(t2);
        t11.start();
        t22.start();
    }
}

class T implements Runnable {
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            System.out.println((int)(Math.random() * 100 + 1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class B implements Runnable {
    private T t;
    public Scanner scanner = new Scanner(System.in);

    public B(T t) {
        this.t = t;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("input 'q' to quit");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                t.setLoop(false);
                break;
            }

        }
    }
}

