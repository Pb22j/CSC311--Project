import javax.swing.JFrame;

import javax.swing.SwingUtilities;
public class MainGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("2D Data Plot with Axes");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String pathFile="C:\\Users\\User\\CSC311--Project\\data12.txt";
             //Set a larger size to accommodate padding
            frame.setSize(500, 500); 
            DrawerPanel Frame =new DrawerPanel(pathFile);
            frame.add(Frame);
            System.out.println("UpperHullPoints:");
            // Frame.displyValue(Frame.UpperHullBrute);
            Frame.displyValue(Frame.UpperHullQuick);
            System.out.println("____________________________");
            System.out.println("LowerHullPoints:");
            // Frame.displyValue(Frame.LowerHullBrute);
            Frame.displyValue(Frame.LowerHullQuick);
            System.out.println("____________________________");
            System.out.println("ExtremPoints:");
            Frame.displyValue(Frame.ExtremPointBrute);
            frame.setVisible(true);
        });
    }
}