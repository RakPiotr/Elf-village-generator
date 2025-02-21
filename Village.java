import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Village {
    public static void start(int elfCount) {
        // Create the main window (JFrame)
        JFrame frame = new JFrame("Elf Village");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 778); // Adjust the size to fit the grid comfortably

        // Create a GridPanel to draw the grid with houses
        GridPanel gridPanel = new GridPanel(elfCount);
        frame.add(gridPanel);

        // Make the window visible
        frame.setVisible(true);
    }

    static class GridPanel extends JPanel {
        private static final int GRID_SIZE = 50; // Number of rows and columns
        private static final int CELL_SIZE = 15;  // Size of each square in pixels
        private final int elfCount; // Number of houses to display
        private final Random random;

        public GridPanel(int elfCount) {
            this.elfCount = elfCount;
            this.random = new Random();
        }

        @Override
        protected void paintComponent(Graphics g) {
            for (int i = 0; i < elfCount; i++) {
                int x = random.nextInt(GRID_SIZE) * CELL_SIZE;
                int y = random.nextInt(GRID_SIZE) * CELL_SIZE;
                g.drawString("🏠", x + 2, y + CELL_SIZE - 2);
            }
        }
    }
}