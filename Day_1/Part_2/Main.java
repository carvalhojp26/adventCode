import java.io.*;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) throws Exception{
        File file = new File("./input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        ArrayList<Integer> firstColumn = new ArrayList<>();
        ArrayList<Integer> secondColumn = new ArrayList<>();

        while( (line = br.readLine()) != null ) {
            String parts[] = line.split("\\s+");

            firstColumn.add(Integer.parseInt(parts[0]));
            secondColumn.add(Integer.parseInt(parts[1]));
        }

        int similarityScore = 0; 
        int timesAppeared = 0;

        for (int i=0; i<firstColumn.size(); i++) {
            for (int j=0; j<secondColumn.size(); j++) {
                if( firstColumn.get(i).equals(secondColumn.get(j)) ) {
                    timesAppeared++;
                }
            }   
            similarityScore += firstColumn.get(i) * timesAppeared;
            timesAppeared = 0;
        }

        System.out.println("Similarity Score: " + similarityScore);
    }
}