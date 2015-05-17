package consumers;

/**
 * Created by onegrx on 17.05.15.
 */
public enum Item {

    A("Apple"),
    B("Banana"),
    C("Cherry");

    private final String description;

    Item(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
