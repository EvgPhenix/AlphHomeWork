package com.alpha.HomeWorkTesting;

public class HomeWork_21_10_2018_test {
    Node root;

    static class Node {
        int key;
        int value;
        Node l;
        Node r;
        Node p;
        public Node(int key, int value, Node p) {
            this.key = key;
            this.value = value;
            this.p = p;
        }
    }

    public Node search(int key) {
        return search(root, key);
    }

    Node search(Node t, int key) {
        if (t == null || t.key == key)
            return t;
        if (key < t.key)
            return search(t.l, key);
        else
            return search(t.r, key);
    }



    Node insert(Node t, Node p, int key, int value) {
        if (t == null) {
            t = new Node(key, value, p);
        } else {
            if (key < t.key)
                t.l = insert(t.l, t, key, value);
            else
                t.r = insert(t.r, t, key, value);
        }
        return t;
    }

    public void insert(int key, int value) {
        root = insert(root, null, key, value);
    }

//    void replace(Node a, Node b) {
//        if (a.p == null)
//            root = b;
//        else if (a == a.p.l)
//            a.p.l = b;
//        else
//            a.p.r = b;
//        if (b != null)
//            b.p = a.p;
//    }
//
//
//    void remove(Node t, int key) {
//        if (t == null)
//            return;
//        if (key < t.key)
//            remove(t.l, key);
//        else if (key > t.key)
//            remove(t.r, key);
//        else if (t.l != null && t.r != null) {
//            Node m = t.r;
//            while (m.l != null)
//                m = m.l;
//            t.key = m.key;
//            t.value = m.value;
//            replace(m, m.r);
//        } else if (t.l != null) {
//            replace(t, t.l);
//        } else if (t.r != null) {
//            replace(t, t.r);
//        } else {
//            replace(t, null);
//        }
//    }
//    public void remove(int key) {
//        remove(root, key);
//    }

    void print(Node t) {
        if (t != null) {
            print(t.l);
            System.out.println(t.key + ":" + t.value + " ");
            print(t.r);
        }
    }
    public void print() {
        print(root);
        System.out.println();
    }
    // Usage example
    public static void main(String[] args) {
        HomeWork_21_10_2018_test tree = new HomeWork_21_10_2018_test();
        tree.insert(3, 1);
        tree.insert(2, 2);
        tree.insert(4, 5);
        tree.insert(5, 6);
        tree.insert(6, 7);
        tree.print();
//        tree.remove(2);
//        tree.remove(3);
//        tree.print();
//        tree.remove(4);
    }
}
