package printer;

import java.util.List;

public class ASCIITablePrinter implements TablePrinter {

    private static ASCIITablePrinter instance = null;

    private ASCIITablePrinter() {
    }

    public static synchronized ASCIITablePrinter getInstance() {
        if (instance == null) {
            instance = new ASCIITablePrinter();
        }
        return instance;
    }

    @Override
    public void printTable(String[] header, String[][] data) {
        printTable(header, Table.DEFAULT_HEADER_ALIGN, data, Table.DEFAULT_DATA_ALIGN);
    }

    @Override
    public void printTable(String[] header, String[][] data, int dataAlign) {
        printTable(header, Table.DEFAULT_HEADER_ALIGN, data, dataAlign);
    }

    @Override
    public void printTable(String[] header, int headerAlign, String[][] data, int dataAlign) {
        Table table = new ASCIITable(data, header, headerAlign, dataAlign);
        List<Column> columns = table.getColumns();

        String[][] dataHeader = new String[][]{header};

        table.setHeadPrinter(new ASCIIRow(dataHeader, new ASCIICell(columns, headerAlign), new ASCIIVertBorder(columns)));
        table.setRowPrinter(new ASCIIRow(data, new ASCIICell(columns, dataAlign), new ASCIIVertBorder(columns)));
        table.setBorderPrinter(new ASCIIHorizBorder(columns));

        System.out.println(table.getTable());
    }
}
