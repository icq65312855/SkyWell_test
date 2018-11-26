package printer;


import test.IASCIITable;

public class ASCIIColumn implements Column {

    private String headerName = "";
    private int headerAlign = IASCIITable.DEFAULT_HEADER_ALIGN;
    private int dataAlign = IASCIITable.DEFAULT_DATA_ALIGN;

    private int wight = 0;

    public ASCIIColumn(String headerName, int headerAlign, int dataAlign, int wight) {
        this.headerName = headerName;
        this.headerAlign = headerAlign;
        this.dataAlign = dataAlign;
        this.wight = wight;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public int getHeaderAlign() {
        return headerAlign;
    }

    public void setHeaderAlign(int headerAlign) {
        this.headerAlign = headerAlign;
    }

    public int getDataAlign() {
        return dataAlign;
    }

    public void setDataAlign(int dataAlign) {
        this.dataAlign = dataAlign;
    }

    public int getWight() {
        return wight;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }
}
