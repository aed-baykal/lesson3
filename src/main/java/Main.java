import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public static void getIncrement() {
        count++;
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Player player1 = new Player("ping", lock);
        Player player2 = new Player("pong", lock);
        while (count < 10) {
            player1.run();
            System.out.println(getCount());
            player2.run();
            System.out.println(getCount());
        }
    }
}
