package printer;

import test.ASCIITableHeader;
import test.IASCIITableAware;

public interface TablePrinter {

    /**
     * Prints the ASCII table to console.
     *
     * @param header
     * @param data
     */
    void printTable(String[] header, String[][] data);

    void printTable(String[] header, String[][] data, int dataAlign);

    void printTable(String[] header, int headerAlign, String[][] data, int dataAlign);

}
