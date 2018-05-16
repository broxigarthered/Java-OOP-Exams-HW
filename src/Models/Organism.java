package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Organism {
    private String name;
    private List<Cluster> clusters;

    public Organism(String name) {
        this.setName(name);
        this.clusters = new ArrayList<Cluster>();
    }

    public String getName() {
        return name;
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(this.clusters);
    }

    private void setName(String name) {
        this.name = name;
    }

    public void addCluster(Cluster cluster) {
        this.clusters.add(cluster);
    }

    private String getClustersStrings(){
        //todo sort clusters
        StringBuilder builder = new StringBuilder();
        this.getClusters().forEach(builder::append);

        return builder.toString();
    }

    @Override
    public String toString() {
        int sumOfCell = 0;
        for (Cluster cluster : this.getClusters()) {
            sumOfCell += cluster.getCells().size();
        }
        return String.format("Organism - %s\n", this.getName()) +
                String.format("--Clusters: %d\n", this.getClusters().size()) +
                String.format("--Cells: %d\n", sumOfCell)+
                 this.getClustersStrings();
    }
}
