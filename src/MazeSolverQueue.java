//import java.util.ArrayList;

public class MazeSolverQueue extends MazeSolver {
    MyQueue<Squares> worklist;
    
    public MazeSolverQueue(Maze maze){
        super(maze);
        this.worklist = new MyQueue<Squares>();
    }

    public void makeEmpty(){
        //worklist = new MyQueue<Squares>();
        worklist.clear();  
    }

    @Override
    public boolean isEmpty(){
        return worklist.isEmpty();
    }

    @Override
    public void add(Squares sq){
        worklist.enqueue(sq);
    }

    /*
    @Override
    public Squares remove(){
        return worklist.dequeue();
    }
    */

    @Override
    public Squares next(){
        //return worklist.front();
        return (Squares) worklist.dequeue();
    }
}
