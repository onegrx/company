/**
 * Created by onegrx on 04.04.15.
 */
public class Company {

    /**
     * Singleton DP representing a sample company.
     */
    private static Company instance;
    private Manager ceo;

    private Company() {
    }

    public static Company getInstance() {
        if(instance == null) {
            instance = new Company();
        }
        return instance;

    }

    public void hireCEO(Manager m) { //should be interface Manager or class GroupManager?
        if(ceo == null) {
            ceo = m;
        }
        else {
            System.out.println(m + "cannot be hired as CEO");
        }
    }

    public Manager getCEO() {
        return ceo;
    }
}
