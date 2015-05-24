package printer;

/**
 * Created by onegrx on 24.05.15.
 */
public class Producer implements Runnable{

    private final Printer printer;
    private static int id = 1;

    public Producer(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Document document = new Document("Doc No. " + id);
                id++;
                printer.print(document);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
