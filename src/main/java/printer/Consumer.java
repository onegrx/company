package printer;

/**
 * Created by onegrx on 24.05.15.
 */
public class Consumer implements Runnable{

    private final Printer printer;

    public Consumer(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        while(true) {
            try {
                printer.consume();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
