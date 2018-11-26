package printer;

import java.util.List;

public class ASCIICell implements Cell {

    private List<Column> columns;
    private int index = -1;
    private int align;

    public ASCIICell(List<Column> columns, int align) {
        this.columns = columns;
        this.align = align;
    }

    @Override
    public boolean next() {
        index++;
        return columns.size() > index;
    }

    @Override
    public void reset() {
        index = -1;
    }

    @Override
    public String getValue(String data) {
        Column column = columns.get(index);
        return getFormattedData(column.getWight(), data, align);
    }

    private String getFormattedData(int maxLength, String data, int align) {

        if (data == null) {
            data = "<null>";
        }

        data = " " + data + " ";

        if (data.length() > maxLength) {
            return data;
        }

        boolean toggle = true;

        while (data.length() < maxLength) {

            if (align == Table.ALIGN_LEFT) {
                data = data + " ";
            } else if (align == Table.ALIGN_RIGHT) {
                data = " " + data;
            } else if (align == Table.ALIGN_CENTER) {
                if (toggle) {
                    data = " " + data;
                    toggle = false;
                } else {
                    data = data + " ";
                    toggle = true;
                }
            }
        }

        return data;
    }

    @Override
    public int getIndex() {
        return index;
    }
}
