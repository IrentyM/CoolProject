public class TaxService {
    private TaxCalculator taxCalculator;

    public TaxService(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public double calculateEmployeeTax(Employee employee) {
        return taxCalculator.calculateTax(employee);
    }
}
