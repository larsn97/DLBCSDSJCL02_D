package org.uni.model;

public class ArrayMap<K, V> {

    Entry<K, V>[] table;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public ArrayMap() {
        table = new Entry[10];
    }

    public void put(K key, V value) {
        int index = getIndex(key);

        if(table[index] != null) {
            if(table[index].key.equals(key)) {
                table[index].value = value;
            } else {
                //vergrößern des Arrays
                growArray();
                //rekursive methode
                put(key, value);
            }
        } else {
            table[index] = new Entry<>(key, value);
            size++;
        }
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        for (Entry<K, V> entry : table) {
            if (entry != null && key.equals(entry.key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        for(int i = 0; i < table.length; i++)
            if (table[i] != null && table[i].key.equals(key)) {
                table[i] = null;
                size--;
        }
    }

    public boolean containsKey(K key) {
        for (Entry<K, V> kvEntry : table) {
            if (kvEntry != null && kvEntry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (Entry<K, V> entry : table) {
            if (entry != null && entry.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    @SuppressWarnings("unchecked")
    private void growArray() {
        Entry<K,V>[] newTable = new Entry[table.length * 2];
        System.arraycopy(table,0, newTable,0, table.length);
        table = newTable;
    }
}