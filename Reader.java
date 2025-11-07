import java.io.*;
import java.util.*;

public class Reader {
    //THIS METHOD SHOULD TAKE THE DATA AND PUT IT ON ARRAY
    //INPUT:PATH FOR THE FILE THAT HAS DATA
    //OUTPUT:A IS ARRAY THAT HAS X,Y IN EACH INDEX FOR EACH VALUE
	// Testa
       public static String [] getData(String path){
        String fileName = path; // The file path
        List<String> points = new ArrayList<>();
        String[] XYList = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            reader.close();

            if (line != null) {
                // Remove spaces
                line = line.replaceAll("\\s+", "");
                String[] pairs = line.split("\\),\\(");

                for (String pair : pairs) {
                    pair = pair.replace("(", "").replace(")", "");
                    points.add(pair); // store as "x,y"
                }
            }

            // Convert to array
            XYList = points.toArray(new String[0]);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return XYList;
    }
}

