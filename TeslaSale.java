import java.time.YearMonth;

public class TeslaSale {

    private YearMonth yearMonth;
    private Integer numberOfSales;

    TeslaSale(YearMonth yearMonth, Integer numberOfSales) {
        this.yearMonth = yearMonth;
        this.numberOfSales = numberOfSales;
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(Integer numberOfSales) {
        this.numberOfSales = numberOfSales;
    }


    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }

}
