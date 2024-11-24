import java.util.EmptyStackException;

public class MyStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.toString());
        
        System.out.println(stack.pop()); 
        System.out.println(stack.peek());
        stack.push(4);

        System.out.println(stack.toString());
        System.out.println(stack.pop());
        
        System.out.println(stack.toString());
    }
    public static class Stack<T> {
        private T[] data;
        private int size;

        public Stack(int capacity) {
            data = (T[]) new Object[capacity];
            size = 0;
        }

        public void push(T element) {
            if (size == data.length) {
                throw new IllegalStateException("Stack is full");
            }
            data[size++] = element;
        }

        public T pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            T element = data[--size];
            data[size] = null;
            return element;
        }

        public T peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return data[size - 1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < size; i++) {
                sb.append(data[i]);
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
