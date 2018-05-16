package Contracts;

public interface HealthManager {
    String checkCondition(String organism);

    String createOrganism(String name);

	String addCluster(String organismName, String id, int rows, int cols);

	String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty);

    String activateCluster(String organismName);
}

