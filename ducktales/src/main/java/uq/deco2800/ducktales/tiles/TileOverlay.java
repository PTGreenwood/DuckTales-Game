package uq.deco2800.ducktales.tiles;

/**
 * Because the Image class will render everything as rectangles, detecting mouse events
 * using Image.contains() will not be accurate. Thus this class is created to be used by
 * Tile to store the actual pixels on the screen that the tile is rendered onto.
 *
 * This class holds the coordinates of the top, bottom, left and right corner of
 * the rhombus-shape of a tile
 *
 * Created by Khoi Phan on 22/08/2016.
 *
 * @author khoiphan21
 */
public class TileOverlay {
    /*
     * Name for the four positions and their coordinates
     */
    public static final int TOP = 1;
    public static final int BOTTOM = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;
    public static final int X = 10;
    public static final int Y = 11;

    /*
     * The coordinates of this tile
     */
    private Coordinate top;
    private Coordinate bottom;
    private Coordinate left;
    private Coordinate right;

    /**
     * This constructor will automatically calculate the four points representing
     * the four corners of the Polygon to be drawn for the tile overlay
     * @param x
     *          x-coordinate of the top left corner of the rendered rectangle
     *          of the actual tile image
     * @param y
     *          y-coordinate of the same top left corner
     * @param width
     *          The width of the actual tile
     * @param height
     *          The height of the actual tile
     */
    public TileOverlay(int x, int y, int width, int height ) {
        this.updateCoordinates(x, y, width, height);
    }

    public double getCoordinate(int position, int coordinate) {
        switch(position) {
            case TOP:
                return this.top.getCoordinate(coordinate);
            case BOTTOM:
                return this.bottom.getCoordinate(coordinate);
            case LEFT:
                return this.left.getCoordinate(coordinate);
            case RIGHT:
                return this.right.getCoordinate(coordinate);
            default:
                return 0;
        }
    }

    /**
     * Update the coordinates of the overlay to match with the new coordinates of the tile
     * @param x
     *          x-coordinate of the top left corner of the rendered rectangle
     *          of the actual tile image
     * @param y
     *          y-coordinate of the same top left corner
     * @param width
     *          The width of the actual tile
     * @param height
     *          The height of the actual tile
     */
    public void updateCoordinates(int x, int y, int width, int height) {
        this.top = new Coordinate(x + width/2, y);
        this.bottom = new Coordinate(x + width/2, y + height);
        this.left = new Coordinate(x, y + height/2);
        this.right = new Coordinate(x + width, y + height/2);
    }

    /**
     * The class used to store the coordinates for each tile whenever rendering each tile
     * The purpose of this class is to make rendering the tiles more understandable
     */
    private class Coordinate {
        private double x;
        private double y;

        public Coordinate(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getCoordinate(int coordinate) {
            switch(coordinate) {
                case X:
                    return this.x;
                case Y:
                    return this.y;
                default:
                    return 0;
            }
        }
    }
}
