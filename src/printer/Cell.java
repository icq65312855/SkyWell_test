package printer;

public interface Cell {

    boolean next();
    String getValue(String data);
    int getIndex();
    void reset();

}
