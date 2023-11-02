import java.util.ArrayList;

public class MazeSolverStack extends MazeSolver {
    private MyStack<Squares> worklist;

    public MazeSolverStack(Maze maze) {
        super(maze);
        // worklist = new MyStack<Squares>();
    }

    @Override
    public void makeEmpty() {
        worklist.clear();
    }

    @Override
    public boolean isEmpty() {
        return worklist.isEmpty();
    }

    @Override
    public void add(Squares sq) {
        worklist.push(sq);
    }

    @Override
    public Squares next() {
        return (Squares) worklist.top();
    }

    @Override
    public Squares step() {
        if (worklist == null) {
            worklist = new MyStack<Squares>();
            worklist.push(maze.getStart());
        }

        if (worklist.isEmpty()) {
            return null;
        }

        Squares current = (Squares) worklist.top();

        if (current == maze.getFinish()) {
            return (Squares) worklist.top();
        }
        
        ArrayList<Squares> neighbors = maze.getNeighbors(current);
        // for each thing in the arraylist if it is visited or if it is a wall
        for (Squares s : neighbors) {
            if (!(s.getType()==1) && !(s.explored())) {
                worklist.push(s);
            }
        }
        
        return null;
    }

    
}
