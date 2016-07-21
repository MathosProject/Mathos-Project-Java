package mathoscore.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * The base class for creating graphs.
 *
 * @author Artem Los (arteml@kth.se), Mathos Project.
 * @author Ethan Dagner (napen123@gmail.com), Mathos Project
 */
public class Graph extends JPanel {
    public int width;
    public int height;

    public Graph(int width, int height) {
        this.width = width;
        this.height = height;

        setPreferredSize(new Dimension(width, height));
    }

    public static void graph(Graph graph) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mathos Graph");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(graph);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
