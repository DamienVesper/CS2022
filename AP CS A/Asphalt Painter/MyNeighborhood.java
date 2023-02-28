import org.code.neighborhood.*;

/**
 * Entry location for the program.
 */
public class MyNeighborhood {
    public static void main (String[] args) {
        int[][] data = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 8, 8, 8, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 8, 3, 8, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0},
            {0, 0, 8, 8, 8, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 4, 4, 0, 0, 0, 0, 2, 0, 2, 0, 2, 0},
            {9, 9, 9, 0, 0, 4, 0, 0, 0, 0, 2, 2, 2, 2, 2, 0},
            {6, 6, 9, 9, 9, 4, 9, 9, 7, 0, 0, 2, 0, 2, 0, 0},
            {5, 6, 6, 9, 9, 9, 9, 9, 9, 7, 7, 2, 0, 2, 0, 0},
            {5, 5, 6, 6, 9, 9, 9, 9, 9, 9, 7, 7, 0, 2, 0, 0},
            {5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 0},
            {5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7},
            {5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7},
            {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6}
        };

        // Paint the grid.
        AsphaltPainter painter = new AsphaltPainter(data);
        painter.paintBoard();

        // Move the painter to the designated spot on the grid.
        painter.pose(4, 9, "west");

        // Dereference painter.
        painter = null;
    }
}
