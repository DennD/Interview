package ru.oskin_di.homework_2.impl;

import ru.oskin_di.homework_2.List;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private E[] elementData;

    public ArrayList() {
        this.elementData = (E[]) new Object[DEFAULT_CAPACITY];
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
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = e;
        size++;
        return true;
    }

    private void grow() {
        elementData = Arrays.copyOf(elementData, size + size / 2);
    }

    @Override
    public boolean remove(E e) {
        if (e == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    offset(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elementData[i].equals(e)) {
                    offset(i);
                    return true;
                }
            }
        }
        return false;
    }

    private void offset(int i) {
        System.arraycopy(elementData, i + 1, elementData, i, size - (i + 1));
        size--;
    }

    @Override
    public E get(int index) {
        return elementData[index];
    }

    @Override
    public int indexOf(E e) {
        if (e == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (e.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }
}
