import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws Exception {
        File file = new File("./input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        int safeReports = 0;
        ArrayList<ArrayList<Integer>> reportArray = new ArrayList<>();

        while ( (line = br.readLine()) != null ) {
            String[] parts = line.split("\\s+");
            ArrayList<Integer> reports = new ArrayList<>();
            
            for (int i=0; i<parts.length; i++) {
                reports.add(Integer.parseInt(parts[i]));
            }
            reportArray.add(reports);
        }

        for (int i=0; i<reportArray.size(); i++) {
            boolean completed = true;
            Integer previousDifference = null;

            for (int j=0; j<reportArray.get(i).size() - 1; j++) {
                int difference = reportArray.get(i).get(j) - reportArray.get(i).get(j+1);

                if (Math.abs(difference) < 1 || Math.abs(difference) > 3) {
                    completed = false;
                    break;
                }

                if (previousDifference != null) {
                    if (!((difference > 0 && previousDifference > 0) || (difference < 0 && previousDifference < 0))) {
                        completed = false;
                        break;
                    }
                }

                previousDifference = difference;
            }
            if (completed) {
                safeReports++;
            }
        }
        System.out.println("Safe Reports: " + safeReports);
    }   
}