package Models.Cells;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int row, int col, int size) {
        super(id, health, row, col);
        this.setSize(size);
    }

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        if(size < 0){
            throw new IllegalArgumentException("White blood cell size cannot be less than zero.");
        }
        this.size = size;
    }

    @Override
    protected int getEnergy() {
        return (this.getHealth() + this.getSize())*2;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("--------Health %d | Size %d | Energy %d\n", this.getHealth(),
                this.getSize(),
                this.getEnergy());
    }
}
