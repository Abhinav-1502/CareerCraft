package MyCollections;

public class AppBinaryTree<T extends Comparable<T>> implements AppTree<T> {
	private AppTreeNode<T> root;

    public AppBinaryTree() {
        this.root = null;
    }

    @Override
    public void insert(T data) {
        root = insertRecursive(root, data);
    }

    private AppTreeNode<T> insertRecursive(AppTreeNode<T> root, T data) {
        if (root == null) {
            return new AppTreeNode<>(data);
        }
        if (data.compareTo(root.data) < 0) {
            root.left = insertRecursive(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRecursive(root.right, data);
        }
        return root;
    }

    @Override
    public boolean search(T data) {
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(AppTreeNode<T> root, T data) {
        if (root == null) {
            return false;
        }
        if (data.compareTo(root.data) == 0) {
            return true;
        } else if (data.compareTo(root.data) < 0) {
            return searchRecursive(root.left, data);
        } else {
            return searchRecursive(root.right, data);
        }
    }
    
    @Override
    public void delete(T data) {
        root = deleteRecursive(root, data);
    }

    private AppTreeNode<T> deleteRecursive(AppTreeNode<T> root, T data) {
        if (root == null) {
            return null;
        }
        if (data.compareTo(root.data) < 0) {
            root.left = deleteRecursive(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = deleteRecursive(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleteRecursive(root.right, root.data);
        }
        return root;
    }

    private T minValue(AppTreeNode<T> node) {
        T minv = node.data;
        while (node.left != null) {
            minv = node.left.data;
            node = node.left;
        }
        return minv;
    }

    @Override
    public void traverse() {
        inorderTraversal(root);
    }

    private void inorderTraversal(AppTreeNode<T> node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }
}
