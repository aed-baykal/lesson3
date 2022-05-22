import java.util.concurrent.locks.Lock;

public class Player implements Runnable{

    private final String name;
    private final Lock lock;

    public Player(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock.tryLock()) {
                System.out.println(getName());
                Main.getIncrement();
            }
        } finally {
            lock.unlock();
        }
    }

    public String getName() {
        return name;
    }

}
