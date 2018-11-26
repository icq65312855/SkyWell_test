package printer;

import java.util.List;

public class ASCIIHorizBorder implements Border {
    private List<Column> columns;

    public ASCIIHorizBorder(List<Column> columns) {
        this.columns = columns;
    }

    @Override
    public boolean next() {
        return true;
    }

    @Override
    public void reset() {

    }

    @Override
    public String getValue() {
        return getRowLineBuf();
    }

    /**
     * Each string item rendering requires the border and a space on both sides.
     * <p/>
     * 12   3   12      3  12    34
     * +-----   +--------  +------+
     * abc      venkat     last
     *
     * @return
     */
    private String getRowLineBuf() {

        StringBuilder rowBuilder = new StringBuilder();
        int colWidth = 0;
        int colCount = columns.size();

        for (int i = 0; i < colCount; i++) {

            colWidth = columns.get(i).getWight()+1;

            for (int j = 0; j < colWidth; j++) {
                if (j == 0) {
                    rowBuilder.append("+");
                } else if ((i + 1 == colCount && j + 1 == colWidth)) {//for last column close the border
                    rowBuilder.append("-+");
                } else {
                    rowBuilder.append("-");
                }
            }
        }

        return rowBuilder.append("\n").toString();
    }
}
