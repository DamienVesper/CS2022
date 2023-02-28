import org.code.neighborhood.*;

/**
 * The painter class for the Asphalt Art Project.
 */
public class AsphaltPainter extends Painter {
    int[][] data;

    /**
     * Instantiate the painter.
     * @param data The input legend for painting the grid.
     */
    public AsphaltPainter (int[][] data) {
        super();

        this.data = data;
        this.setPaint((data.length * data.length) + 4);
    }

    /**
     * Paint the entire board with the mapart.
     */
    public void paintBoard () {
        // Calibrate the painter.
        this.calibrate();

        // Paint each tile on the grid.
        this.paintGrid();

        // Repaint every corner so that they are full squares.
        this.paintCorners();
    }

    /**
     * Paint the entire grid with the mapart.
     */
    public void paintGrid () {
        // Calibrate the painter.
        this.calibrate();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                this.paintTile(data[i][this.isFacingEast() ? j : (data.length - 1) - j]);
                this.moveOnGrid();
            }
        }
    }

    /**
     * Paint each corner of the grid.
     * This is used to prevent the corners from having rounded edges.
     */
    private void paintCorners () {
        // Calibrate the painter.
        this.calibrate();

        // Paint the NW square.
        this.paintTile(data[0][0]);

        // Move to the NE square.
        while (!this.isFacingEast()) this.turnLeft();
        this.moveStraight();

        // Paint the NE square.
        this.paintTile(data[0][data.length - 1]);

        // Move to the SE square.
        while (!this.isFacingSouth()) this.turnLeft();
        this.moveStraight();

        // Paint the SE square.
        this.paintTile(data[data.length - 1][data.length - 1]);

        // Move to the SW square.
        while (!this.isFacingWest()) this.turnLeft();
        this.moveStraight();

        // Paint the SW square.
        this.paintTile(data[data.length - 1][0]);
    }

    /**
     * Turn right.
     */
    public void turnRight () {
        for (int i = 0; i < 3; i++) this.turnLeft();
    }

    /**
     * Move in a straight line to the edge of the map.
     */
    public void moveStraight () {
        while (this.canMove()) this.move();
    }

    /**
     * Move the painter to its designated position on the grid.
     * @param x The x-coordinate to move the painter to.
     * @param y The y-coordinate to move the painter to.
     * @param direction The direction for the painter to face.
     */
    public void pose (int x, int y, String direction) {
        // Calibrate the painter.
        this.calibrate();

        while (!this.isFacingSouth()) this.turnLeft();
        while (this.getY() != y && this.canMove()) this.move();

        while (!this.isFacingEast()) this.turnLeft();
        while (this.getX() != x && this.canMove()) this.move();

        while (this.getDirection() != direction) this.turnLeft();
    }

    /**
     * Calibrate painter position and direction.
     */
    private void calibrate () {
        if (this.getX() == 0 && this.getY() == 0 && this.getDirection() == "east") return;

        while (!this.isFacingNorth()) this.turnLeft();
        this.moveStraight();

        while (!this.isFacingWest()) this.turnLeft();
        this.moveStraight();

        while (!this.isFacingEast()) this.turnLeft();
    }

    /**
     * Paint the tile that the painter is currently sitting on.
     * @param colorID The ID of the color to paint the tile.
     */
    private void paintTile (int colorID) {
        String color;
        switch (colorID) {
            case 0:
                color = "DeepSkyBlue";
                break;
            case 1:
                color = "red";
                break;
            case 2:
                color = "orange";
                break;
            case 3:
                color = "yellow";
                break;
            case 4:
                color = "green";
                break;
            case 5:
                color = "blue";
                break;
            case 6:
                color = "Sienna";
                break;
            case 7:
                color = "silver";
                break;
            case 8:
                color = "FireBrick";
                break;
            case 9:
                color = "PaleGreen";
                break;
            default:
                color = "black";
                break;
        }

        if (this.isOnPaint()) this.scrapePaint();
        this.paint(color);
    }

    /**
     * Move on the grid.
     */
    private void moveOnGrid () {
        if (this.canMove()) {
            this.move();
            return;
        }

        if (this.isFacingEast()) {
            this.turnRight();
            if (this.canMove()) {
                this.move();
                this.turnRight();
            }
        } else if (this.isFacingWest()) {
            this.turnLeft();
            if (this.canMove()) {
                this.move();
                this.turnLeft();
            }
        }
    }
}
