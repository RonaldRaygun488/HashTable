import java.util.Objects;

public class Node<K extends Comparable<K>,V> {
    private Node<K,V> parentNode;
    private Node<K,V> leftNode;
    private Node<K,V> rightNode;
    private K key;
    private V value;

    public Node(K key, V value){
        this.key = key;
        this.value = value;
    }

    private Node(K key, V value, Node<K,V> parent){
        this.key = key;
        this.value = value;
        this.parentNode = parent;
    }

    public Node<K, V> getParentNode() {
        return parentNode;
    }

    public Node<K, V> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<K, V> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<K, V> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<K, V> rightNode) {
        this.rightNode = rightNode;
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

    //Add,Find,Delete
    public void add(K key, V value){

        Objects.requireNonNull(key);

        int cmp = key.compareTo(this.key);

        if(cmp == 0){
            this.value = value;
            return;
        }

        if(cmp < 0){
            if(this.leftNode == null)
                this.leftNode = new Node(key,value,this);
            else
                this.leftNode.add(key,value);

            return;
        }

        if(cmp > 0){
            if(this.rightNode == null)
                this.rightNode = new Node(key,value,this);
            else
                this.rightNode.add(key,value);

            return;
        }
        throw new RuntimeException("The laws of physics no longer apply. God help you");
    }

    public V find(K key){

        Objects.requireNonNull(key);

        int cmp = key.compareTo(this.key);

        if(cmp == 0)
            return this.value;

        if(cmp < 0 && this.leftNode != null)
            this.leftNode.find(key);

        if(cmp > 0 && this.rightNode != null)
            this.rightNode.find(key);

        return null;
    }

    //Ignoring delete.... Have fun :)
}
