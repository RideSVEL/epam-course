package ua.nure.vasilchenko.practice2;

import java.util.Iterator;

public interface Container extends Iterable<Object> {

    /**
     * Removes all of the elements.
     */
    void clear();


    /**
     * @return the number of elements.
     */
    int size();


    /**
     * @return a string representation of this container.
     */
    String toString();


    /**
     * @return an iterator over elements.
     */
    Iterator<Object> iterator();

}
