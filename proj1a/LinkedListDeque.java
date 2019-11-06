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
        sentinel.pre =  new Node(sentinel.pre, item, sentinel);;
        sentinel.pre.pre.next = sentinel.pre;
        size +=1;
    }

    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }

    public void printDeque(){
        Node toPrint = sentinel.next;
        for (int i=0; i<size; i++){
            System.out.print(toPrint.item);
            System.out.print(" ");
            toPrint = toPrint.next;
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
        if (size == 0 || index>size-1|| index<0) {
            return null;
        }
        Node ptr = sentinel.next;
        for (int i = 0; i < index; i++) {

            ptr = ptr.next;
            //i++;
        }
        return ptr.item;
    }

    public T getRecursive(int index){
        Node ptr = sentinel.next;
        if(size==0){
            return null;
        }
        if(index==0){
            return ptr.item;
        }
        return getRecursive(index-1);
    }
    public static void main(String[] args) {
        LinkedListDeque<Integer> Dllist = new LinkedListDeque<>();
        Dllist.addFirst(666);
        Dllist.addLast(6666);
        Dllist.addLast(66666);
        Dllist.printDeque();
        System.out.println();// expected (666 6666 66666)
        System.out.println("Test getIterative #1");
        System.out.println(Dllist.get(0)); // expected 666
        System.out.println(Dllist.get(1)); // expected 6666
        System.out.println(Dllist.get(2)); // expected 66666
        System.out.println(Dllist.get(5)); // expected null
        System.out.println("Test getIterative #1");
        System.out.println(Dllist.getRecursive(0)); // expected 666
        System.out.println(Dllist.getRecursive(1)); // expected 6666
        System.out.println("Test done!");
////
//        Dllist.removeFirst();
//        Dllist.printDeque();                        // expected (6666 66666)
//        System.out.println("Test getIterative #2 removeFirst");
//        System.out.println(Dllist.get(0)); // expected 6666
//        System.out.println(Dllist.get(1)); // expected 66666
//        System.out.println("Test getRecursive #2 removeFirst");
//        System.out.println(Dllist.getRecursive(0)); // expected 6666
//        System.out.println(Dllist.getRecursive(1)); // expected 66666
//
//        Dllist.removeLast();
//        Dllist.printDeque();                        // expected 6666
//        System.out.println("Test getIterative #3 removeLast");
//        System.out.println(Dllist.get(0)); // expected 6666
//        System.out.println(Dllist.get(1)); // expected null
//        System.out.println("Test getRecursive #3 removeFirst");
//        System.out.println(Dllist.getRecursive(0)); // expected 6666
//        System.out.println(Dllist.getRecursive(1)); // expected null
    }


}