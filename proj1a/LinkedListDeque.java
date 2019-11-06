public class LinkedListDeque{

    public  class Node{
        public int item;
        public Node pre;
        public Node next;

        public Node(Node p, int i, Node n){
            pre = p;
            item=i;
            next = n;
            //System.out.println(size);
        }
    }

    private int size;
    public int item;
    private Node sentinel;
    //public T[] = ;

    // creates an empty list
    public LinkedListDeque(){
        sentinel = new Node(null, item, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel.pre;
        size = 0;
    }
    //the first item (if it exists) is at sentinel.next.
    public LinkedListDeque(int item){
        sentinel = new Node(null, item, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel.pre;

        sentinel.next = new Node(sentinel,item,sentinel.next);
        sentinel.pre = sentinel.next;
        size = 1;
    }

    public void addFirst(int item){
        sentinel.next.pre =  new Node(sentinel, item, sentinel.next);;
        sentinel.next = sentinel.next.pre;
        size +=1;
    }

    public void addLast(int item){
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

    public int removeFirst(){
        while(size==0){
            return null;
        }
        sentinel.next = sentinel.next.next;
        sentinel.next.next.pre=sentinel;
        size -=1;
    }
//
//
//    public int getRecursive(int index){
//
//    }
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