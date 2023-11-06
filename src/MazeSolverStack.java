import java.util.ArrayList;

public class MazeSolverStack extends MazeSolver {

    MyStack<Squares> worklist;

    public MazeSolverStack(Maze maze) {
        super(maze);
        this.worklist = new MyStack<Squares>();
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
        //return (Squares) worklist.top();
        return (Squares) worklist.pop();
    }

    /* 
    @Override
    public Squares remove() {
        return (Squares) worklist.pop();
    }
    */

    
}
