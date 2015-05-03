/**
 * Created by onegrx on 14.04.15.
 */

public enum RoleInCompany {
    CEO ("CEO"),
    GROUP_MANAGER ("Group Manager"),
    DEVELOPER ("Developer"),
    TESTER ("Tester");


    private final String roleInCompany;

    RoleInCompany(String roleInCompany) {
        this.roleInCompany = roleInCompany;
    }

    @Override
    public String toString() {
        return roleInCompany;
    }

}


