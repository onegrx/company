package printer;

import java.util.*;
import java.util.concurrent.locks.*;

/**
 * Created by onegrx on 24.05.15.
 */
public class Printer {

    private boolean healthy = true;
    private final int capacity;
    private final List<Document> tray = new LinkedList<>();
    private final ReentrantLock lock = new ReentrantLock();

    public Printer(int capacity) {
        this.capacity = capacity;
    }

    public void print(Document doc) {
        lock.lock();
        try {

        }
        finally {
            lock.unlock();
        }
    }

    public Document consume() {
        return null;
    }

    public void repair() {
        lock.lock();
        try {

        }
        finally {
            lock.unlock();
        }
    }
}
