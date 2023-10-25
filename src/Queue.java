/**
    Add a method lastToFirst to this implementation of a queue.
    The method moves the element at the tail of the queue
    to the head.
*/
public class Queue implements QueueADT<Object>
{
    private Node head;
    private Node tail;

    /**
        Constructs an empty queue.
    */
    public Queue()
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
    public void enqueue(Object newElement)
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
    public Object dequeue()
    {
        if (head == null)
            return null;
        Object element = head.data;
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

    public Object front(){
        return head.data;
    }

    class Node
    {
        public Object data;
        public Node next;
    }
}
