package printer;

/**
 * Created by onegrx on 24.05.15.
 */
public class Serviceman implements Runnable{

    private final Printer printer;

    public Serviceman(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        while(true) {
            try {
                printer.repair();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
