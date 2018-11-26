import printer.ASCIITablePrinter;
import printer.Table;
import test.ASCIITable;

public class Main {

    private static final String[] HEADER = new String[]{"ID", "NAME", "ACCOUNT", "DEBT"};

    public static void main(String[] args) {
        String[][] data = {
            {"1", "Stepan", "123.00"},
            {"2", "Ivan", "23.00", "32.00"},
            {"3", "John", "0.00", "321.00", "active"}
        };

        System.out.println("OLD");
        ASCIITable.getInstance().printTable(HEADER, data);
        System.out.println("NEW");
        ASCIITablePrinter.getInstance().printTable(HEADER, data);

    }
}
