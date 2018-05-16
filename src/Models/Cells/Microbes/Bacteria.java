package Models.Cells.Microbes;

public class Bacteria extends Microbe {
    public Bacteria(String id, int health, int row, int col, int virulence) {
        super(id, health, row, col, virulence);
    }

    @Override
    protected int getEnergy() {
        return (this.getHealth() + this.getVirulence())/3;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Energy %d\n",this.getEnergy());
    }
}
