import Models.Cells.Cell;
import Models.Cluster;
import Models.Organism;
import Models.StructureFactory;

public class HealthManager implements Contracts.HealthManager {

    private Database dbContext;

    public HealthManager(Database db) {
        this.dbContext = db;
    }

    @Override
    public String checkCondition(String organism) {
        Organism organismObject = this.dbContext.getSignleOrganism(organism);
        return organismObject.toString();
    }

    @Override
    public String createOrganism(String name) {
        Organism organism = dbContext.getSignleOrganism(name);
        if (organism == null){
            dbContext.addOrganism(name);
            return "Created organism " + name + "\n-";
        }
        return String.format("Organism %s already exists\n", name);
    }

    @Override
    public String addCluster(String organismName, String id, int rows, int cols) {
        Organism organism = dbContext.getSignleOrganism(organismName);
        Cluster cluster = StructureFactory.createCluster(id, rows, cols);

        if(organism == null){
            return "";
        }

        if(organism.getClusters().contains(cluster)){
            return "";
        }
        return dbContext.addCluster(organism, cluster);
    }

    @Override
    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        Organism organism = dbContext.getSignleOrganism(organismName);
        if(organism == null){
            return"";
        }
        Cluster cluster = dbContext.getSingleClusterInOrganism(organism, clusterId);
        Cell cell = StructureFactory.createCell(cellType, cellId, health, positionRow, positionCol, additionalProperty);

        if(!cluster.checkCellPosition(cell)){
            return "";
        }

        return dbContext.addCell(cell, cluster, organism);
    }

    @Override
    public String activateCluster(String organismName) {
        return null;
    }
}
