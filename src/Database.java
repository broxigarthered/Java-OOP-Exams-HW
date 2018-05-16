import Models.Cells.Cell;
import Models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Database {
    private List<Cell> cells;
    private List<Cluster> clusters;
    private List<Organism> organisms;

    public Database() {
        this.cells = new ArrayList<Cell>();
        this.clusters = new ArrayList<Cluster>();
        this.organisms = new ArrayList<Organism>();
    }

    public List<Cell> getCells() {
        return Collections.unmodifiableList(this.cells);
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(this.clusters);
    }

    public List<Organism> getOrganisms() {
        return Collections.unmodifiableList(this.organisms);
    }

    public Organism getSignleOrganism(String name){
        return this.organisms.stream()
                .filter(o -> o.getName().equals(name))
                .findFirst()
                .orElse(null);

    }

    public Cluster getSingleCluster(String id){
        return this.clusters
                .stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Cluster getSingleClusterInOrganism(Organism organism, String id){
        return organism.getClusters().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public String addCell(Cell cell, Cluster cluster, Organism organism) {
        cluster.addCell(cell);
        this.cells.add(cell);
        return String.format("Organism %s: Created cell %s in cluster %s\n", organism.getName(), cell
        .getId(), cluster.getId());
    }

    public String addCluster(Organism organism, Cluster cluster) {
        if(!organism.getClusters().contains(cluster)){
            this.clusters.add(cluster);
            organism.addCluster(cluster);
            return String.format("Organism %s: Created cluster %s\n", organism.getName(), cluster.getId());
        }

        return "";
    }

    public void addOrganism(String name) {
        Organism organism = StructureFactory.createOrganism(name);
        this.organisms.add(organism);
    }
}
