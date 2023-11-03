/**
    Add a method lastToFirst to this implementation of a queue.
    The method moves the element at the tail of the queue
    to the head.
*/
public class MyQueue<T> extends Worklist<Squares> implements QueueADT<Squares>
{
    private Node head;
    private Node tail;

    /**
        Constructs an empty queue.
    */
    public MyQueue()
    {
        head = null;
        tail = null;
    }

    /**
        Checks whether this queue is empty.
        @return true if this queue is empty
    */
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
        Adds an element to the tail of this queue.
        @param newElement the element to add
    */
    @Override
    public void enqueue(Squares newElement)
    {
        if (tail == null)    // head must also be null
        {
            Node newNode = new Node();
            newNode.data = newElement;
            newNode.next = null;
            tail = newNode;
            head = newNode;
        }
        else
        {
            Node newNode = new Node();
            newNode.data = newElement;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
        Removes an element from the head of this queue.
        @return the removed element
    */
    public Squares dequeue()
    {
        if (head == null)
            return null;
        Squares element = head.data;
        head = head.next;
        if (head == null)    // queue is empty
        {
            tail = null;
        }
        return element;
    }

    public int size(){
        int count = 0;
        Node current = head;
        if(current.data == null)
            return 0;
        while(current != null){
            current = current.next;
            count++;
        }
        return count;
    }

    public void clear(){
        head.data = null;
        head.next = null;
        tail.data = null;
        tail.next = null;
    }

    public Squares front(){
        return head.data;
    }

    public String toString(){
        String data = "";
        Node current = new Node();
        current = head;

        if(current == null)
            return ("");
        else{
            data += current.data;
            current = current.next;
        }

        while(current != null){
            data += ", " + current.data;
            current = current.next;
        }
        

        return data;
    }

    class Node
    {
        public Squares data;
        public Node next;
    }
}
