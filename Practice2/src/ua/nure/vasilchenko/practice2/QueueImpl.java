package ua.nure.vasilchenko.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {
    /**
     * constant 5.
     */
    public static final int NUMBER = 5;
    /**
     * емкость.
     */
    private int capacity = NUMBER; // емкость
    /**
     * масиив, очередь.
     */
    private Object[] queue;

    /**
     * кол-во элементов в очереди.
     */
    private int size;


    /**
     * конструктор по умолчанию.
     */
    public  QueueImpl() {
        queue = new Object[capacity];
    }


    @Override
    public void enqueue(final Object element) {
        if (queue == null) {
           queue = new Object[capacity];
        }
        if (size == queue.length) {
            capacity *= 2;
            Object[] temp = new Object[capacity];
            System.arraycopy(queue, 0, temp, 0, queue.length);
            queue = temp;
        }
        queue[size] = element;
        size++;
    }

    @Override
    public Object dequeue() {
        if (queue.length == 0) {
            return null;
        } else {
        Object buff = queue[0];
        queue[0] = null;
            System.arraycopy(queue, 1, queue, 0, queue.length - 1);
        size--;
        return buff;
        }
    }

    @Override
    public Object top() {
        if (queue == null) {
            return null;
        }
        return queue[0];
    }

    @Override
    public void clear() {
        queue = null;
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
        for (int i = 0; i < size; i++) {
            temp.append(queue[i]);
            if (i != size - 1) {
                temp.append(", ");
            }
        }
        temp.append("]");
        return temp.toString();
    }

    //класс итератор
    public class IteratorImpl implements Iterator<Object> {

        private int position;

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return queue[position++];
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
                    queue[temp++] = queue[i + 1];
            }
            position--;
            size--;
        }
    }

    public static void main(final String[] args) {
        Queue queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.top());
        System.out.println(queue.dequeue());
        System.out.println(queue);
        queue.clear();
        System.out.println(queue.size());
        System.out.println(queue);
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println(queue.toString());
        Iterator it = queue.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.println();
        it =  queue.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.println();
        it = queue.iterator();
        System.out.println(it.next());
        it.remove();
        System.out.println(it.next());
        it.remove();
        System.out.println(it.next());
        it.remove();
        System.out.println(queue);
    }
}
