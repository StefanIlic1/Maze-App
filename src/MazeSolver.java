public abstract class MazeSolver {
    Maze maze;
    boolean solved;
    
    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Squares sq);

    abstract Squares next();

    MazeSolver(Maze maze) {
        this.maze = maze;
    }

    boolean isSolved() { return solved; }

    String getPath() { return "Maze not solved"; }

    Squares step() { return null; }

    void solve() {}
}
