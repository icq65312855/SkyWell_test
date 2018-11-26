package printer;

public interface Column {

    void setHeaderAlign(int headerAlign);
    void setDataAlign(int dataAlign);
    void setWight(int wight);
    int getHeaderAlign();
    int getDataAlign();
    int getWight();

}
