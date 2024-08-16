
public class Main {

    public static void main(String[] args) {

        FileService fileService = new FileService();
        ReportAnalyzer.generateTeslaSaleReport(fileService);

    }
}