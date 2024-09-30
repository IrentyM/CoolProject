public class StandardTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(Employee employee) {
        return employee.getSalary() * 0.2;
    }
}
