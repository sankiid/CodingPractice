package com.sankiid.tree;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by sankiid on 11-03-2017.
 */
public class RedBlackTree<T> {
    private static final boolean BLACK = true;
    private static final boolean RED = false;

    private Node<T> root;
    private final Comparator<? super T> comp;

    public Node<T> getRoot() {
        return this.root;
    }

    public RedBlackTree(Comparator<? super T> comp) {
        this.comp = comp;
    }

    public void insert(T data) {
        if (root == null) {
            root = new Node<T>(data, null);
        } else {
            int cmp = 0;
            Node<T> tmp = root;
            Node<T> parent = root;
            do {
                parent = tmp;
                cmp = comp.compare(data, tmp.data);
                if (cmp < 0)
                    tmp = tmp.left;
                else if (cmp > 0)
                    tmp = tmp.right;
                else {
                    tmp.setData(data);
                    return;
                }
            } while (tmp != null);

            Node<T> e = new Node<T>(data, parent);
            if (cmp < 0)
                parent.left = e;
            else
                parent.right = e;
            fixAfterInsertion(e);
        }
    }

    private void fixAfterInsertion(Node<T> x) {
        x.color = RED;
        while (x != null && x != root && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                Node<T> y = rightOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateRight(parentOf(parentOf(x)));
                }
            } else {
                Node<T> y = leftOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        root.color = BLACK;
    }

    private static <T> boolean colorOf(Node<T> p) {
        return (p == null ? BLACK : p.color);
    }

    private static <T> Node<T> parentOf(Node<T> p) {
        return (p == null ? null : p.parent);
    }

    private static <T> void setColor(Node<T> p, boolean c) {
        if (p != null)
            p.color = c;
    }

    private static <T> Node<T> leftOf(Node<T> p) {
        return (p == null) ? null : p.left;
    }

    private static <T> Node<T> rightOf(Node<T> p) {
        return (p == null) ? null : p.right;
    }

    /**
     * From CLR
     */
    private void rotateLeft(Node<T> p) {
        if (p != null) {
            Node<T> r = p.right;
            p.right = r.left;
            if (r.left != null)
                r.left.parent = p;
            r.parent = p.parent;
            if (p.parent == null)
                root = r;
            else if (p.parent.left == p)
                p.parent.left = r;
            else
                p.parent.right = r;
            r.left = p;
            p.parent = r;
        }
    }

    /**
     * From CLR
     */
    private void rotateRight(Node<T> p) {
        if (p != null) {
            Node<T> l = p.left;
            p.left = l.right;
            if (l.right != null) l.right.parent = p;
            l.parent = p.parent;
            if (p.parent == null)
                root = l;
            else if (p.parent.right == p)
                p.parent.right = l;
            else p.parent.left = l;
            l.right = p;
            p.parent = l;
        }
    }

    public void printMax() {
        if (root == null) return;
        Node<T> tmp = root;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        System.out.printf("%d ", tmp.data);
    }

    public void delete(T data) {

        Node<T> p = root;
        while (p != null) {
            int cmp = comp.compare(data, p.data);
            if (cmp < 0)
                p = p.left;
            else if (cmp > 0)
                p = p.right;
            else
                break;
        }
        if (p == null)
            return;
        deleteEntry(p);
    }

    private void deleteEntry(Node<T> p) {
        if (p.left != null && p.right != null) {
            Node<T> s = successor(p);
            p.data = s.data;
            p = s;
        } // p has 2 children

        // Start fixup at replacement node, if it exists.
        Node<T> replacement = (p.left != null ? p.left : p.right);
        if (replacement != null) {
            // Link replacement to parent
            replacement.parent = p.parent;
            if (p.parent == null)
                root = replacement;
            else if (p == p.parent.left)
                p.parent.left = replacement;
            else
                p.parent.right = replacement;

            // Null out links so they are OK to use by fixAfterDeletion.
            p.left = p.right = p.parent = null;

            // Fix replacement
            if (p.color == BLACK)
                fixAfterDeletion(replacement);
        } else if (p.parent == null) { // return if we are the only node.
            root = null;
        } else { //  No children. Use self as phantom replacement and unlink.
            if (p.color == BLACK)
                fixAfterDeletion(p);

            if (p.parent != null) {
                if (p == p.parent.left)
                    p.parent.left = null;
                else if (p == p.parent.right)
                    p.parent.right = null;
                p.parent = null;
            }
        }
    }

    static <T> Node<T> successor(Node<T> t) {
        if (t == null)
            return null;
        else if (t.right != null) {
            Node<T> p = t.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else {
            Node<T> p = t.parent;
            Node<T> ch = t;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    /**
     * From CLR
     */
    private void fixAfterDeletion(Node<T> x) {
        while (x != root && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {
                Node<T> sib = rightOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateLeft(parentOf(x));
                    sib = rightOf(parentOf(x));
                }

                if (colorOf(leftOf(sib)) == BLACK &&
                        colorOf(rightOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(rightOf(sib)) == BLACK) {
                        setColor(leftOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateRight(sib);
                        sib = rightOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(sib), BLACK);
                    rotateLeft(parentOf(x));
                    x = root;
                }
            } else { // symmetric
                Node<T> sib = leftOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateRight(parentOf(x));
                    sib = leftOf(parentOf(x));
                }

                if (colorOf(rightOf(sib)) == BLACK &&
                        colorOf(leftOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(sib)) == BLACK) {
                        setColor(rightOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateLeft(sib);
                        sib = leftOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(sib), BLACK);
                    rotateRight(parentOf(x));
                    x = root;
                }
            }
        }

        setColor(x, BLACK);
    }

    static final class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        Node<T> parent;
        boolean color = BLACK;

        public Node(T data, Node<T> parent) {
            this.data = data;
            this.parent = parent;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }
    }

}
