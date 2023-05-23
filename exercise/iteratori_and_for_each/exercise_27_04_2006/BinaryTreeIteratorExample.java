import java.util.Iterator;
import java.util.LinkedList;

public class BinaryTreeIteratorExample {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> leaf1 = new BinaryTreeNode<>(1, null, null);
        BinaryTreeNode<Integer> leaf2 = new BinaryTreeNode<>(3, null, null);
        BinaryTreeNode<Integer> leaf3 = new BinaryTreeNode<>(5, null, null);
        BinaryTreeNode<Integer> leaf4 = new BinaryTreeNode<>(7, null, null);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2, leaf1, leaf2);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(6, leaf3, leaf4);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4, node1, node2);

        Iterator<BinaryTreeNode<Integer>> iter = root.preIter();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}

class BinaryTreeNode<T extends Number> {

    private BinaryTreeNode<T> left, right;
    private T root;

    public BinaryTreeNode(T root, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "value := " + root.toString();
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public Iterator<BinaryTreeNode<T>> preIter() {
        return new BinaryPreIterator(this);
    }

    private class BinaryPreIterator implements Iterator<BinaryTreeNode<T>> {
        private LinkedList<BinaryTreeNode<T>> toVisit = new LinkedList<>();

        public BinaryPreIterator(BinaryTreeNode<T> t) {
            toVisit.addFirst(t);
        }

        @Override
        public boolean hasNext() {
            return !toVisit.isEmpty();
        }

        @Override
        public BinaryTreeNode<T> next() {
            BinaryTreeNode<T> t = toVisit.removeFirst();
            if (t.right != null) {
                toVisit.addFirst(t.right);
            }
            if (t.left != null) {
                toVisit.addFirst(t.left);
            }
            return t;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}
