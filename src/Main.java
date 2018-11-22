import test.ASCIITable;

public class Main {

    private static final String[] HEADER = new String[]{"ID", "NAME", "ACCOUNT", "DEBT"};

    public static void main(String[] args) {
        String[][] data = {
            {"1", "Stepan", "123.00"},
            {"2", "Ivan", "23.00", "32.00"},
            {"3", "John", "0.00", "321.00", "active"}
        };

        ASCIITable.getInstance().printTable(HEADER, data);
    }
}
