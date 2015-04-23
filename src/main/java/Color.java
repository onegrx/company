/**
 * Created by onegrx on 16.04.15.
 */
public enum Color {

    BROWN(153, 102, 51),
    BLUE(0, 0, 255),
    GREEN(0, 255,0),
    GREY(128, 128, 128);

    private int r;
    private int g;
    private int b;

    Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
}
