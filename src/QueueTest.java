public class QueueTest {
    public static void main(String[] args){
        Queue test = new Queue();
        test.enqueue("Ob 1");
        test.enqueue("Ob 2");
        System.out.println(test);
        System.out.println("Expected: Ob 1, Ob 2\n");
        System.out.println(test.dequeue());
        System.out.println("Expected: Ob 1\n");
        //EVERYTHING BELOW IS FROM STACK
        System.out.println(test);
        System.out.println("Expected: Ob 1\n");
        

        test.enqueue("Ob 3");
        System.out.println(test);
        System.out.println("Expected: Ob 3, Ob 1\n");
        
        System.out.println(test.size());
        System.out.println("Expected: 2\n");
        test.enqueue("Ob 4");

        System.out.println(test.front());
        System.out.println("Expected: Ob 4\n");

        test.enqueue("Ob 5");

        if(test.isEmpty()){
            System.out.println("x");
        }
        else    
        {    
            System.out.println(test.size());
            System.out.println("Expected: 4\n");
        
            test.clear();
            System.out.println(test.size());
            //System.out.println(test);
            System.out.println("Expected: 0\n");
        }
    }
}
