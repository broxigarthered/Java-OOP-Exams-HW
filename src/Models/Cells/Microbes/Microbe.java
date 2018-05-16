package Models.Cells.Microbes;

import Models.Cells.Cell;

public abstract class Microbe extends Cell {
    private int virulence;

    public Microbe(String id, int health, int row, int col, int virulence) {
        super(id, health, row, col);
        this.setVirulence(virulence);
    }

    protected int getVirulence() {
        return virulence;
    }

    private void setVirulence(int virulence) {
        if(virulence < 0){
            throw new IllegalArgumentException("Microbe virulence cannot be less than zero");
        }
        this.virulence = virulence;
    }

    protected abstract int getEnergy();

    @Override
    public String toString() {
        return String.format("--------Health %d | Virulence %d", this.getHealth(), this.getVirulence());
    }
}
