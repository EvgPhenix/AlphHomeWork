package com.alpha.HomeWorkTesting;

public class HomeWork_21_10_2018_BinTree_1 {
    static Node root;

    public HomeWork_21_10_2018_BinTree_1(Integer[] array) {
        for (int i = 0; i < array.length; i+=2) {
            HomeWork_21_10_2018_BinTree_1.insert(array[i], array[i+1]);
        }
    }

    public static class Node{
        int key, value;
        Node left, right;

        //        public Node(int key, int value, Node parent) {
        public Node(int key, int value){
            this.key = key;
            this.value = value;
//            this.parent = parent;
        }

        public int getKey() {
            return key;
        }

//        public Node getParent() {
//            return parent;
//        }

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

    //    Node insert (Node t, Node parent, int key, int value){
    static Node insert (Node t, int key, int value){
//        if (t == null) t = new Node (key, value, parent);
        if (t == null) t = new Node (key, value);
        else {
            if (key < t.key) t.left = insert(t.left, key, value);
            else t.right = insert(t.right, key, value);
        }
        return t;
    }

    public static void insert(int key, int value){
        root = insert(root, key, value);
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

        Integer[] array = {10, 1, 9, 2, 11, 5, 5, 6, 6, 7, 4, 0};


        HomeWork_21_10_2018_BinTree_1 tree = new HomeWork_21_10_2018_BinTree_1(array);
//        tree.insert(10, 1);
//        tree.insert(9, 2);
//        tree.insert(11, 5);
//        tree.insert(5, 6);
//        tree.insert(6, 7);
//        tree.insert(4, 0);
        tree.print();
        System.out.println(tree.search(10).getLeft().key);
        System.out.println(tree.search(10).getRight().key);
//        System.out.println(tree.search(5).getParent().key);
        System.out.println(tree.search(5).getLeft().key);
//        System.out.println(tree.search(6).getParent().key);
    }
}
