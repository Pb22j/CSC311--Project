import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Point; // Simple class to hold (x, y)
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;


/**
 * A custom JPanel that draws 2D points, a hull, AND axes.
 */
public class DrawerPanel extends JPanel {

    // The 2D data structures (in data coordinates, e.g., 0-1000)
    private List<Point> allPoints;
    private List<Point> hullPoints;

    // Define data range and padding
    private static final int PADDING = 40; // Pixels for axis labels
    private static final int MAX_COORD = 1000; // Max value for X and Y
    public String [] XYList;
    public String [] XYhullpoint;
    public DrawerPanel(String path) {
        
        //THIS LINE WILL CONVERT THE TXT TO AN ARRAY WITH X,Y ONLY LIKE THIS 123,323.4
        XYList= Reader.getData(path);
        allPoints = new ArrayList<>();

        //This One Only For TEST We Should Do it With Some Algorithm
        XYhullpoint= Reader.getData("D:\\Github\\ProgramingLanguae\\Java\\CSC311Proj\\src\\HullPointTest.txt");
        hullPoints = new ArrayList<>();
        AddPoints();
        AddHullPoint(XYhullpoint);
        
    }//END Of METHOD

    public void AddPoints(){        
        //THIS LOOP WILL TAKE EACH ONE X,Y AND PUT IT IN TO THE GRAPGH
        for(int i=0;i<XYList.length;i++){
        String[] parts = XYList[i].split(",");

        // Parse as a double first
        double x = Double.parseDouble(parts[0]);
        double y = Double.parseDouble(parts[1]);
            allPoints.add(new Point((int)x,(int)y));
        }
    }
    public void AddHullPoint(String []XYHullPoint){
        //THIS LOOP WILL TAKE EACH ONE X,Y OF THE HULL POINTS AND PUT IT IN TO THE GRAPGH
        for(int i=0;i<XYHullPoint.length;i++){
        String[] parts = XYHullPoint[i].split(",");

        // Parse as a double first
        double x = Double.parseDouble(parts[0]);
        double y = Double.parseDouble(parts[1]);
            hullPoints.add(new Point((int)x,(int)y));
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);

        // Get the actual size of the drawing area (panel size minus padding)
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        
        int drawingWidth = panelWidth - 2 * PADDING;
        int drawingHeight = panelHeight - 2 * PADDING;

        // --- 1. Draw Axes and Labels (NEW) ---
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new java.awt.BasicStroke(1)); // Thinner line for axes
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));

        // Draw Y-axis line
        g2d.drawLine(PADDING, PADDING, PADDING, panelHeight - PADDING);
        // Draw X-axis line
        g2d.drawLine(PADDING, panelHeight - PADDING, panelWidth - PADDING, panelHeight - PADDING);

        // Draw ticks and labels
        for (int i = 0; i <= MAX_COORD; i += 100) {
            String label = Integer.toString(i);

            // --- Y-axis ticks ---
            // Calculate the panel's Y coordinate (flipping the axis)
            int y = panelHeight - PADDING - (i * drawingHeight / MAX_COORD);
            // Draw tick mark
            g2d.drawLine(PADDING - 5, y, PADDING + 5, y);
            // Draw label (adjusting for font size)
            g2d.drawString(label, PADDING - 30, y + 5);

            // --- X-axis ticks ---
            // Calculate the panel's X coordinate
            int x = PADDING + (i * drawingWidth / MAX_COORD);
            // Draw tick mark
            g2d.drawLine(x, panelHeight - PADDING - 5, x, panelHeight - PADDING + 5);
            // Draw label (adjusting for font size)
            g2d.drawString(label, x - 5, panelHeight - PADDING + 20);
        }


        // --- 2. Draw all the points (MODIFIED to use coordinate transform) ---
        g2d.setColor(Color.BLACK);
        for (Point p : allPoints) {
            // Transform data coordinates (p.x, p.y) to panel coordinates (x, y)
            int x = PADDING + (p.x * drawingWidth / MAX_COORD);
            int y = panelHeight - PADDING - (p.y * drawingHeight / MAX_COORD);
            g2d.fillOval(x - 3, y - 3, 6, 6);
        }

        // --- 3. Draw the hull (MODIFIED to use coordinate transform) ---
        g2d.setColor(Color.RED);
        g2d.setStroke(new java.awt.BasicStroke(2)); // Thicker line for hull

        for (int i = 0; i < hullPoints.size() - 1; i++) {
            Point p1 = hullPoints.get(i);
            Point p2 = hullPoints.get(i + 1);

            // Transform coordinates for p1
            int x1 = PADDING + (p1.x * drawingWidth / MAX_COORD);
            int y1 = panelHeight - PADDING - (p1.y * drawingHeight / MAX_COORD);

            // Transform coordinates for p2
            int x2 = PADDING + (p2.x * drawingWidth / MAX_COORD);
            int y2 = panelHeight - PADDING - (p2.y * drawingHeight / MAX_COORD);

            g2d.drawLine(x1, y1, x2, y2);
        }
    }
}