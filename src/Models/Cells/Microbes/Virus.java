package Models.Cells.Microbes;

public class Virus extends Microbe {
    public Virus(String id, int health, int row, int col, int virulence) {
        super(id, health, row, col, virulence);
    }

    @Override
    protected int getEnergy() {
        return this.getHealth() + this.getVirulence();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Energy %d\n",this.getEnergy());
    }
}
