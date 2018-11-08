package com.alpha.HomeWorkTesting;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heap <T extends Comparable<T> >{

    private ArrayList<T> items;

    public Heap() {
        items = new ArrayList<T> ();
    }

    //using shiftUp for insert.
    private void shiftUp () {
        int k = items.size() - 1;
        while (k > 0){
            int curr = (k-1)/2;
            T Item = items.get(k);
            T Parent = items.get(curr);
//            if (Item.compareTo(Parent) > 0){
            if ((Integer)Item>(Integer)Parent){
                items.set(k, Parent);
                items.set(curr, Item);
                k = curr;
            }
            else break;
        }
    }

    //using shiftDown fo delete
    private void shiftDown() {
        int curr = 0;
        int leftChild = 2*curr+1;
        while (leftChild < items.size()) {
            int max = leftChild;
            int rightChild = leftChild + 1;
            if (rightChild < items.size()) {
                if (items.get(rightChild).compareTo(items.get(1)) > 0) {
                    ++max;
                }
            }
            if (items.get(curr).compareTo(items.get(max)) < 0) {
                T tmp = items.get(curr);
                items.set(curr, items.get(max));
                items.set(max, tmp);
                curr = max;
                leftChild = 2*curr+1;
            }
            else break;
        }
    }

    public void insert(T item) {
        items.add(item);
        shiftUp();
    }

    public T delete() throws NoSuchElementException {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        if (items.size() == 1) return items.remove(0);
        T x = items.get(0);
        items.set(0, items.remove(items.size()-1));
        shiftDown();
        return x;
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public String toString() {
        return items.toString();
    }

    public T max() {
        return items.get(0);
    }
    public void print() {
        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i).toString() + " ");
        }
        System.out.println();
    }
}

class Codechef {
    public static void main (String[] args) {
        Heap <Integer> test = new Heap<Integer> ();
        test.insert(16);
        test.insert(9);
        test.insert(11);
        test.insert(10);
        test.insert(13);
        test.insert(31);
        test.insert(19);
        test.insert(2);
        test.insert(50);
        test.insert(23);
        test.print();
        //To kill some hares in the same time:
        //- isEmpty() works;
        // max() and toString() too
        // so does delete() => shiftDown() works;
        // heapsort :D
        for (;!test.isEmpty();) {
            System.out.print(test.max().toString() + " ");
            test.delete();
        }
    }
}
