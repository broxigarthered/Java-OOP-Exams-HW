package Models.Cells;

public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int row, int col, int velocity) {
        super(id, health, row, col);
        this.setVelocity(velocity);
    }

    public int getVelocity() {
        return velocity;
    }

    private void setVelocity(int velocity) {
        if(velocity < 0){
            throw new IllegalArgumentException("Red blood cell velocity cannot be less than zero.");
        }
        this.velocity = velocity;
    }

    protected int getEnergy(){
        return this.getHealth() + this.getVelocity();
    }

    @Override
    public String toString() {
        return super.toString() + String.format("--------Health %d | Velocity %d | Energy %d\n", this.getHealth(),
                this.getVelocity(), this.getEnergy());
    }
}
