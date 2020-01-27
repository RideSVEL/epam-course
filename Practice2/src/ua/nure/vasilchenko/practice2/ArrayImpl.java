package ua.nure.vasilchenko.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {

    public static final int NUMBER5 = 5;
    /**
     * емкость.
     */
    private int capacity = NUMBER5; // емкость
    /**
     * масиив, очередь.
     */
    private Object[] array;

    /**
     * кол-во элементов в очереди.
     */
    private int size;


    @Override
    public void add(final Object element) {
        if (array == null) {
            array = new Object[capacity];
        }
        checkSize();
        array[size] = element;
        size++;
    }

    private void checkSize() {
        if (size == array.length) {
            capacity *= 2;
            Object[] temp = new Object[capacity];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
        }
    }

    @Override
    public void set(final int index, final Object element) {
        if (size < index) {
            return;
        }
        checkSize();
        array[index] = element;

    }

    @Override
    public Object get(final int index) {
     if (index >= size || array == null){
            throw new NoSuchElementException();
        }
        return array[index];
    }

    @Override
    public int indexOf(final Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                return i;
            }
        }
       return -1;
    }

    @Override
    public void remove(final int index) {
        if (index >= size) {
            return;
        }
        if (size - index >= 0) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        size--;
    }

    @Override
    public void clear() {
        array = null;
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
            temp.append(array[i]);
            if (i != size - 1) {
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
                return array[position++];
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
                array[temp++] = array[i + 1];
            }
            position--;
            size--;
        }
    }

    public static void main(final String[] args) {
        Array array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");
        System.out.println(array);
        System.out.println(array.size());
        array.set(2, "D");
        System.out.println(array);
        System.out.println(array.size());
        System.out.println(array.get(2));
        System.out.println(array.indexOf("C"));
        array.remove(0);
        System.out.println(array);
        array.clear();
        System.out.println(array.size());
        System.out.println(array);
        array.add("A");
        array.add("B");
        array.add("C");
        System.out.println(array.toString());
        Iterator it = array.iterator();

        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.println();
        it =  array.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.println();
        Iterator it1 = array.iterator();
        System.out.println(it1.next());
        it1.remove();
        System.out.println(it1.next());
        it1.remove();
        System.out.println(array);


    }
}
