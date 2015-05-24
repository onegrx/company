package printer;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/**
 * Created by onegrx on 24.05.15.
 */
public class Printer {

    private boolean healthy = true;
    private final int capacity;
    private final Random rand = new Random();

    private final Queue<Document> tray = new LinkedList<>();
    private final ReentrantLock lock = new ReentrantLock();

    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public Printer(int capacity) {
        this.capacity = capacity;
    }

    public void print(Document doc) throws InterruptedException {
        lock.lock();
        try {
            while((!healthy) || (tray.size() == capacity)) {
                notFull.await();
            }
            tray.add(doc);
            System.out.println(doc + " was printed.");
            Thread.sleep(256);
            if(rand.nextInt(20) == 1) {
                healthy = false;
            }
            //notEmpty?
        }
        finally {
            lock.unlock();
        }
    }

    public Document consume() throws InterruptedException {
        lock.lock();
        try {
            while((!healthy) || (tray.isEmpty())) {
                notEmpty.await();
            }
            Document doc = tray.poll();
            //notFull?
            System.out.println(doc + "was consumed.");
            return doc;
        }
        finally {
            lock.unlock();
        }
    }

    public void repair() throws InterruptedException{
        lock.lock();
        try {
            Thread.sleep(2000l);
            healthy = true;
            System.out.println("The printer has just been repaired.");
            //Is it below essential to signalAll on both conditions?
            notFull.signalAll();
            notEmpty.signalAll();
        }
        finally {
            lock.unlock();
        }
    }
}
