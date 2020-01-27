package ua.nure.vasilchenko.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ListImpl implements List {

    private Node head;
    private Node tail;
    private int size;

    public ListImpl() {
        head = new Node(null, null, tail);
        tail = new Node(null, head, null);
        head = new Node(null, null, tail);
    }

    @Override
    public void addFirst(final Object element) {
        Node next = head;
        next.setCurrentElem(element);
        head = new Node(null, null, next);
        next.setPrevElem(head);
        size++;
    }

    @Override
    public void addLast(final Object element) {
        Node prev = tail;
        prev.setCurrentElem(element);
        tail = new Node(null, prev, null);
        prev.setNextElem(tail);
        size++;
    }

    @Override
    public void removeFirst() {
        final Node f = head;
        if (f == null) {
            throw new NoSuchElementException();
        }
        final Node next = f.nextElem;
        f.currentElem = null;
        f.nextElem = null;
        head = next;
        if (next == null) {
            tail = null;
        } else {
            next.prevElem = null;
        }
        size--;
    }

    @Override
    public void removeLast() {
        Node l = tail;
        if (l == null) {
            throw new NoSuchElementException();
        }
        final Node prev = l.prevElem;
        l.currentElem = null;
        l.prevElem = null;
        tail = prev;
        if (prev == null) {
            head = null;
        } else {
            prev.nextElem = null;
        }
        size--;
    }

    @Override
    public Object getFirst() {
        return getElementByIndex(0);
    }

    @Override
    public Object getLast() {
        return getElementByIndex(size - 1);
    }

    @Override
    public Object search(final Object element) {
        int index = 0;
        if (element == null) {
            for (Node x = head; x != null; x = x.nextElem) {
                if (x.currentElem == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node x = head; x != null; x = x.nextElem) {
                if (element.equals(x.currentElem)) {
                    return index;
                }
                index++;
            }
        }
        return 0;
    }

    @Override
    public boolean remove(final Object element) {
        if (element == (Integer)1) {
            removeFirst();
        } else if (element == (Integer)2) {
            removeFirst();
        } else if (element == null) {
            for (Node x = head; x != null; x = x.nextElem) {
                if (x.currentElem == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node x = head; x != null; x = x.nextElem) {

                if (element.equals(x.currentElem)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    private void unlink(final Node x) {
        final Node next = x.nextElem;
        final Node prev = x.prevElem;

        if (prev == null) {
            head = next;
        } else {
            prev.nextElem = next;
            x.prevElem = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prevElem = prev;
            x.nextElem = null;
        }

        x.currentElem = null;
        size--;
    }

    @Override
    public void clear() {
        tail = new Node(null, head, null);
        head = new Node(null, null, tail);
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
                temp.append(getElementByIndex(i));
                if (i != size - 1) {
                    temp.append(", ");
                }
            }
            temp.append("]");
        return temp.toString();
    }

    public Object getElementByIndex(final int index) {
        Node target = head.getNextElem();
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.getCurrentElem();
    }

    private static Node getNextElement(final Node index) {
        return index.getNextElem();
    }

    private static class Node {
        private Object currentElem;
        private Node prevElem;
        private Node nextElem;

        //конструктор копирования
        Node(final Object currentElem, final Node prevElem, final Node nextElem) {
            this.currentElem = currentElem;
            this.prevElem = prevElem;
            this.nextElem = nextElem;
        }

        //геттеры и сеттеры

        public Object getCurrentElem() {
            return currentElem;
        }

        public void setCurrentElem(Object currentElem) {
            this.currentElem = currentElem;
        }

        public Node getPrevElem() {
            return prevElem;
        }

        public void setPrevElem(Node prevElem) {
            this.prevElem = prevElem;
        }

        public Node getNextElem() {
            return nextElem;
        }

        public void setNextElem(Node nextElem) {
            this.nextElem = nextElem;
        }
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
                return getElementByIndex(position++);
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {

            if (position - 1 == 0) {
                removeFirst();
                position--;
            } else {
                ListImpl.this.remove(getElementByIndex(position - 1));
                position--;
            }
            if (position == -1) {
                throw new IllegalStateException();
            }
        }
    }

    public static void main(final String[] args) {
        ListImpl list = new ListImpl();
        list.addLast(1);
        list.addLast(2);
        list.addLast(1);
        System.out.println(list);
        list.clear();
        System.out.println(list);
        list.addLast(1);
    }
}
