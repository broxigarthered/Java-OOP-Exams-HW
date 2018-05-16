import Models.Organism;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Database db = new Database();
        HealthManager manager = new HealthManager(db);
        List<Organism> organisms = new ArrayList<Organism>();

        try{
            String line = input.nextLine();
            while (!line.equals("BEER IS COMING")){
                String output = commandParser(line, manager);
                if(output.equals("")){
                    line = input.nextLine();
                    continue;
                }
                System.out.print(output);
                line = input.nextLine();
            }

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static String commandParser(String input, HealthManager manager){
        String[] commandParams = input.split(" ");
        String organismName = "";
        switch (commandParams[0]){
            case "createOrganism":
                organismName = commandParams[1];
                return manager.createOrganism(organismName);
            case "checkCondition":
                organismName = commandParams[1];
                return manager.checkCondition(organismName);
            case "addCell":
                //•	addCell {ОrganismName} {ClusterId} {CellTYpe} {CellId} {health} {positionRow} {positionCol} {additionalProperty}
                organismName = commandParams[1];
                String clusterID = commandParams[2];
                String cellType = commandParams[3];
                String cellID = commandParams[4];
                int health = Integer.parseInt(commandParams[5]);
                int positionRow = Integer.parseInt(commandParams[6]);
                int positionCol = Integer.parseInt(commandParams[7]);
                int additionalProperty = Integer.parseInt(commandParams[8]);

                if((organismName == null || organismName.isEmpty() || (clusterID == null || clusterID.isEmpty()))){
                    break;
                }

                return manager.addCell(organismName,clusterID, cellType, cellID, health, positionRow, positionCol,
                        additionalProperty);
            case "addCluster":
                //•	addCluster {organismName} {id} {int rows} {int cols}
                organismName = commandParams[1];
                String id = commandParams[2];
                int rows = Integer.parseInt(commandParams[3]);
                int cols = Integer.parseInt(commandParams[4]);

                return manager.addCluster(organismName, id, rows, cols);
            case "activateCluster":
                return manager.activateCluster(commandParams[1]);
        }
        return "";
    }
}

/*
createOrganism Troli
createOrganism Troli
addCluster Trr X05 2 3
addCell Trr X05 WhiteBloodCell WBC 5 0 0 5
checkCondition Troli
addCluster Troli X05 2 3
addCell Troli X05 WhiteBloodCell WBC 5 0 0 5
checkCondition Troli
BEER IS COMING
 */