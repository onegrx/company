/**
 * Created by onegrx on 02.04.15.
 */
public interface Employee {
    String getName();
    String getRole();
    String getResponsibilityChain();
    String getDescription();
    String work();

    Manager getSupervisor();
    void setSupervisor(Manager supervisor);

}
