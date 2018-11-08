package com.alpha.HomeWorkTesting;

// Данное дерево сортирует элементы по ключам
// если ключ меньше ключа данного узла, то потомок будет левым, иначе - правым

public class HomeWork_21_10_2018_BinTree {
    static Node root;

    public static class Node{
        int key, value;
        Node left, right, parent;

        public Node(int key, int value, Node parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        public int getKey() {
            return key;
        }

        public Node getParent() {
            return parent;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    public static Node search (int key){
        return search(root, key);
    }

    static Node search (Node t, int key){
        if (t == null || t.key == key) return t;
        if (key < t.key) return search(t.left, key);
        else return search(t.right, key);
    }

    Node insert (Node t, Node parent, int key, int value){
        if (t == null) t = new Node (key, value, parent);
        else {
            if (key < t.key) t.left = insert(t.left, t, key, value);
            else t.right = insert(t.right, t, key, value);
        }
        return t;
    }

    public void insert(int key, int value){
        root = insert(root, null, key, value);
    }

    void print(Node t) {
        if (t != null) {
            print(t.left);
            System.out.println(t.key + ":" + t.value + " ");
            print(t.right);
        }
    }
    public void print() {
        print(root);
        System.out.println();
    }

    public static void main(String[] args) throws NullPointerException {
        HomeWork_21_10_2018_BinTree tree = new HomeWork_21_10_2018_BinTree();
        tree.insert(10, 1);
        tree.insert(9, 2);
        tree.insert(11, 5);
        tree.insert(5, 6);
        tree.insert(6, 7);
        tree.insert(4, 0);
        tree.print();
        System.out.println(tree.search(10).getLeft().key);
        System.out.println(tree.search(10).getRight().key);
        System.out.println(tree.search(5).getParent().key);
        System.out.println(tree.search(5).getLeft().key);
        System.out.println(tree.search(6).getParent().key);
    }



}
