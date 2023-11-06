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

    public boolean isEmpty(){
        return worklist.isEmpty();
    }

    public void add(Squares sq){
        worklist.enqueue(sq);
    }

    public Squares remove(){
        return worklist.dequeue();
    }

    public Squares next(){
        return worklist.front();
    }
}
