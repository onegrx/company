package printer;

/**
 * Created by onegrx on 24.05.15.
 */
public class Document {

    private final String payload;

    public Document(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return payload;
    }
}
