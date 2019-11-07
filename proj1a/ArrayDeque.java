public class ArrayDeque<T>{

    public T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

//    public int l = items.length;
//    private Node sentinel;

    // creates an empty list
    public ArrayDeque(){
        items =(T[]) new Object[8];
        size=0;
        nextFirst=0;
        nextLast = 1;

    }

    public int plusOne(int nextFirst ){
        if(nextFirst !=0){
            nextFirst -=1;
        }else {
            nextFirst = items.length - 1;
        }
        return nextFirst;
    }

    public int minusOne(int nextLast ){
        if(nextFirst != items.length-1){
            nextFirst +=1;
        }else {
            nextFirst = 0;
        }
        return nextFirst;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize() {
        if (size==items.length){
            T[] a = (T[]) new Object[size * 2];

            System.arraycopy(items, 0, a, 0, size);
            items = a;
            nextFirst = size*2 -1;
            nextLast = size ;
        }else if(size>=16 && size<items.length/4) {
            T[] a = (T[]) new Object[size / 2];
            System.arraycopy(items, 0, a, 0, size/2);
            items = a;
            nextFirst = size/2 -1;
            nextLast = size ;
        }

    }

    public void addFirst(T item){
        resize();
        T[] new_list = (T[]) new Object[items.length+1];
        new_list[0] = item;
        System.arraycopy(items, 0, new_list, 1, size);
        size +=1;
        items = new_list;
        nextFirst = plusOne(nextFirst);
    }

    public void addLast(T item){
        resize();
        items[size] =item;
        size +=1;
        nextLast = minusOne(nextLast);

    }

    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public int len(){
        return items.length;
    }

    public void printDeque(){
        //Node toPrint = sentinel.next;
        for (int i = 0; i < size; i++){
            System.out.print(items[i]);
            System.out.print(" ");
            //toPrint = toPrint.next;
        }
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        }
        resize();

        T first_item = items[0];
        T[] new_list = (T[]) new Object[items.length];
        System.arraycopy(items, 1, new_list, 0, size-1);
        items = new_list;
        size -= 1;
        nextFirst = minusOne(nextFirst);

        return first_item;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        resize();

        T last_item = items[size - 1];
        items[size-1] = null;
        size -= 1;
        nextLast = plusOne(nextLast);

        return last_item;
    }

    public T get(int index) {
        if (size == 0 || index > size - 1 || index < 0) {
            return null;
        }
        return items[index];
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> Dllist = new ArrayDeque<>();
        System.out.println("size:" + Dllist.size); // expect 1
        System.out.println("length:" + Dllist.len()); // expect 9
        Dllist.addLast(1);
        System.out.println("size:" + Dllist.size); // expect 1
        System.out.println("length:" + Dllist.len()); // expect 9
        Dllist.addLast(2);
        System.out.println("size:" + Dllist.size); // expect 1
        System.out.println("length:" + Dllist.len()); // expect 9
        Dllist.addLast(3);
        System.out.println("size:" + Dllist.size); // expect 1
        System.out.println("length:" + Dllist.len()); // expect 9
        Dllist.addLast(4);
        System.out.println("size:" + Dllist.size); // expect 1
        System.out.println("length:" + Dllist.len()); // expect 9
        Dllist.addLast(5);
        Dllist.addLast(5);
        Dllist.addLast(5);
        Dllist.addLast(5);
        Dllist.addLast(5);
        Dllist.addLast(5);

        System.out.println("size:" + Dllist.size); // expect 1
        System.out.println("length:" + Dllist.len()); // expect 9
        Dllist.addLast(6);

        Dllist.printDeque();
        System.out.println(); // expect 1
        System.out.println("Test get #1");
        System.out.println(Dllist.get(0)); // expected 666
        System.out.println(Dllist.get(1)); // expected 6666
        System.out.println(Dllist.get(2)); // expected 66666
        System.out.println(Dllist.get(3)); // expected null
//        System.out.println(); // expect 1
//        Dllist.removeFirst();
//        Dllist.removeLast();
//        Dllist.printDeque();
//        System.out.println(); // expect 1
//        System.out.println("Test get #1");
//        System.out.println(Dllist.get(0)); // expected 666
//        System.out.println(Dllist.get(1)); // expected 6666
//        System.out.println(Dllist.get(2)); // expected 66666
//        System.out.println(Dllist.get(3)); // expected null
          System.out.println("testing"); // expected null
          Dllist.addLast(0);
          System.out.println(Dllist.get(0)); // expected 666
          Dllist.removeFirst();//     ==> 0
            Dllist.addFirst(3);
            Dllist.get(0);//      ==> 3
            Dllist.removeLast();//      ==> 3
            Dllist.addLast(6);
            Dllist.removeFirst();//     ==> 6
            Dllist.addLast(8);
            Dllist.addLast(9);
            Dllist.get(0);  //    ==> 8
           System.out.println(Dllist.get(0)); // expected 666
        System.out.println("size:" + Dllist.size); // expect 1
        System.out.println("length:" + Dllist.len()); // expect 9
        System.out.println("2 % 9 = " + 2%9); // expect 9
        System.out.println("0 % 9 = " + 0%9); // expect 9

        Dllist.removeFirst();


    }

}