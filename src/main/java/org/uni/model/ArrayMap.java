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


        V oldValue = null;
        if(table[index] != null) {
            if(table[index].key.equals(key)) {
                oldValue = table[index].value;
                table[index].value = value;
            } else {
                //vergrößern des Arrays
                growArray();
                //rekursive Funktion
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
        for(int i = 0; i < table.length; i++) {
            if(table[i] != null && key.equals(table[i].key)) {
                return table[i].value;
            }
        }
        return null;
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