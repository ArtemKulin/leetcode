package implement_queue_using_stacks;

import java.util.Stack;

class MyQueue {
    private final Stack<Integer> original;

    public MyQueue() {
       original = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> temp = new Stack<Integer>();
        while(!original.empty()){
            temp.push(original.pop());
        }
        original.push(x);
        while(!temp.empty()){
            original.push(temp.pop());
        }
    }

    public int pop() {
        return original.pop();
    }

    public int peek() {
        return original.peek();
    }

    public boolean empty() {
        return original.empty();
    }
}