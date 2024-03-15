/**
 * Implement simple foundation of StringBuilder
 */
public final class SimpleStringBuilder {
    private char[] buffer;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public SimpleStringBuilder() {
        buffer = new char[DEFAULT_CAPACITY];
        size = 0;
    }

    public SimpleStringBuilder(int capacity) {
        buffer = new char[capacity];
        size = 0;
    }

    public void append(String str) {
        ensureCapacity(size + str.length());
        for (int i = 0; i < str.length(); i++) {
            buffer[size++] = str.charAt(i);
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > buffer.length) {
            int newCapacity = Math.max(buffer.length * 2, minCapacity);
            char[] newBuffer = new char[newCapacity];
            System.arraycopy(buffer, 0, newBuffer, 0, size);
            buffer = newBuffer;
        }
    }

    public int getBufferSize() {
        return buffer.length;
    }

    @Override
    public String toString() {
        return new String(buffer, 0, size);
    }
}
