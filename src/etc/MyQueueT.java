package etc;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MyQueueT {


    public static void main(String[] args) {
        MyQueue stack = new MyQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }



    static public class MyQueue {

        private Stack<Integer> input;
        public Stack<Integer> output;

        public MyQueue() {
            this.input = new Stack<>();
            this.output = new Stack<>();
        }

        public void push(int i) {
            this.input.push(i);
        }

        public int pop() {
            if (this.input.isEmpty() && this.output.isEmpty()) throw new NoSuchElementException();

            if (!this.output.isEmpty()) {
                return this.output.pop();
            }

            while (!this.input.isEmpty()) {
                this.output.push(this.input.pop());
            }

            return this.output.pop();
        }


    }

}
