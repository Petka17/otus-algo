package model;

public class SingleArray<T> implements IArray<T> {

    private Object[] array;

    public SingleArray() {
        array = new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(T item) {
        resize(size());
        array[size() - 1] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    private void resize(int index) {
        Object[] newArray = new Object[size() + 1];

        if (index > 0)
            System.arraycopy(array, 0, newArray, 0, index);
        if (index < size())
            System.arraycopy(array, index, newArray, index + 1, size() - index);

        array = newArray;
    }

    @Override
    public void add(T item, int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        resize(index);
        array[index] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        T item = (T) array[index];

        Object[] newArray = new Object[size() - 1];

        if (index > 0)
            System.arraycopy(array, 0, newArray, 0, index);
        if (index < size() - 1)
            System.arraycopy(array, index + 1, newArray, index, size() - index - 1);

        array = newArray;

        return item;
    }
}
