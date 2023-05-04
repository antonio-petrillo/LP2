package tree;

import java.util.*;

public interface Tree<K, V> {
    boolean add(K k, V v);

    boolean remove(K k);

    V get(K k);

    boolean contains(K k);

    int size();

    Iterator<T> inOrder();

    Iterator<T> preOrder();

    Iterator<T> postOrder();

    Iterator<T> breadthOrder();
}
