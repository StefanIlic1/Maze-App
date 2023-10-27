import java.io.*;
import java.util.*;


public class Maze {
    private Square[][] maze;

    public Maze() {}

    /*
     * Loads a maze from a file. Returns true if successful, false if not.
     * @param fname The name of the file to load the maze from.
     */
    public boolean loadMaze(String fname) {
        // skeleton code
        return true;
    }

    /*
     * return an ArrayList of the Square neighbors of the parameter Square sq. 
     * There will be at most four of these (to the North, East, South, and West) 
     * and you should list them in that order. If the square is on a border, skip 
     * over directions that are out of bounds of the maze. Don't be adding in null values.
     */
    public ArrayList<Square> getNeighbors(Square sq) {
        // skeleton code
        return null;
    }

    /*
     * getter method for the remembered start square
     * @return the remembered start square
     */
    public Square getStart() {
        return null;
    }

    /*
     * getter method for the remembered finish square
     * @return the remembered finish square
     */
    public Square getFinish() {
        return null;
    }

    /*
     * Return the maze back to the initial state after loading. Erase any marking on 
     * squares (e.g., visited or worklist) but keep the layout. One way you might do 
     * this is by giving each Square a reset() method too, and then just loop through
     * the squares and asking them to reset themselves.
     */
    public void reset() {}


    /*
     * string representation of the maze 
     */
    public String toString() {
        return "";
    }

    /*
    public boolean loadMaze(String fname) {
        try {
            Scanner s = new Scanner(new File(fname));
            
            while (s.hasNext()) {
                String line = s.nextLine();
                String[] tokens = line.split(" ");
                int row = Integer.parseInt(tokens[0]);
                int col = Integer.parseInt(tokens[1]);
                int type = Integer.parseInt(tokens[2]);
                //maze[row][col] = new Square(row, col, type);
            }
            
            
            
            return false;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return false;
        }
    }
    */
}
