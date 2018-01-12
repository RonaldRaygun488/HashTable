import java.lang.reflect.Array;
import java.util.Objects;

public class HashTable<K extends Comparable<K>,V> {

    private Object[] table;

    public HashTable(){
        this(20);
    }

    public HashTable(int capacity){
        this.table = new Object[capacity];
    }

    public void add(K key, V value){
        Objects.requireNonNull(key);

        int hash = key.hashCode() % table.length;

        Node<K,V> slot = (Node<K,V>) table[hash];

        if(slot == null){
            table[hash] = new Node<K,V>(key,value);
            return;
        }

        slot.add(key,value);
    }

    public V find(K key){
        Objects.requireNonNull(key);

        int hash = key.hashCode() % table.length;

        Node<K,V> slot = (Node<K,V>) table[hash];

        if(slot == null){
            return null;
        }

        return slot.find(key);
    }
}
