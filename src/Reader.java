/*

GameHub
Copyright (C) 2026 to:

-Pb22j 
-lFahadr
-Abdulra7hman
-Waleed Alnajashi

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see <https://www.gnu.org/licenses/>.

*/
import java.io.*;
import java.util.*;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Reader {
    
    // --- Original Data Method ---
    public static String[] getData(String path) {
        List<String> points = new ArrayList<>();
        String[] XYList = null;
        try {
            File f = new File(path);
            if (!f.exists()) return new String[0];

            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            reader.close();

            if (line != null) {
                line = line.replaceAll("\\s+", "");
                String[] pairs = line.split("\\),\\(");
                for (String pair : pairs) {
                    pair = pair.replace("(", "").replace(")", "");
                    points.add(pair);
                }
            }
            XYList = points.toArray(new String[0]);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return new String[0];
        }
        return XYList;
    }

    // --- NEW: Image Loader for the Logo ---
    public static ImageIcon getLogo(String path) {
        // Try to load from file system
        File f = new File(path);
        if (f.exists()) {
            return new ImageIcon(path);
        }
        return null; // Return null if not found so GUI handles fallback
    }
}
