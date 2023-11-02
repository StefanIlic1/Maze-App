import java.util.ArrayList;

public class MazeSolverQueue extends MazeSolver {
    MyQueue<Squares> worklist;
    
    public MazeSolverQueue(Maze maze){
        super(maze);
    }

    public void makeEmpty(){
        worklist = new MyQueue<Squares>();
    }

    public boolean isEmpty(){
        return worklist.isEmpty();
    }

    public void add(Squares sq){
        worklist.enqueue(sq);
    }

    public Squares next(){
        return worklist.front();
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
        
        return worklist.dequeue();
    }
}
