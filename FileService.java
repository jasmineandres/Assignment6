import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public List<TeslaSale> getSalesFromFile(String fileName) {
        List<TeslaSale> teslaSales = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] parts = line.split(",");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy");
                YearMonth saleDate = YearMonth.parse(parts[0], formatter);
                Integer numberOfSales = Integer.valueOf(parts[1]);
                TeslaSale teslaSale = new TeslaSale(saleDate, numberOfSales);
                teslaSales.add(teslaSale);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return teslaSales;

    }

}



