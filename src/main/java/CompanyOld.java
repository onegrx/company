/**
 * Created by onegrx on 04.04.15.
 */
public class CompanyOld {

    /**
     * Singleton DP representing a sample company.
     */
    private static CompanyOld instance;
    private Manager ceo;

    private CompanyOld() {
    }

    public static CompanyOld getInstance() {
        if(instance == null) {
            instance = new CompanyOld();
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
