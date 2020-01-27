package ua.nure.vasilchenko.practice2;

public interface Queue extends Container {


    /**
     * @param element Appends the specified element to the end
     */
    void enqueue(Object element);


    /**
     * @return Removes the head.
     */
    Object dequeue();


    /**
     * @return Returns the head.
     */
    Object top();

}
