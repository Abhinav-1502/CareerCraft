package MyCollections;

public interface AppTree<T> {
	 /**
     * Inserts a new node containing the specified data into the tree.
     *
     * @param data the data to be inserted into the tree
     */
    public void insert(T data);

    /**
     * Searches for a node containing the specified data in the tree.
     *
     * @param data the data to search for in the tree
     * @return true if the data is found in the tree, false otherwise
     */
    public boolean search(T data);

    /**
     * Deletes the node containing the specified data from the tree.
     *
     * @param data the data to be deleted from the tree
     */
    public void delete(T data);

    /**
     * Traverses the tree and prints or processes each node.
     */
    public void traverse();
}
