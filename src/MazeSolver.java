import java.util.ArrayList;

public abstract class MazeSolver {
    Maze maze;
    Squares current;
    //Worklist<Squares> worklist;
    // having a worklist is actually unnecessary
    
    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Squares sq);

    abstract Squares remove();

    abstract Squares next();
    

    MazeSolver(Maze maze) {
        this.maze = maze;
        this.current = this.maze.getStart();
    }

    boolean isSolved() {
        // return true if there is a path from the start to the exit found
        // look at the worklist path to see if it is solved
        if (current.getType() == 3) {
            return true;
        }

        return false;
    }

    /*
     * will be a string representation of the path for the solution
     * this will be created with a stack, as it is not contributing
     * to the solving of the problem.
     */
    String getPath() {
        // the current square should be the last square because you get path after the maze is solved
        MyStack<String> path = new MyStack<String>();
        
        if (this.current.getType() == 3) {
            path.push("[" + this.current.getRow() + "," + this.current.getColumn() + "]");
            while (this.current.getType() != 2) {
                this.current = this.current.getPrev();
                path.push("[" + this.current.getRow() + "," + this.current.getColumn() + "]");
            }
        } else {
            return "NO SOLUTION";
        }

        String finalpath = "";
        while (!path.isEmpty()) {
            finalpath += (path.pop() + " , ");
        }
        // eliminates the final comma
        finalpath = finalpath.substring(0,finalpath.length()-1);
        return finalpath;
    }

    // change
    void solve() {
        while(!this.isSolved()) {
            this.step();
        }
        if(this.current.getType() == 3)
        {
            System.out.print(this.getPath());
        }
        else if(this.isEmpty()){
            System.out.print("NO SOLUTION");
        }
    }

    public Squares step(){
        ArrayList<Squares> search;
        Squares next = next();
        next.setWorking();
        search = maze.getNeighbors(next);
        for(int i = search.size() - 1; i >= 0; i--){
            if (search.get(i).previous == null){
                search.remove(i);
            }
            else{
                search.get(i).previous = next();
                add(search.get(i));
            }
        }
       
        Squares removed = remove();
        removed.setExplored();
        return removed;
    }
}
