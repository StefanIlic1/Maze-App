import java.util.ArrayList;

public abstract class MazeSolver {
    Maze maze;
    Worklist<Squares> worklist;
    
    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Squares sq);

    abstract Squares next();

    abstract Squares remove();

    MazeSolver(Maze maze) {
        this.maze = maze;
    }

    boolean isSolved() {
        // return true if there is a path from the start to the exit found
        // look at the worklist path to see if it is solved

        if (!worklist.isEmpty()) {
            if (worklist.toString().contains("3")) {
                return true;
            }
        }
        return false;
    }

    String getPath() {
        if (isSolved()) {
            return worklist.toString();
        }
        
        return "No path found";
    }

    // change
    void solve() {
        makeEmpty();
        // run step until you get to the exit square or the worklist is empty
        while (!isEmpty() || !isSolved()) {
            Squares sq = step();
        }
    }

    public Squares step(){
        ArrayList<Squares> search;
        search = maze.getNeighbors(next());
        for(int i = search.size() - 1; i >= 0; i--){
            if (search.get(i).previous == null){
                search.remove(i);
            }
            else{
                search.get(i).previous = next();
                add(search.get(i));
            }
        }
       
        return remove();
    }
}
