package bstmap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node leftNode;
        public Node rightNode;
        public Node(K k,V v) {
            key = k;
            value = v;
        }
    }
    private Node root;
    private int size = 0;
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        return containsKey(root, key);
    }

    private boolean containsKey(Node node, K key) {
        if (node == null) {
            return false;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return containsKey(node.leftNode, key);
        } else if (cmp > 0){
            return containsKey(node.rightNode, key);
        }
        return true;
    }
    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.leftNode, key);
        } else if (cmp > 0) {
            return get(node.rightNode, key);
        }
        return node.value;
    }

    @Override
    public int size() {
        return this.size;
    }


    @Override
    public void put(K key, V value) {
        root = put(root, key ,value);
        size++;
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.leftNode = put(node.leftNode, key, value);
        } else if (cmp > 0) {
            node.rightNode = put(node.rightNode, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public Set<K> keySet() {
        HashSet<K> set = new HashSet<>();
        setAdd(set, root);
        return set;
    }

    private void setAdd(Set<K> set, Node node) {
        if (node == null) {
            return;
        }
        set.add(node.key);
        setAdd(set, node.leftNode);
        setAdd(set, node.rightNode);
    }
    @Override
    public V remove(K key) {
        if (!containsKey(key)) {
            return null;
        }
        V valueToRemove = get(key);
        root = remove(root, key);
        size--;
        return valueToRemove;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.leftNode = remove(node.leftNode, key);
        } else if (cmp > 0) {
            node.rightNode = remove(node.rightNode, key);
        } else {
            if (node.leftNode == null) {
                return node.rightNode;
            }
            if (node.rightNode == null) {
                return node.leftNode;
            }
            Node originalNode = node;
            node = findRightMost(node.leftNode);
            node.rightNode = originalNode.rightNode;
            node.leftNode = remove(node.leftNode, node.key);
        }
        return node;
    }

    private Node findRightMost(Node node) {
        if (node.rightNode == null) {
            return node;
        } else {
            return findRightMost(node);
        }
    }
    @Override
    public V remove(K key, V value) {
        if (!containsKey(key)) {
            return null;
        }
        V valueToRemove = get(key);
        if (valueToRemove.equals(value)) {
            root = remove(root, key);
            size--;
            return valueToRemove;
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.leftNode);
        System.out.println(node.key.toString() + " - "+ node.value.toString());
        printInOrder(node.rightNode);
    }
}
