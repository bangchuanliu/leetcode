package common;

public class Cell {

    private Integer x;
    private Integer y;

    public Cell(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public static Cell of(Integer x, Integer y) {
        return new Cell(x, y);
    }
}
