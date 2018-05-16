package Models;
//
//public class StructureFactory {
//    private static final StructureFactory instance = new StructureFactory();
//
//    private StructureFactory(){}
//
//    public static StructureFactory getInstance(){
//        return instance;
//    }
//
//}

import Models.Cells.Cell;
import Models.Cells.Microbes.Bacteria;
import Models.Cells.Microbes.Fungi;
import Models.Cells.Microbes.Virus;
import Models.Cells.RedBloodCell;
import Models.Cells.WhiteBloodCell;
import Models.Organism;

public final class StructureFactory{
    public static Organism createOrganism(String name){
        return new Organism(name);
    }

    public static Cluster createCluster(String id, int rows, int cols) {
        return new Cluster(id, rows, cols);
    }

    public static Cell createCell(String cellType, String cellId, int health, int row, int col, int additionalProperty){
        Cell cell = null;

        switch (cellType){
            case "WhiteBloodCell":
                cell = new WhiteBloodCell(cellId, health, row, col, additionalProperty);
                break;
            case "RedBloodCell":
                cell = new RedBloodCell(cellId, health, row, col, additionalProperty);
                break;
            case "Bacteria":
                cell = new Bacteria(cellId, health, row, col, additionalProperty);
                break;
            case "Virus":
                cell = new Virus(cellId, health, row, col, additionalProperty);
                break;
            case "Fungi":
                cell = new Fungi(cellId, health, row, col, additionalProperty);
                break;
        }

        return cell;
    }
}
