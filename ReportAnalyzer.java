import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportAnalyzer {

    public static void createSalesReport(List<TeslaSale> amount, String model) {
        System.out.println(model + " Yearly Sales Report");
        System.out.println("---------------------------");

        Map<Integer, Integer> yearlySales = amount.stream()
                .collect(Collectors.groupingBy
                        (teslaSale -> teslaSale.getYearMonth().getYear(),
                                Collectors.summingInt((TeslaSale::getNumberOfSales))));
        yearlySales.forEach((a, z) -> System.out.println(a + " -> " + z));
        System.out.println(" ");
    }
        public static void bestAndWorstSales(List < TeslaSale > amount, String model) {
            amount.stream()
                    .max(Comparator
                            .comparingInt(TeslaSale::getNumberOfSales))
                    .ifPresent(bestMonth ->
                            System.out.println("The best month for " + model + " was: " + bestMonth.getYearMonth()));

            amount.stream()
                    .min(Comparator
                            .comparingInt(TeslaSale::getNumberOfSales))
                    .ifPresent(worstMonth ->
                            System.out.println("The worst month for " + model + " was: " + worstMonth.getYearMonth()));
            System.out.println(" ");

        }

            public static void generateTeslaSaleReport(FileService read) {

                List<TeslaSale> model3 = read.getSalesFromFile("model3.csv");
                createSalesReport(model3, "Model 3");
                bestAndWorstSales(model3, "Model 3");

                List<TeslaSale> modelS = read.getSalesFromFile("modelS.csv");
                createSalesReport(modelS, "Model S");
                bestAndWorstSales(modelS, "Model S");

                List<TeslaSale> modelX = read.getSalesFromFile("modelX.csv");
                createSalesReport(modelX, "Model X");
                bestAndWorstSales(modelX, "Model X");
            }
        }



