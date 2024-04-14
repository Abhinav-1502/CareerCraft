package MyCollections;

public interface MyQueue<T> {

    /**
     * Adds an item to the queue.
     * @param item the item to be added to the queue
     */
    public void enqueue(T item);

    /**
     * Removes and returns the item at the front of the queue.
     * @return the item at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue();

    /**
     * Returns the item at the front of the queue without removing it.
     * @return the item at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T peek();

    /**
     * Returns the number of items in the queue.
     * @return the number of items in the queue
     */
    public int size();

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty();
}
