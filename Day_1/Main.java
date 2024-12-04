import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("./input.txt");

        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            String line;

            ArrayList<Integer> firstColumn = new ArrayList<>();
            ArrayList<Integer> secondColumn = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");


                firstColumn.add(Integer.parseInt(parts[0]));
                secondColumn.add(Integer.parseInt(parts[1]));
            }
            Collections.sort(firstColumn);
            Collections.sort(secondColumn);
            
            int sum = 0;

            for (int i = 0; i < firstColumn.size(); i++) {
                int subtraction = firstColumn.get(i) - secondColumn.get(i);

                if (subtraction < 0) {
                    subtraction = subtraction * -1;
                }

                sum += subtraction;
            }

            System.out.println("Sum: " + sum);
            br.close();
        } else {
            System.out.println("File not found");
        }
    }
}