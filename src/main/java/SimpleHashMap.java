import java.util.ArrayList;
import java.util.List;

public class SimpleHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;

    private static final double LOAD_FACTOR = 0.75;

    private List<Entry<K, V>>[] buckets;

    private int capacity;

    private int size;

    public SimpleHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public SimpleHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new List[capacity];
        this.size = 0;
    }

    public void put(K key, V value) {
        if (key == null)
            throw new IllegalArgumentException("Key cannot be null");

        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new ArrayList<>();
        }

        // 檢查鍵值是否存在，如果存在則更新值，否則添加新的鍵值對
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        buckets[index].add(new Entry<>(key, value));
        size++;

        if ((double) size / capacity >= LOAD_FACTOR) {
            resize();
        }
    }

    public V get(K key) {
        if (key == null)
            throw new IllegalArgumentException("Key cannot be null");

        int index = getIndex(key);
        if (buckets[index] == null)
            return null;

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    public void remove(K key) {
        if (key == null)
            throw new IllegalArgumentException("Key cannot be null");

        int index = getIndex(key);
        if (buckets[index] == null)
            return;

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.getKey().equals(key)) {
                buckets[index].remove(entry);
                size--;
                return;
            }
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return capacity;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    private void resize() {
        capacity *= 2;
        List<Entry<K, V>>[] newBuckets = new List[capacity];

        for (List<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    int index = getIndex(entry.getKey());
                    if (newBuckets[index] == null) {
                        newBuckets[index] = new ArrayList<>();
                    }
                    newBuckets[index].add(entry);
                }
            }
        }

        buckets = newBuckets;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

}
