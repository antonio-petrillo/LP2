package tree.avl;

public class AVL<K extends Comparable<? super K>, V> implements Tree<K, V> {

    private Node<K, V> root;
    private int size;

    private static class Node<KK, VV> {
        Node<KK, VV> left;
        Node<KK, VV> right;

        int height;
        KK key;
        VV value;

        Node(KK key, VV value) {
            height = 1;
            this.key = key;
            this.value = value;
        }

        public static int getHeight(Node node) {
            return node == null ? 0 : node.height;
        }
    }

    public AVL() {
        root = null;
        size = 0;
    }

    private Node<K, V> fixupLeft(Node<K, V> root)

    @Override
    public boolean add(K k, V v) {
        int oldSize = size;
        root = insert(root, k, v);
        return oldSize != size;
    }

    public Node<K, V> insert(Node<K, V> root, K k, V v) {
        if (root != null) {
            if (root.key.compareTo(k) < 0) {
                root.right = insert(root.right, k, v);
                root = fixupRight(root);
            } else if (root.key.compareTo(k) > 0) {
                root.left = insert(root.left, k, v);
                root = fixupLeft(root);
            }
        } else {
            root = new Node<>(k, v);
            size++;
        }
        return root;
    }

    private Node<K, V> delete(Node<K, V> root, K k) {
        if (root != null) {
            if (root.key.compareTo(k) < 0) {
                root.right = delete(root.right, k, v);
                root = fixupLeft(root);
            } else if (root.key.compareTo(k) > 0) {
                root.left = delete(root.left, k, v);
                root = fixupRight(root);
            } else {
                root = deleteRoot(root);
                size--;
            }
        }
        return root;
    }

    @Override
    public boolean remove(K k) {
        int oldSize = size;
        root = delete(root, k);
        return oldSize != size;
    }

    private Node<K, V> getNode(K k) {
        Node<K, V> iter = root;
        while (iter != null) {
            if (iter.compareTo(k) > 0) {
                iter = iter.left;
            } else if (iter.compareTo(k) < 0) {
                iter = iter.right;
            } else {
                break;
            }
        }
        return iter;
    }

    @Override
    public V get(K k) {
        Node<K, V> node = getNode(k);
        return node != null ? node.value : null;
    }

    @Override
    public boolean contains(K k) {
        return getNode(k) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> inOrder();

    @Override
    public Iterator<T> preOrder();

    @Override
    public Iterator<T> postOrder();

    @Override
    public Iterator<T> breadthOrder();

}
