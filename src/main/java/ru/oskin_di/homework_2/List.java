package ru.oskin_di.homework_2;

public interface List<E> {

    int size();

    boolean isEmpty();

    boolean contains(E e);

    boolean add(E e);

    boolean remove(E e);

    E get(int index);

    int indexOf(E e);

    void clear();


}
