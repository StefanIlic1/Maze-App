import java.util.NoSuchElementException;

/**
 * An implementation of a stack as a sequence of nodes.
*/
public class MyStack<T> implements StackADT<Object>, Worklist<Object>
{
    private MyStack.Node<Object> first;

    /**
     * Constructs an empty stack.
    */
    public MyStack()
    {
        first = null;
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param element the element to add
    */
    public void push(Object element) {
        Node<Object> newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        this.first = newNode;
    }





    /**
        Removes the element from the top of the stack.
        @return the removed element
    */
    public Object pop(){
        if(!isEmpty()){
            Object popped = this.first.data;
            this.first = this.first.next;
            return popped;
        }
        else
            throw new NoSuchElementException();

        
    }



    /**
     * Checks the top element
     * 
     * @return the first element of the stack
     */
    public Object top(){
        if(isEmpty())
            throw new NoSuchElementException();
        return first.data;
    }



    /**
     * Checks whether this stack is empty.
     *
     * @return true if the stack is empty
    */
    public boolean isEmpty(){
        return (this.first == null);
    }

    /**
     * Returns the stacks size
     * 
     * @return size
     */
    public int size(){
        Node check = first;
        int size = 0;
        //System.out.println("Check: 1\n");
        while(check != null){
            //System.out.println("Check: 2\n");
            size++;
            check = check.next;
        }
        //System.out.println("Check: 3\n");

        return size;
    }

    public void clear(){
        first.data = null;
        first.next = null;
        first = null;
    }

    public String toString(){
        String data = "";
        Node current = new Node();
        current = first;

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

    static class Node<T>
    {
        public T data;
        public Node next;
    }
}
