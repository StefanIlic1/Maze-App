import java.io.*;
import java.util.*;


public class Maze {
    private Square[][] maze;
    private Square start, finish;
    private int rows, cols;

    public Maze() {}

    /*
     * Loads a maze from a file. Returns true if successful, false if not.
     * @param fname The name of the file to load the maze from.
     */
    public boolean loadMaze(String fname) {
        try {
            Scanner s = new Scanner(new File(fname));
            
            this.rows = Integer.parseInt(s.next());
            this.cols = Integer.parseInt(s.next());
            s.nextLine(); // consume the newline character

            this.maze = new Square[this.rows][this.cols];

            System.out.println ("rows : " + this.rows + " cols: " + this.cols);
            for (int r = 0; r < this.rows; r++) {
                String line = s.nextLine();
                int mazec = 0;
                for (int c = 0; c < line.length(); c++) {
                    char ch = line.charAt(c);
                    if (ch == ' ') {
                        continue;
                    } else {
                        int type = Character.getNumericValue(ch);
                        this.maze[r][mazec] = new Square(r, mazec, type);
                        if (type == 2) {
                            this.start = this.maze[r][mazec];
                        } else if (type == 3) {
                            this.finish = this.maze[r][mazec];
                        }
                        mazec++;
                    }
                }
            }

            
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return false;
        }
    }

    /*
     * return an ArrayList of the Square neighbors of the parameter Square sq. 
     * There will be at most four of these (to the North, East, South, and West) 
     * and you should list them in that order. If the square is on a border, skip 
     * over directions that are out of bounds of the maze. Don't be adding in null values.
     */
    public ArrayList<Square> getNeighbors(Square sq) {
        ArrayList<Square> neighbors = new ArrayList<Square>();

        // north
        if (sq.getRow() > 0) {
            neighbors.add(this.maze[sq.getRow()-1][sq.getColumn()]);
        }
        // east
        if (sq.getColumn() < this.cols-1) {
            neighbors.add(this.maze[sq.getRow()][sq.getColumn()+1]);
        }

        // south
        if (sq.getRow() < this.rows-1) {
            neighbors.add(this.maze[sq.getRow()+1][sq.getColumn()]);
        }
        
        // west
        if (sq.getColumn() > 0) {
            neighbors.add(this.maze[sq.getRow()][sq.getColumn()-1]);
        }
    
        return neighbors;
    }

    /*
     * getter method for the remembered start square
     * @return the remembered start square
     */
    public Square getStart() {
        return this.start;
    }

    /*
     * getter method for the remembered finish square
     * @return the remembered finish square
     */
    public Square getFinish() {
        return this.finish;
    }

    /*
     * Return the maze back to the initial state after loading. Erase any marking on 
     * squares (e.g., visited or worklist) but keep the layout. One way you might do 
     * this is by giving each Square a reset() method too, and then just loop through
     * the squares and asking them to reset themselves.
     */
    public void reset() {
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                this.maze[r][c].reset();
            }
        }
    }


    /*
     * string representation of the maze 
     * # = walls
     * _ = open squares
     * S = start
     * E = finish
     */
    public String toString() {
        String toReturn = "";

        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                toReturn += this.maze[r][c].toString() + " ";
            }
            toReturn += "\n";
        }  
        
        return toReturn;
    }

}
