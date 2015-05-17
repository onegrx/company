package consumers;

import java.util.*;

/**
 * Created by onegrx on 17.05.15.
 */
public class Producer implements Runnable {

    private final Item item;
    private final Monitor monitor;
    private static final Random rand = new Random();

    public Producer(Item item, Monitor monitor) {
        this.item = item;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                monitor.produce(item);
                Thread.sleep(rand.nextInt(2000) + 1);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
