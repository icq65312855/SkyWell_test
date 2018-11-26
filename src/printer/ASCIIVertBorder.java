package printer;

import java.util.List;

public class ASCIIVertBorder implements Border {
    private List<Column> columns;
    private int index = -1;

    public ASCIIVertBorder(List<Column> columns) {
        this.columns = columns;
    }

    @Override
    public void reset() {
        index = -1;
    }

    @Override
    public boolean next() {
        index++;
        return columns.size() >= index;
    }

    @Override
    public String getValue() {
        return "|";
    }
}
