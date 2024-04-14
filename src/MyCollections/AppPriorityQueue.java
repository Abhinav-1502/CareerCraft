package MyCollections;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class AppPriorityQueue<T extends Comparable<? super T>> implements MyQueue<T> {
	private static final int DEFAULT_CAPACITY = 15;
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public AppPriorityQueue() {
        array = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        if (size == array.length) {
            resize();
        }
        array[size++] = item;
        bubbleUp(size - 1);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T item = peek();
        swap(0, size - 1);
        array[--size] = null;
        bubbleDown(0);
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return array[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Resize the array when it's full
    private void resize() {
        int newSize = array.length * 2;
        T[] newArray = (T[]) new Comparable[newSize];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    // Move the item up to maintain the heap property
    private void bubbleUp(int index) {
        while (index > 0 && array[parent(index)].compareTo(array[index]) < 0) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    // Move the item down to maintain the heap property
    private void bubbleDown(int index) {
        while (leftChild(index) < size) {
            int maxIndex = leftChild(index);
            int rightChild = rightChild(index);
            if (rightChild < size && array[rightChild].compareTo(array[maxIndex]) > 0) {
                maxIndex = rightChild;
            }
            if (array[index].compareTo(array[maxIndex]) >= 0) {
                break;
            }
            swap(index, maxIndex);
            index = maxIndex;
        }
    }

    // Swap two items in the array
    private void swap(int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Get the parent index of a given index
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Get the left child index of a given index
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Get the right child index of a given index
    private int rightChild(int index) {
        return 2 * index + 2;
    }
    
    /**
     * Returns an array containing all of the elements in this priority queue.
     * The elements are returned in ascending order.
     *
     * @return an array containing all of the elements in this priority queue
     */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Comparable[size];
        System.arraycopy(array, 0, result, 0, size);
        Arrays.sort(result); // Sort the array to ensure ascending order
        return result;
    }
}
