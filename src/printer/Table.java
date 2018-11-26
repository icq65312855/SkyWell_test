package printer;

import java.util.List;

public interface Table {

    int ALIGN_LEFT = -1;
    int ALIGN_CENTER = 0;
    int ALIGN_RIGHT = 1;

    int DEFAULT_HEADER_ALIGN = ALIGN_CENTER;
    int DEFAULT_DATA_ALIGN = ALIGN_LEFT;

    String getTable();

    void setHeadPrinter(Row headPrinter);
    void setRowPrinter(Row rowPrinter);
    void setBorderPrinter(Border borderPrinter);

    List<Column> getColumns();

}
