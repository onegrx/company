import java.math.*;

/**
 * Created by onegrx on 03.05.15.
 */
public class AverageSalaryVisitor implements Visitor {

    private static BigDecimal overallSum = BigDecimal.ZERO;
    private static int numberOfEmployees = 0;

    @Override
    public void visit(Employee e) {
        overallSum = overallSum.add(e.getSalary());
        numberOfEmployees++;
    }

    public BigDecimal printAverageSalary() {
        return overallSum.divide(new BigDecimal(numberOfEmployees), BigDecimal.ROUND_HALF_UP);
    }
}
