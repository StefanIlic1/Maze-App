public abstract class MazeSolver {
    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Squares sq);

    abstract Squares next();

    MazeSolver(Maze maze) {}

    boolean isSolved() { return false; }

    String getPath() { return "Maze not solved"; }

    Squares step() { return null; }

    void solve() {}
}
