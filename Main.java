public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", 50000);

        TaxCalculator standardTaxCalculator = new StandardTaxCalculator();
        TaxService taxService = new TaxService(standardTaxCalculator);
        System.out.println("Standard Tax: " + taxService.calculateEmployeeTax(employee));

        TaxCalculator seniorTaxCalculator = new SeniorTaxCalculator();
        taxService = new TaxService(seniorTaxCalculator);
        System.out.println("Senior Employee Tax: " + taxService.calculateEmployeeTax(employee));
    }
}
