package ru.oskin_di.homework_2.impl;

import ru.oskin_di.homework_2.List;

public class LinkedList<E> implements List<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    public LinkedList() {
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    @Override
    public boolean add(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(E e) {
        Node<E> x = first;
        if (e == null) {
            while (x != null) {
                if (x.item == null) {
                    remove(x);
                    return true;
                }
                x = x.next;
            }
        } else {
            while (x != null) {
                if (e.equals(x.item)) {
                    remove(x);
                    return true;
                }
                x = x.next;
            }
        }
        return false;
    }

    private void remove(Node<E> e) {
        Node<E> next = e.next;
        Node<E> prev = e.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            e.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            e.next = null;
        }
        e.item = null;
        size--;
    }

    @Override
    public E get(int index) {
        Node<E> x;
        if (index < (size / 2)) {
            x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
            x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }
        return x.item;
    }

    @Override
    public int indexOf(E e) {
        int i = 0;
        Node<E> x = first;
        if (e == null) {
            while (x != null) {
                if (x.item == null)
                    return i;
                x = x.next;
                i++;
            }
        } else {
            while (x != null) {
                if (x.item.equals(e))
                    return i;
                x = x.next;
                i++;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        Node<E> x = first;
        while (x != null) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
