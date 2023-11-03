public abstract class Worklist<T> {
    abstract void clear();
    abstract boolean isEmpty();
    abstract int size();

    void push(Object element) {}
    Object pop() { return null; }
    Object top() { return null; }
    void enqueue(Squares element) {}
    Squares dequeue() { return null; }
    Squares front() { return null; }

}
