package printer;

public class ASCIIRow implements Row {

    private String[][] data;
    private Cell cell;
    private String[] row;
    private Border border;
    private int index = -1;

    public ASCIIRow(String[][] data, Cell cell, Border border) {
        this.data = data;
        this.cell = cell;
        this.border = border;
    }

    @Override
    public boolean next() {
        index++;

        if (data.length > index) {
            row = data[index];
        }

        return data.length > index;
    }

    @Override
    public String getValue() {

        StringBuilder rowBuf = new StringBuilder();

        if (border.next()) {
            rowBuf.append(border.getValue());
        }

        cell.reset();
        border.reset();

        while (cell.next()) {
            int cellIndex = cell.getIndex();
            String rowData = "";

            if (cellIndex < row.length) {
                rowData = row[cellIndex];
            }

            rowBuf.append(cell.getValue(rowData));

            if (border.next()) {
                rowBuf.append(border.getValue());
            }
        }

        rowBuf.append("\n");

        return rowBuf.toString();
    }
}
