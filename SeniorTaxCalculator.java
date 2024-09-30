public class SeniorTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(Employee employee) {
        return employee.getSalary() * 0.15;
    }
}
