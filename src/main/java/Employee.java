/**
 * Created by onegrx on 02.04.15.
 */
public interface Employee {
    String getName();
    RoleInCompany getRole();
    String getResponsibilityChain();
    String getDescription();
    String work();

    Manager getSupervisor();
    void setSupervisor(Manager supervisor);

}
