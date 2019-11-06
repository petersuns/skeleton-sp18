public class LinkedListDeque<T>{

    public  class Node{
        public T item;
        public Node pre;
        public Node next;

        public Node(Node p, T i, Node n){
            pre = p;
            item=i;
            next = n;
            //System.out.println(size);
        }
    }

    private int size;
    //public int item;
    private Node sentinel;
    //public T[] = ;

    // creates an empty list
    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    //the first item (if it exists) is at sentinel.next.
//    public LinkedListDeque(int item){
//        sentinel = new Node(null, item, null);
//        sentinel.pre = sentinel;
//        sentinel.next = sentinel;
//
//        sentinel.next = new Node(sentinel,item,sentinel.next);
//        sentinel.pre = sentinel.next;
//        size = 1;
//    }

    public void addFirst(T item){
        sentinel.next.pre =  new Node(sentinel, item, sentinel.next);;
        sentinel.next = sentinel.next.pre;
        size +=1;
    }

    public void addLast(T item){
        sentinel.pre =  new Node(sentinel.next, item, sentinel);;
        sentinel.next.next = sentinel.pre;
        size +=1;
    }

    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i=0; i<this.length; i++){
            System.out.println(this.item);
            System.out.println(" ");
            this = this.next;
        }
    }

    public T removeFirst(){
        if(size==0){
            return null;
        }
        T first_item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.pre=sentinel;
        size -=1;
        return first_item;
    }

    public T removeLast(){
        if(size==0){
            return null;
        }
        T last_item = sentinel.pre.item;
        sentinel.pre = sentinel.pre.pre;
        sentinel.pre.next=sentinel;
        size -=1;
        return last_item;
    }

    public T get(int index) {
        if (size == 0) {
            return null;
        }
        Node ptr = sentinel.next;
        for (int i = 1; i < index; i++) {

            ptr = ptr.next;
            i++;
        }
        return ptr.item;
    }

    public T getRecursive(int index){
        if(size==0){
            return null;
        }
        if(index==0){
            return prt.item;
        }
        Node ptr = sentinel.next;
        return getRecursive(index-1);
    }

//
//    private void resize(int capacity){
//        T[] new_items =(T[]) new Object[capacity];
//        System.arraycopy(items, 0, new_items, 0, size);
//        items = new_items;
//    }
//
//
//
//
//
//    public void remove(){
//
//    }
//
//    public int get(int i){
//        return items[i];
//    }
//
//
//
//
//

}