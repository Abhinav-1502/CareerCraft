package MyCollections;

public class AppTreeNode<T> {
	 	T data;
	 	AppTreeNode<T> left;
	 	AppTreeNode<T> right;

	    public AppTreeNode(T data) {
	        this.data = data;
	        this.left = null;
	        this.right = null;
	    }
}
