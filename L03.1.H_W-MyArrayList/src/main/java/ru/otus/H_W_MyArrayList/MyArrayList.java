package ru.otus.H_W_MyArrayList;

import java.util.*;

public class MyArrayList<T> implements List<T> {

    private static final int INIT_ARR_LENGTH = 10;
    //"внутренний" массив для хранения всех элеметов списка:
    private Object[] arrLstBuffer;
    //переменная для отслеживания текущего размера списка:
    private int size;

    MyArrayList(int initialSize) {
        this.arrLstBuffer = new Object[initialSize];
        this.size = 0;
    }

    MyArrayList() {
        this(INIT_ARR_LENGTH);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() throws RuntimeException {
        if (true)
            throw new RuntimeException();
        return false;
    }

    @Override
    public boolean contains(Object o) throws RuntimeException {
        if (true)
            throw new RuntimeException();
        return false;
    }

    @Override
    public Iterator<T> iterator() throws RuntimeException {
        if (true)
            throw new RuntimeException();
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] newNoNullsArray = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            newNoNullsArray[i] = this.arrLstBuffer[i];
        }
        return newNoNullsArray;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) throws RuntimeException {
        if (true)
            throw new RuntimeException();
        return null;
    }

    @Override
    public boolean add(T t) {
        //когда число элементов "внутреннего" массива становится равным его "объёму"/вместимости,
        //увеличиваем "объём"/вместимость примерно в 1,5 раза:
        if (size == arrLstBuffer.length)
            arrLstBuffer = Arrays.copyOf(arrLstBuffer, (int)((arrLstBuffer.length) * 1.5));
        size++;
        arrLstBuffer[size - 1] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) throws RuntimeException {
        if (true)
            throw new RuntimeException();
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) throws RuntimeException {
        if (true)
            throw new RuntimeException();
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) throws RuntimeException {
        if (true)
            throw new RuntimeException();
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) throws RuntimeException {
        if (true)
            throw new RuntimeException();
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) throws RuntimeException {
        if (true)
            throw new RuntimeException();
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) throws RuntimeException {
        if (true)
            throw new RuntimeException();
        return false;
    }

    @Override
    public void clear() throws RuntimeException {
        if (true)
            throw new RuntimeException();

    }

    @Override
    public T get(int index) {
        return (T)arrLstBuffer[index];
    }

    @Override
    public T set(int index, T element) throws RuntimeException {
        Object prevElem = arrLstBuffer[index];
        arrLstBuffer[index] = element;
        return (T) prevElem;
    }

    @Override
    public void add(int index, T element) throws RuntimeException {
        if (true)
            throw new RuntimeException();

    }

    @Override
    public T remove(int index) throws RuntimeException {
        if (true)
            throw new RuntimeException();
        return null;
    }

    @Override
    public int indexOf(Object o) throws RuntimeException {
        if (true)
            throw new RuntimeException();
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) throws RuntimeException {
        if (true)
            throw new RuntimeException();
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() throws RuntimeException {
        class ListIteratorInnerClass implements ListIterator<T> {
            //переменная для хранения следующей позиции "курсора" во внутреннем массиве arrLstBuffer:
            int cursorNextPos;
            //индекс последнего возвращённого методами класса MyArrayList (и ListIteratorInnerClass) элемента
            //внутреннего массива arrLstBuffer ((-1), если такого возврата не производилось, например, в методе remove):
            int lastRet = -1; // index of last element returned; -1 if no such

            @Override
            public boolean hasNext() {
                return this.cursorNextPos < MyArrayList.this.size;
            }

            @Override
            public T next() {
                int nextPosBuff = this.cursorNextPos;
                if (this.cursorNextPos >= MyArrayList.this.size)
                    throw new NoSuchElementException();
                this.cursorNextPos = nextPosBuff + 1;
                return (T) MyArrayList.this.arrLstBuffer[this.lastRet = nextPosBuff];
            }

            @Override
            public boolean hasPrevious() {
                return this.cursorNextPos > 0;
            }

            @Override
            public T previous() {
                if (true)
                    throw new RuntimeException();
                return null;
            }

            @Override
            public int nextIndex() {
                return this.cursorNextPos;
            }

            @Override
            public int previousIndex() {
                if (true)
                    throw new RuntimeException();
                return 0;
            }

            @Override
            public void remove() {
                if (true)
                    throw new RuntimeException();
            }

            @Override
            public void set(T t) {
                if (this.lastRet < 0)
                    throw new IllegalStateException();

                MyArrayList.this.set(lastRet, t);
            }

            @Override
            public void add(T t) {
                if (true)
                    throw new RuntimeException();
            }
        }

        return new ListIteratorInnerClass();
    }

    @Override
    public ListIterator<T> listIterator(int index) throws RuntimeException {
        if (true)
            throw new RuntimeException();
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) throws RuntimeException {
        if (true)
            throw new RuntimeException();
        return null;
    }

    public static void main(String... args) {
        //Проверки работы на списке типа MyArrayList методов из java.util.Collections: addAll, copy, sort
        //[для чего в классе MyArrayList, реализующем интерфейс List,
        //переопределил методы add(), size(), get(), set(), toArray(), listIterator()]:

        MyArrayList<Integer> mArrInt = new MyArrayList<>();
        Collections.addAll(mArrInt, 6, 7, 5, 4, 9, 3);

        MyArrayList<Integer> mArrIntCopy = new MyArrayList<>(10);
        Collections.addAll(mArrIntCopy, 1, 2, 3, 4, 5, 6);

        Collections.copy(mArrIntCopy, mArrInt);

        //элементы внутреннего массива mArrInt.arrLstBuffer, "равные" null в comparator-е нужно "сдвинуть" в конец сортировки /
        //отношения порядка на множестве целых чисел, для чего используется Integer.MAX_VALUE:
        Collections.sort(mArrInt, (Integer o1, Integer o2) -> (Integer)((o1==null?Integer.MAX_VALUE:o1) - (o2==null?Integer.MAX_VALUE:o2)));

        /*
        //отладочный код:
        //частичная проерка работоспособности итератора:
        ListIterator<Integer> iter = mArrIntCopy.listIterator();
        int j;
        while (iter.hasNext()) {
            j = iter.nextIndex();
            iter.next();
            System.out.println(String.valueOf(j) + ". mArrInt: " + String.valueOf(mArrIntCopy.get(j)));
        }
        //*/

        /*
        //отладочный код:
        for (int i = 0; i < mArrInt.size; i++) {
            System.out.println(String.valueOf(i) + ". mArrInt: " + String.valueOf(mArrInt.get(i)));
        }
        for (int i = 0; i < mArrInt.arrLstBuffer.length; i++) {
            System.out.println(String.valueOf(i) + ". mArrInt.arrLstBuffer: " + String.valueOf(mArrInt.arrLstBuffer[i]));
        }

        for (int i = 0; i < mArrIntCopy.size; i++) {
            System.out.println(String.valueOf(i) + ". mArrIntCopy: " + String.valueOf(mArrIntCopy.get(i)));
        }
        for (int i = 0; i < mArrIntCopy.arrLstBuffer.length; i++) {
            System.out.println(String.valueOf(i) + ". mArrIntCopy.arrLstBuffer: " + String.valueOf(mArrIntCopy.arrLstBuffer[i]));
        }
        //*/
    }
}
