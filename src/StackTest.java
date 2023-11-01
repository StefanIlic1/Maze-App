public class StackTest {
    public static void main(String[] args){
        MyStack test = new MyStack();
        test.push("Ob 1");
        test.push("Ob 2");
        System.out.println(test);
        System.out.println("Expected: Ob 2, Ob 1\n");
        System.out.println(test.pop());
        System.out.println("Expected: Ob 2\n");
        
        System.out.println(test);
        System.out.println("Expected: Ob 1\n");
        

        test.push("Ob 3");
        System.out.println(test);
        System.out.println("Expected: Ob 3, Ob 1\n");
        
        System.out.println(test.size());
        System.out.println("Expected: 2\n");
        test.push("Ob 4");

        System.out.println(test.top());
        System.out.println("Expected: Ob 4\n");

        test.push("Ob 5");

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
