import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

// collection basic mathod
// loop
// add
// delete
//
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        testStack();
        // testQueue();
        //testPriorityQueue();
//        testHashTable();
        // testArrayList();
        // testLinkedList();
    }
    static void testStack(){
            System.out.println("Stack operations.....\n");
            // create a stack of integer number
            Stack<Integer> numberStack = new Stack<>();
            // add elements to stack using push() method
            numberStack.push(56);
            numberStack.push(562);
            numberStack.push(512);
            numberStack.push(262);
            numberStack.push(632);
            numberStack.push(560);
            System.out.println("Stack => " + numberStack);
            System.out.println("Number: " + numberStack.size());
            System.out.println("Is empty:" + numberStack.isEmpty());

            // Popping items from the Stack
        Integer cardAtTop = numberStack.pop();  // Throws EmptyStackException if the stack is empty
        System.out.println("Stack.pop() => " + cardAtTop);
        System.out.println("Current Stack => " + numberStack);
        System.out.println();

        // find the top item
        System.out.println("top most:" +numberStack.peek());

            // for loop: bottom to top
            for(Integer num : numberStack){
                System.out.println("num:" + num);
            }

            // ListIterator(top to bottom)
            ListIterator<Integer> stackIterator = numberStack.listIterator(numberStack.size());
            while(stackIterator.hasPrevious()){
                System.out.println("num:" + stackIterator.previous());
            }

        System.out.println("=== Iterate over a Stack using Java 8 forEach() method ===");
        numberStack.forEach(plate -> {
            System.out.println(plate);
        });

            // search()
            if(!numberStack.isEmpty()){
                int position = numberStack.search(56);
                // no, out -1
                // yes, out index
                if(position == -1){
                    System.out.println("sorry");

                }else{
                    System.out.println("index:" + position);
                }
            }else {
                System.out.println("Sorry");
            }

            // delete
            Integer deletedElement = numberStack.pop();
            System.out.println("pop:" + deletedElement);

            // get index item
            // bottom to top
            Integer indexItem = numberStack.elementAt(1);

            indexItem = numberStack.elementAt(numberStack.size()-2); // get top
            System.out.println("elementAt:" + indexItem);

        }
    static void testQueue(){
        System.out.println("Stack operations.....\n");
        Queue<String> peopleQueen = new LinkedList<String>();

        // add
        peopleQueen.add("AA");
        peopleQueen.add("BB");
        peopleQueen.add("CC");
        peopleQueen.add("DD");
        peopleQueen.add("EE");

        // Display contents of the queue.
        System.out.println("size:" + peopleQueen.size());
        System.out.println("peek:" + peopleQueen.peek());
        // all
        System.out.println("Elements of queue: " + peopleQueen);

        // loop 1
        System.out.println("Loop1: ");
        for(String person : peopleQueen){
            System.out.println("Attending: " + person);
        }

        // loop 2
        System.out.println("Loop2: ");
        Iterator iterator = peopleQueen.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        // To remove the head of queue.
        if(!peopleQueen.isEmpty()){
            // element() to access first element
            String removedele = peopleQueen.remove();
            System.out.println("removed element-" + removedele);
            String ele = peopleQueen.element();
            System.out.println("ele: " + ele);

            // search
            String search = "BB";
            if(peopleQueen.contains(search)){
                System.out.println(search + " in the queue");
            }else {
                System.out.println("sorry");
            }
        }

    }

    static  void testPriorityQueue(){
        Queue<String> pq = new PriorityQueue<>();
        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");
        // 插入数据的存储数据，string，由字母顺序决定
        System.out.println(pq);
        // Hello and welcome![For, Geeks, Geeks]

        // 插入数据的存储数据，int，从小到大排序
        Queue<Integer> pqInt = new PriorityQueue<>();
        pqInt.add(22);
        pqInt.add(222);
        pqInt.add(229);
        pqInt.add(122);
        pqInt.add(202);
        pqInt.add(422);
        pqInt.add(122);
        pqInt.add(292);
        pqInt.add(822);
        System.out.println(pqInt);
        //[22, 122, 122, 222, 202, 422, 229, 292, 822]
    }
    static void testHashTable(){
        System.out.println("Stack operations.....\n");
/*
* <key, value> pair
* */
        Hashtable<Integer, String> errorCode = new Hashtable<>();
        // add
        errorCode.put(1,"AA");
        errorCode.put(2,"BB");
        errorCode.put(10,"CC");
        errorCode.put(51,"DD");
        errorCode.put(101,"EEW");
        errorCode.put(109,"WW");

        for(String msg : errorCode.values()){
            System.out.println(msg);
        }

        for(Integer key : errorCode.keySet()){
            System.out.println(key);
            System.out.println(errorCode.get(key));

        }
        Collection x = errorCode.values();
        System.out.println(errorCode.values());
        System.out.println(errorCode.keySet());

        if(errorCode.containsKey(109)){
            System.out.println("109 is exit");
        }


        // how to add
        // put

        // how to delete
        // remove

        // how to loop
        // key and value

        // how to search
        // containsValue
        String searchValue = "AA";
        if(errorCode.containsValue(searchValue)){
            System.out.println("find it");
        }else{
            System.out.println("can not find it");
        }

    }
    static void testArrayList(){
        System.out.println("ArrayList operations.....\n");
        ArrayList<String> al = new ArrayList<>(); // 没有限制数量
        al.add("AAAA");
        al.add("BBBB");
        System.out.println("Initial ArrayList1 " + al);
        al.add(1, "CCCC"); // 直接插入到指定的位置

        System.out.println("Initial ArrayList2 " + al);
        // Initial ArrayList [Geeks, Geeks, Geeks]

        al.set(1, "For"); // update index item
        System.out.println("Updated ArrayList3 " + al);
        // **Updated ArrayList [Geeks, For, Geeks]**

        // remove at index
        al.remove(1);
        System.out.println("After the Index Removal " + al);
        al.remove("Geeks"); // 删除失败，没有反馈
        al.remove("AAAA");
        System.out.println("After the Object Removal " + al);

        // Using the Get method and the
        al.add("DDDD");
        al.add("EEEE");
        al.add("FFFF");
        // for loop
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + " ");
        }
        System.out.println();

        // Using the for each loop
        // 这个办法非常好
        for (String str : al)
            System.out.print(str + " ");
    }
    static void testLinkedList(){
        System.out.println("Stack operations.....\n");
        // Creating object of the
        // class linked list

        LinkedList<String> ll = new LinkedList<String>();
        // Adding elements to the linked list
        ll.add("A");
        ll.add("B");
        System.out.println(ll);

        ll.addLast("C");
        ll.addFirst("D");
        System.out.println(ll);

        ll.add(2, "E");
        System.out.println(ll);

        // update
        ll.set(1, "For");
        System.out.println("Updated LinkedList " + ll);

        // for loop
        for (int i = 0; i < ll.size(); i++) {
            System.out.print(ll.get(i) + " ");
        }
        System.out.println();

        // Using the for each loop
        // 这个办法非常好
        for (String str : ll)
            System.out.print(str + " \n");

        // remove
        ll.remove("B");
        System.out.println(ll);

        ll.remove(3);
        System.out.println(ll);

        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
    }
}