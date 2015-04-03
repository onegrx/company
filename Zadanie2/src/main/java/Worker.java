/**
 * Created by onegrx on 03.04.15.
 */
public abstract class Worker implements Employee {

    private final String name;
    private String role;

    public Worker(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRole() {
        return role;
    }

}
