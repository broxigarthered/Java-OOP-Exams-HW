package Models;

import Models.Cells.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cluster {
    private String id;
    private String organism;
    private int rows, cellBiggestRow, cellBiggestCol;
    private int cols;
    private List<Cell> cells;
    private Cell[][] matrix;


    public Cluster(String id, int rows, int cols) {
        this.setId(id);
        this.setRows(rows);
        this.setCols(cols);
        this.cells = new ArrayList<Cell>();
        this.cellBiggestRow = 0;
        this.cellBiggestCol = 0;
    }

    public String getId() {
        return id;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public List<Cell> getCells() {
        return Collections.unmodifiableList(this.cells);
    }

    private void setId(String id) {
        if (id == null || id.isEmpty()){
            throw new IllegalArgumentException("Id cannot be null or empty.");
        }
        this.id = id;
    }

    private void setRows(int rows) {
        if (rows < 0){
            throw new IllegalArgumentException("Row cannot be less than zero");
        }
        this.rows = rows;
    }

    private void setCols(int cols) {
        if (cols < 0){
            throw new IllegalArgumentException("Col cannot be less than zero");
        }
        this.cols = cols;
    }

    public boolean checkCellPosition(Cell cell){

        return cell.getRow() >= 0 &&
                cell.getRow() <= this.getRows() &&
                cell.getCol() >= 0 &&
                cell.getCol() <= this.getCols();
    }

    public void addCell(Cell cell) {
        if(this.cellBiggestRow < cell.getRow()){
            this.cellBiggestRow = cell.getRow();
        }
        if(this.cellBiggestCol < cell.getCol()){
            this.cellBiggestCol = cell.getCol();
        }
        this.cells.add(cell);
        matrix[cell.getRow()][cell.getCol()] = cell;
    }

    private String getCellsToString(){
        StringBuilder builder = new StringBuilder();
        for (Cell cell : this.getCells()) {
            builder.append(cell.toString());
        }
        return builder.toString();
    }

    public void activateCluster(){
        // create matrix with ones
        for (int row = 0; row < matrix.length; row++) {
//            Cell[] matrix1 = matrix[i];
            for (int col = 0; col < matrix[row].length; col++) {
                Cell cell = matrix[row][col];
                // check every if null it means there is no cell at that position
                // get fist occured cell and meet it with the next one
                // run the loop while
                // while cell.getRow < cell.bestRow && cell.getCol < cell.bestCol
               if(cell != null) {
                   while (cell.getRow() <= this.cellBiggestRow && cell.getCol() <= this.cellBiggestCol) {

                   if (cell.getCol() >= matrix[row].length) {
                       if (!(cell.getRow() >= matrix.length)) {
                           cell.setRow(cell.getRow() + 1);
                       }
                   } else {
                       cell.setCol(cell.getCol() + 1);
                   }

                   // if cell.getCol + 1 < matrix[row].length && matrix[row] != null
                       // get the next cell and do the fight
               }
               }
            }
        }

    }

    @Override
    public String toString() {
        // todo sort cells in cluster
        return String.format("----Cluster %s\n", this.getId()) +
                String.format(getCellsToString());
    }
}
