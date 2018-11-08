package com.alpha;

import java.util.*;

/*Двоичная куча
    Двоичная куча — структура данных, двоичное дерево, для которого выполнены три условия:

    1. Значение в любой вершине не меньше чем значение в потомках,
    2. Расстояние до корня отличается не более чем на один уровень,
    3. Заполняется слева направо,

    Основные операции:

    Описание методов.
    1. Восстановление свойства кучи.
    Каждый элемент помещается в конец кучи, потом становится на своё место, соответственно свойств кучи.
    Сложность: O(log(n))

    2. Возврат максимального элемента.
    Возвратить содержимое самой верхней вершины.
    Сложность:O(1).

    3. Удаление максимального элемента.
    Меняются местами первая и последняя вершины, после чего последняя вершина запоминается и удаляется,
    а новая первая вершина проталкивается в кучу, согласно её свойствам.
    Сложность:O(log(n)).

    4. Пирамидальная сортировка.
    В самую первую вершину кучи всегда встаёт максимальный элемент.
    Если каждый раз удалять максимальный элемент — получим отсортированный массив (в тесте в конце).
    Сложность:O(n log(n)).

    О реализации.
    Реализуется структура данных с абстрактным типом данных.  Для хранения нод используется ArrayList.
    Для каждой вершины под номером i её левый потомок хранится в вершине 2*i+1, а правый — в вершине 2*i+2.

    Пока сортировка нод идет ПО КЛЮЧАМ с ЯВНЫМ приведением их к Integer.
    Планирую реализовать интерфейс Map.
    Не знаю пока, насколько правильным решением является ArrayList (возможно расширяемый периодически массив).
    Не знаю пока как реализовать хранение если ключ не число (возможно по хэшам, но правильно ли это).
    */

public class HomeWork_21_10_2018_HeapMap {



    public static class Node<K,V> implements Map.Entry<K,V>, Comparable<Node>  {
        final int hash;
        final K key;
        V value;


        public Node( K key, V value ) {
            this.hash = hashCode();
            this.key = key;
            this.value = value;

        }
        Node(int hash, K key, V value){
            this.hash = hash;
            this.key = key;
            this.value = value;

        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
        @Override
        public int compareTo(Node o) {
            if ((Integer)this.key > (Integer)o.key) return 1;
            else return 0;
        }
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private ArrayList<Node> items;

    public HomeWork_21_10_2018_HeapMap() {
        items = new ArrayList<Node>();
    }

    // поднимаем элемент с наибольшим номером наверх для вставки элементов.
    private void shiftUp() {
        int k = items.size() - 1;
        // пробежались по всем элементам, ключи какие имеют большее значение, всплывают повыше к корню
        while (k > 0) {
            int curr = (k - 1) / 2;
            Node Item = items.get(k);
            Node Parent = items.get(curr);
            if (Item.compareTo(Parent) > 0) {

                items.set(k, Parent);
                items.set(curr, Item);
                k = curr;
            } else break;
        }
    }

    // опускаем элемент для выполнения функции delete
    private void shiftDown() {
        int curr = 0;
        int leftChild = 2 * curr + 1;
        while (leftChild < items.size()) {
            int max = leftChild;
            int rightChild = leftChild + 1;
            if (rightChild < items.size()) {
                if (items.get(rightChild).compareTo(items.get(1)) > 0) {
                    ++max;
                }
            }

            if (items.get(curr).compareTo(items.get(max)) <= 0) {
                Node tmp = items.get(curr);
                items.set(curr, items.get(max));
                items.set(max, tmp);
                curr = max;
                leftChild = 2 * curr + 1;
            } else break;
        }
    }

    public void insert(Node item) {
        items.add(item);
        shiftUp();
    }

    public Node delete() throws NoSuchElementException {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        if (items.size() == 1) return items.remove(0);
        Node x = items.get(0);
        items.set(0, items.remove(items.size() - 1));
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

    public Node max() {
        return items.get(0);
    }

    public void print() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).toString() + " ");
        }
        System.out.println();
    }




    public static void main(String[] args) {
        HomeWork_21_10_2018_HeapMap test = new HomeWork_21_10_2018_HeapMap();
        test.insert(new Node(12, "Kolyan"));
        test.insert(new Node(16, "Jonny"));
        test.insert(new Node(9, "Viki"));
        test.insert(new Node(11, "Buba"));
        test.insert(new Node(10, "Barash"));
        test.insert(new Node(13, "Zorro"));
        test.insert(new Node(31, "Kuka"));
        test.insert(new Node(19, "Mic"));
        test.insert(new Node(2, "Zozo"));
        test.insert(new Node(50, "Alen"));
        test.insert(new Node(23, "Tango"));
        test.print();

        for (; !test.isEmpty(); ) {
            System.out.println(test.max().toString() + " ");
            test.delete();
        }
        System.out.println();
        System.out.println(test.size());
    }

}