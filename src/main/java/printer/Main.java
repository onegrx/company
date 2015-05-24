package printer;

import java.util.concurrent.*;

/**
 * Created by onegrx on 24.05.15.
 */
public class Main {

    private static final int numberOfProducers = 512;
    private static final int numberOfConsumers = 128;

    public static void main(String[] args) {

        Printer printer = new Printer(15);
        Serviceman serviceman = new Serviceman(printer);

        ScheduledExecutorService servicemanExecutor = new ScheduledThreadPoolExecutor(1);
        servicemanExecutor.scheduleAtFixedRate(serviceman, 1l, 7l, TimeUnit.SECONDS);

        ExecutorService producers = Executors.newFixedThreadPool(numberOfProducers);
        ExecutorService consumers = Executors.newFixedThreadPool(numberOfConsumers);

        for (int i = 0; i < numberOfProducers; i++) {
            producers.execute(new Producer(printer));
        }
        for (int i = 0; i < numberOfConsumers; i++) {
            consumers.execute(new Consumer(printer));
        }
    }
}
