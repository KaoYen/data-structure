import java.util.Arrays;

public class SimpleArrayList<E> {

    private Object[] array;

    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public SimpleArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public SimpleArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        array = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E element) {
        if (size == array.length) {
            grow();
        }
        array[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) array[index];
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removeElement = (E) array[index];

        int numMoved = size - index - 1; // 計算需要移動的元素個數，在刪除指定索引位置的元素後，索引之後的元素都要向前移動一個位置
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--size] = null; // 將最後一個位置設為null，讓GC回收空間
        return removeElement;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[size - 1]).append("]");
        return sb.toString();
    }

    private void grow() {
        int newCapacity = array.length + (array.length >> 1); // 不加括號會先做加法，再做位元運算 >> 等於做除2
        array = Arrays.copyOf(array, newCapacity);
    }


}
