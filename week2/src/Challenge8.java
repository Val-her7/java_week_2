import java.util.ArrayList;
import java.util.List;

public class Challenge8 {
    public static class OwnStack<T> {
        List<T> stack;

        public OwnStack(){
            this.stack = new ArrayList<>();
        }

        public List<T> pop() {
            List<T> newStack = new ArrayList<>();
            for (Integer i = 0; i < stack.size() - 1; i++) {
                newStack.add(stack.get(i));
            }
            stack = newStack;
            return stack;
        }

        public List<T> add(T newElement){
            stack.add(newElement);
            return stack;
        }

    }
    public static void main(String[] args) throws Exception {
        OwnStack<Integer> myStack = new OwnStack<>();
        System.out.println(myStack.add(3));
        System.out.println(myStack.add(7));
        System.out.println(myStack.add(2));
        System.out.println(myStack.add(1));
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}