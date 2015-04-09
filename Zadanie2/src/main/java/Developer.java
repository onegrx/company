/**
 * Created by onegrx on 03.04.15.
 */
public class Developer extends Worker {

    public Developer(String name, String role) {
        super(name, role);
    }

    @Override
    public String work() {
        return getName() + " " + getRole() + " is creating new features";
    }

    public String toString() {

        String s = "Developer: " + getName() + " ";
        return s;

    }
}


