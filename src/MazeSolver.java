import java.util.ArrayList;

public abstract class MazeSolver {
    Maze maze;
    Squares current;
    boolean stepOne = true;
    //Worklist<Squares> worklist;
    // having a worklist is actually unnecessary
    
    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Squares sq);

    //abstract Squares remove();

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
        // if it is at the start, and if it is not currently being worked on already
        if (!current.working() && current.getType()==2) {
            add(current);
            current.startWorking();
        }

        if (this.isEmpty()) {
            return null;
        }

        current = next();

        // if it is the last square, return the last square
        // if not, continue algorithm
        if (current.getType() == 3) {
            current.setSolved();
            return current;
        } else {
            current.explore();

            ArrayList<Squares> neighbors = maze.getNeighbors(current);

            for (int i = neighbors.size() - 1; i >= 0; i--) {
                Squares work = neighbors.get(i);
                if (work.getType() == 0 && !work.working()) {
                    work.setPrev(current);
                    work.startWorking();
                    add(work);
                } else if (work.getType() == 3) {
                    // reached the end
                    work.setPrev(current);
                    current = work;
                    return current;
                    //return work;
                }
            }

            return current;
        }

        
        /*
        
        if (this.isEmpty() && this.stepOne){
            add(current);
            current.previous = new Squares(1000, 1000, 0);
            stepOne = false;
        }
        ArrayList<Squares> search;
        Squares next = next();
        next.setWorking();
        search = maze.getNeighbors(next);
    
        for (int i = search.size() - 1; i >= 0; i--) {
            Squares temp = search.get(i);
            System.out.println(i + ": " + temp.getRow()+ ", " + temp.getColumn());
        }

        for (int i = search.size() - 1; i >= 0; i--) {
            if (search.get(i).getType() == 1) {
                Squares temp = search.remove(i);
                System.out.println("REMOVED BY TYPE: " + temp.getRow()+ ", " + temp.getColumn() + " TYPE: " + temp.getType());
            }
        }

        Squares removed = remove();
        removed.setExplored();
        

        for(int i = search.size() - 1; i >= 0; i--){
            if (!(search.get(i).previous == null)){
                Squares temp = search.remove(i);
                System.out.println("REMOVED BY PREV: " + temp.getRow()+ ", " + temp.getColumn());
            }
            else{
                search.get(i).previous = removed;
                Squares temp = search.get(i);
                System.out.println("CAN SEARCH: " + temp.getRow()+ ", " + temp.getColumn());
                
                add(search.get(i));
            }
        }
       
        System.out.println("SEARCHED: "+removed.getRow()+", "+removed.getColumn());
        this.current = removed;
        return removed;
        */


    }
}
