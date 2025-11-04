import javax.swing.JFrame;

import javax.swing.SwingUtilities;
public class MainGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("2D Data Plot with Axes");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String pathFile="D:\\Github\\ProgramingLanguae\\Java\\CSC311Proj\\src\\data12.txt";
            // Set a larger size to accommodate padding
            frame.setSize(500, 500); 

            frame.add(new DrawerPanel(pathFile));
            
            frame.setVisible(true);
        });
    }
}