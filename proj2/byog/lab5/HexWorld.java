package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    /*
    * Simple class to save the position
     */
    public static class Position {
        int x;
        int y;
        public Position(int posx, int posy) {
            x = posx;
            y = posy;
        }
    }

    /*
    * adds a hexagon of side length a to the given postion in the world
    */
    public static void addHexagon(int s, TETile[][] world, Position p, TETile t) {
        int height = s * 2;
        int[][] hex = new int[height][2];
        createHex(hex, p, s);
        for (int y = p.y; y < p.y + height; y += 1) {
            for (int x = hex[y - p.y][0]; x <= hex[y - p.y][1]; x += 1) {
                world[x][y] = t;
            }
        }
    }

    /*
    * Function that saves the position of the start and stop of the hexagon
     */
    public static void createHex(int[][] hex, Position p, int length) {
        for (int y = 0; y < length * 2; y += 1) {
            if (y < length) {
                hex[y][0] = p.x - y;
                hex[y][1] = p.x + length + y - 1;
            } else {
                hex[y][0] = p.x - (length * 2 - 1 - y);
                hex[y][1] = p.x + length - 1 + (length * 2 - 1 - y);
            }
        }
    }

    public static void main(String args[]) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        Position p = new Position(25, 25);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        addHexagon(6, world, p, Tileset.WALL);
        ter.renderFrame(world);


    }
}
