import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V> {
    private Node root;

    private class Node{
        private K key;
        private V value;
        private Node left, right;
        private int size;

        public Node(K key, V val, int size){
            this.key = key;
            this.value = val;
            this.size = size;
        }
    }

    /** Removes all of the mappings from this map. */
    @Override
    public void clear(){
        root = null;
    };

    /* Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key){
        if(key ==null){
            throw new IllegalArgumentException();
        }
        return get(key) != null;
    };

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key){
        return get(root, key);
    };

    public V get(Node x, K key){
        if(x ==null){
            return null;
        }
        if(key ==null){
            throw new IllegalArgumentException();
        }

        int cmp = key.compareTo(x.key);
        if(cmp >0){
            return get(x.right, key);
        }else if(cmp<0){
            return get(x.left, key);
        }else{
            return x.value;
        }
    }
    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size(){
        return size(root);
    };

    private int size(Node x){
        if(x==null){
            return 0;
        }else{
            return x.size;
        }
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value){
        if(key==null){
            throw new IllegalArgumentException();
        }
        root = put(root, key, value);
    }

    private Node put(Node x, K key, V value){

//        if(key ==null || value ==null){
//            throw new IllegalArgumentException();
//        }else
        if(x==null){
            return new Node(key,value,1);
        }
        int cmp = key.compareTo(x.key);
        if( cmp>0){
            x.right=put(x.right, key, value);
        }else if(cmp<0){
            x.left=put(x.left, key, value);
        }else{
            x.value=value;
        }
        x.size=1+ size(x.left)+ size(x.right);
        return x;
    }


    public void printInOrder(){
        for(int i=0; i<size(); i++){
            throw new IllegalArgumentException();
        }
    }

    private Node select(int k){
        if(k<0 || k>=size()){
            throw new IllegalArgumentException();
        }
        return select(root,k);
    }
    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }


    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet(){ throw new UnsupportedOperationException();}

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key){ throw new UnsupportedOperationException();}

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value){ throw new UnsupportedOperationException();}

    @Override
    public Iterator<K> iterator(){ throw new UnsupportedOperationException();}
}
