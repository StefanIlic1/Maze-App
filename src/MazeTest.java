import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class MazeTest{
    public static void main(String[] args){
        Maze test = new Maze();
        if(test.loadMaze("src/maze-2")){
            ArrayList<Squares> holder = test.getNeighbors(test.getStart());
            System.out.println(test.getStart().getType());
            System.out.println(test.getFinish().getType());
            
            System.out.println(test);
            test.reset();
            System.out.println(test);
        }
        
    }
}