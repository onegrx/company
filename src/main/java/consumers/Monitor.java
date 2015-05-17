package consumers;

/**
 * Created by onegrx on 17.05.15.
 */
public interface Monitor {
    void consume(Item item);
    void produce(Item item);
}
