package ua.nure.vasilchenko.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {

    public static final  int NUMBER5 = 5;
    /**
     * емкость.
     */
    private int capacity = NUMBER5; // емкость
    /**
     * масиив, стек.
     */
    private Object[] stack;

    /**
     * кол-во элементов в очереди.
     */
    private int size;


    @Override
    public void push(final Object element) {
        if (stack == null) {
            stack = new Object[capacity];
        }
        if (size == stack.length) {
            capacity *= 2;
            Object[] temp = new Object[capacity];
            System.arraycopy(stack, 0, temp, 0, stack.length);
            stack = temp;
        }
        if (size >= 0) {
            System.arraycopy(stack, 0, stack, 1, size);
        }
        stack[0] = element;
        size++;
    }

    @Override
    public Object pop() {
        if (stack.length == 0) {
            return null;
        } else {
            Object buff = stack[0];
            stack[0] = null;
            System.arraycopy(stack, 1, stack, 0, stack.length - 1);
            size--;
            return buff;
        }
    }

    @Override
    public Object top() {
        if (stack == null) {
            return null;
        }
        return stack[0];
    }

    @Override
    public void clear() {
        stack = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder("[");
        for (int i = size - 1; i >= 0; i--) {
            temp.append(stack[i]);
            if (i != 0) {
                temp.append(", ");
            }
        }
        temp.append("]");
        return temp.toString();
    }

    public class IteratorImpl implements Iterator<Object> {

        private int position;

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return stack[position++];
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            int temp = position - 1;
            for (int i = temp; i < size; i++) {
                if (temp == -1) {
                    throw new IllegalStateException();
                }
                stack[temp++] = stack[i + 1];
            }
            position--;
            size--;
        }
    }

    public static void main(final String[] args) {
        Stack stack = new StackImpl();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        Iterator it1 = stack.iterator();
        System.out.println(it1.next());
        it1.remove();
        try {
            it1.remove();
        } catch (IllegalStateException ex) {
            System.out.println("exception");
        }
    }
}
