import java.util.Arrays;

public class CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public CustomArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public CustomArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        this.elements = new Object[initialCapacity];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    public void set(int index, E element) {
        checkIndex(index);
        elements[index] = element;
    }

    public void add(E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    public E remove() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        @SuppressWarnings("unchecked")
        E removedElement = (E) elements[--size];
        elements[size] = null;
        return removedElement;
    }

    public void shrink() {
        if (size < elements.length) {
            elements = Arrays.copyOf(elements, size);
        }
    }

    public void grow(int newCapacity) {
        if (newCapacity <= elements.length) {
            return;
        }
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return elements.length;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            grow(newCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }
}