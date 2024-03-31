public class SimpleQueue<T> {

    private static class Node<T> {

        private T data;

        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;

    private Node<T> tail;

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (tail != null) {
            tail.next = newNode;
        }

        tail = newNode;
        if (isEmpty()) {
            head = tail;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T data = head.data;
        head = head.next;
        if (isEmpty()) {
            tail = null;
        }

        return data;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;

    }

}
