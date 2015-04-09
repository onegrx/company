/**
 * Created by onegrx on 04.04.15.
 */
public class Company {

    private static Company _instance;
    private Manager ceo;

    private Company() {
    }

    public static Company getInstance() {
        if(_instance == null) {
            _instance = new Company();
        }
        return _instance;

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
