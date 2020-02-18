package ua.nure.vasilchenko.practice6.part5;

public class Tree<E extends Comparable<E>> {
    private Node<E> root;
    private static final String TAB = "  ";
    StringBuilder sb = new StringBuilder();
    StringBuilder result;

    public boolean add(E element) {
        if (contains(root, element)) {
            return false;
        }
        if (root == null) {
            root = new Node<>(null, element);
            return true;
        } else {
            return add(root, element);
        }
    }

    private boolean contains(Node<E> n, E element) {
        return n != null &&
                (n.value.equals(element)
                        || contains(n.left, element)
                        || contains(n.right, element));
    }

    private boolean add(Node<E> node, E element) {
        if (element.compareTo(node.value) < 0) {
            if (node.left == null) {
                node.left = new Node<>(node, element);
                return true;
            } else {
                add(node.left, element);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(node, element);
                return true;
            } else {
                add(node.right, element);
            }
        }
        return false;
    }

    public void add(E[] elements) {
        for (E element : elements) {
            add(element);
        }
    }

    public boolean remove(E element) {
        boolean toReturn = false;
        if (contains(root, element)) {
            toReturn = true;
        }
        root = deleteRec(root, element);
        return toReturn;
    }


    private Node<E> deleteRec(Node<E> node, E element) {
        if (node == null) {
            return null;
        }

        int res = element.compareTo(node.value);
        if (res < 0) {
            node.left = deleteRec(node.left, element);
        } else if (res > 0) {
            node.right = deleteRec(node.right, element);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.value = minValue(node.right);
            node.right = deleteRec(node.right, node.value);
        }

        return node;
    }

    private E minValue(Node<E> root) {
        E minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }

    public void print() {
        result = new StringBuilder();
        if (root == null) {
            return;
        }
        if (root.right != null) {
            sb = new StringBuilder();
            print(root.right, 1);
            result.append(sb);
        }
        if (root != null) {
            result.append(root.value).append("\n");
        }
        if (root.left != null) {
            sb = new StringBuilder();
            print(root.left, 1);
            result.append(sb);
        }
        String[] temp = result.toString().split("\n");
        StringBuilder stringNew = new StringBuilder();
        for (int i = temp.length - 1; i >= 0; i--) {
            stringNew.append(temp[i]);
            if (i != 0) {
                stringNew.append("\n");
            }
        }
        System.out.println(stringNew.toString());

    }

    private void print(Node<E> node, int c) {
        if (node.right == null && node.left == null) {
            for (int i = 0; i < c; i++) {
                sb.append(TAB);
            }
            sb.append(node.value).append("\n");
        } else if (node.right != null && node.left != null) {
            print(node.right, c + 1);
            for (int i = 0; i < c; i++) {
                sb.append(TAB);
            }
            sb.append(node.value).append("\n");
            print(node.left, c + 1);
        } else if (node.right != null) {
            print(node.right, c + 1);
            for (int i = 0; i < c; i++) {
                sb.append(TAB);
            }
            sb.append(node.value).append("\n");
        } else if (node.left != null) {
            for (int i = 0; i < c; i++) {
                sb.append(TAB);
            }
            sb.append(node.value).append("\n");
            print(node.left, c + 1);
        }
    }

    private static class Node<E> {
        E value;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        Node(Node<E> parent, E element) {
            this.parent = parent;
            this.value = element;
            left = null;
            right = null;
        }
    }
}
