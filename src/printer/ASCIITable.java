package printer;

import java.util.ArrayList;
import java.util.List;

public class ASCIITable implements Table {

    private String[][] data;
    private String[] header;

    private List<Column> columns;

    private Row headPrinter;
    private Row rowPrinter;
    private Border borderPrinter;

    public ASCIITable(String[][] data, String[] header, int headerAlign, int dataAlign) {
        this.data = data;
        this.header = header;
        columns = new ArrayList<>();
        createColumns(headerAlign, dataAlign);
    }

    private void createColumns(int headerAlign, int dataAlign) {
        List<Integer> maxColumns = getMaxColLengths(getMaxColumns());

        if (header != null && header.length > 0) {
            for (int i = 0; i < maxColumns.size(); i++) {
                String headerName = "";

                if (i < header.length) {
                    headerName = header[i];
                }

                columns.add(new ASCIIColumn(headerName, headerAlign, dataAlign, maxColumns.get(i)));
            }
        }
    }

    private int getMaxItemLength(List<String> colData) {
        int maxLength = 0;
        for (int i = 0; i < colData.size(); i++) {
            maxLength = Math.max((colData.get(i) == null ? 6 : colData.get(i).length() + 2), maxLength);
        }
        return maxLength;
    }

    private int getMaxColumns() {
        int maxColumns = 0;
        for (int i = 0; i < data.length; i++) {
            maxColumns = Math.max(data[i].length, maxColumns);
        }
        maxColumns = Math.max(header.length, maxColumns);
        return maxColumns;
    }

    private List<Integer> getMaxColLengths(int colCount) {

        List<Integer> colMaxLenList = new ArrayList<Integer>(colCount);
        List<String> colData = null;
        int maxLength;

        for (int i = 0; i < colCount; i++) {
            colData = new ArrayList<String>();

            if (header != null && i < header.length) {
                colData.add(header[i]);
            }

            for (int j = 0; j < data.length; j++) {
                if (i < data[j].length) {
                    colData.add(data[j][i]);
                } else {
                    colData.add("");
                }
            }

            maxLength = getMaxItemLength(colData);
            colMaxLenList.add(maxLength);
        }

        return colMaxLenList;
    }

    @Override
    public String getTable() {

        /**
         * Table String buffer
         */
        StringBuilder tableBuf = new StringBuilder();

        if (borderPrinter.next()) {
            tableBuf.append(borderPrinter.getValue());
        }

        while (headPrinter.next()) {
            tableBuf.append(headPrinter.getValue());
        }

        if (borderPrinter.next()) {
            tableBuf.append(borderPrinter.getValue());
        }

        while (rowPrinter.next()) {
            tableBuf.append(rowPrinter.getValue());
        }

        if (borderPrinter.next()) {
            tableBuf.append(borderPrinter.getValue());
        }

        return tableBuf.toString();

    }

    public void setHeadPrinter(Row headPrinter) {
        this.headPrinter = headPrinter;
    }

    public void setRowPrinter(Row rowPrinter) {
        this.rowPrinter = rowPrinter;
    }

    public void setBorderPrinter(Border borderPrinter) {
        this.borderPrinter = borderPrinter;
    }

    public List<Column> getColumns() {
        return columns;
    }
}
