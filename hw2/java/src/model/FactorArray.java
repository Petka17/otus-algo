package model;

public class FactorArray<T> implements IArray<T> {

    private Object[] array;
    private int factor;
    private int size;
    private int initLength;

    public FactorArray(int factor, int initLength) {
        this.factor = factor;
        this.initLength = initLength;
        array = new Object[initLength];
        size = 0;
    }

    public FactorArray() {
        this(50, 10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.length)
            resize();
        array[size] = item;
        size += 1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    private void resize() {
        Object[] newArray = new Object[array.length + array.length * factor / 100];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public void add(T item, int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        Object[] target = array;

        if (size() == array.length) {
            target = new Object[array.length + array.length * factor / 100];
            System.arraycopy(array, 0, target, 0, index);
        }

        System.arraycopy(array, index, target, index + 1, size() - index);
        target[index] = item;

        array = target;
        size += 1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        // Save item that will be removed
        T item = (T) array[index];

        int lastIndex = size() - 1; // Index of the last element in the current array
        int newSize = size() - 1; // Size of the new array
        Object[] target = array; // Reference to target array, it might be new array or current array

        // If new size less than it needs to be, create new array
        int newLength = array.length / (1 + factor / 100);
        if (newSize <= newLength && newLength > initLength) {
            target = new Object[newLength];
            // Copy elements from left side from the target element
            System.arraycopy(array, 0, target, 0, index);
        }

        // Copy elements from right side from the target element
        if (index < lastIndex)
            System.arraycopy(array, index + 1, target, index, newSize - index);

        // Set null for the last element if needed
        if (target == array && index == lastIndex)
            target[lastIndex] = null;

        size = newSize;
        array = target;

        return item;
    }
}
