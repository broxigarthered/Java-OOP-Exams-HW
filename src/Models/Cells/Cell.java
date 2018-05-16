package Models.Cells;

import java.util.Comparator;

public abstract class Cell implements Comparable {
    private String id;
    private int health;
    private int row;
    private int col;

    public Cell(String id, int health, int row, int col) {
        this.setId(id);
        this.setHealth(health);
        this.setRow(row);
        this.setCol(col);
    }

    public String getId() {
        return id;
    }

    public int getHealth() {
        return health;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    private void setId(String id) {
        if (id == null || id.isEmpty()){
            throw new IllegalArgumentException("Id cannot be null or empty.");
        }
        this.id = id;
    }

    private void setHealth(int health) {
        if (health < 0){
            throw new IllegalArgumentException("Health cannot be less than zero");
        }
        this.health = health;
    }

    public void setRow(int row) {
        if (row < 0){
            throw new IllegalArgumentException("Row cannot be less than zero");
        }
        this.row = row;
    }

    public void setCol(int col) {
        if (col < 0){
            throw new IllegalArgumentException("Col cannot be less than zero");
        }
        this.col = col;
    }

    protected abstract int getEnergy();

    @Override
    public int compareTo(Object o) {
        //Cells should be ordered by positionRow in ascending order, then by positionCol in ascending order
        return Comparator.comparingInt(Cell::getRow)
                .thenComparingInt(Cell::getCol)
                .compare(this, (Cell)(o));
    }

    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]\n", this.getId(),
                this.getRow(), this.getCol());
    }
}
