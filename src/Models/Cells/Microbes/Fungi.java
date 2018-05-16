package Models.Cells.Microbes;

public class Fungi extends Microbe {
    public Fungi(String id, int health, int row, int col, int virulence) {
        super(id, health, row, col, virulence);
    }

    @Override
    protected int getEnergy() {
        return (this.getHealth() + this.getVirulence())/4;
    }

    public String toString() {
        return super.toString() + String.format(" | Energy %d\n",this.getEnergy());
    }
}
