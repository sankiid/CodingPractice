package com.sankiid.linked;

/**
 * Created by sandeep on 11/2/17.
 */
public class LinkedListMain {

    public static void main(String[] args) {
//        personList();

//        integerList();

//        integerList2();

//        integerList3();

        addNumbers();
    }

    private static void addNumbers() {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.insert(6);
        list1.insert(4);
        list1.insert(9);
        list1.insert(5);
        list1.insert(7);
        list1.print();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.insert(4);
        list2.insert(8);
        list2.print();

        LinkedList<Integer> list = addNumbers(list1,list2);
        list.print();
    }

    private static LinkedList<Integer> addNumbers(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        if(list1 != null && list2 != null){
            int carry = 0;
            Node<Integer> head = null;
            while(list1.head != null && list2.head != null){
                int tsum = carry + list1.head.data + list2.head.data;
                carry = tsum >= 10 ? 1:0;
                Node<Integer> node = new Node<Integer>(tsum%10);
                node.next = head;
                head = node;
                list1.head = list1.head.next;
                list2.head = list2.head.next;
            }
            while(list1.head != null){
                int tsum = carry + list1.head.data;
                carry = tsum >= 10 ? 1:0;
                Node<Integer> node = new Node<Integer>(tsum%10);
                node.next = head;
                head = node;
                list1.head = list1.head.next;
            }
            while(list2.head != null){
                int tsum = carry + list2.head.data;
                carry = tsum >= 10 ? 1:0;
                Node<Integer> node = new Node<Integer>(tsum%10);
                node.next = head;
                head = node;
                list2.head = list2.head.next;
            }
            if(carry > 0){
                Node<Integer> node = new Node<Integer>(carry);
                node.next = head;
                head = node;
            }
            return new LinkedList<Integer>(head);
        }
        return null;
    }

    private static void integerList3() {
        LinkedList<Integer> integerList = new LinkedList<Integer>();
        integerList.insert(10);
        integerList.insert(20);
        integerList.insert(30);
        integerList.insert(40);
        integerList.insert(50);
        integerList.insert(60);
        integerList.insert(70);
        integerList.insert(80);
        integerList.insert(90);
        integerList.insert(100);
        integerList.print();
        LinkedList<Integer>  rlist = integerList.reverse(4);
        rlist.print();
    }

    private static void integerList2() {
        LinkedList<Integer> integerList = new LinkedList<Integer>();
        integerList.insert(10);
        integerList.insert(20);
        integerList.insert(30);
        integerList.insert(40);
        integerList.insert(50);
        integerList.insert(40);
        integerList.insert(30);
        integerList.insert(20);
        integerList.insert(10);
        System.out.print(integerList.isPalindrome() + "\n");
        integerList.print();
    }

    private static void integerList() {
        LinkedList<Integer> integerList = new LinkedList<Integer>();
        Node n1 = integerList.insert(10, null);
        Node n2 = integerList.insert(20, null);
        Node n3 = integerList.insert(30, null);
        Node n4 = integerList.insert(40, null);
        Node n5 = integerList.insert(50, null);
        Node n6 = integerList.insert(60, null);
        Node n7 = integerList.insert(70, n3);
        boolean status = integerList.detectLoop();
        System.out.print("loop status " + status + "\n");
        integerList.resolveLoop();
        integerList.print();
    }

    private static void personList() {
        LinkedList<Person> list = new LinkedList<Person>();
        list.insert(new Person("Sandeep", "2616, sec 23"));
        list.insert(new Person("Pradeep", "2616, sec 23"));
        list.insert(new Person("Test", "test"));
        list.insert(new Person("Moni", "sec 23"));
        list.insert(new Person("Mayra", "2616, sec 23"));
        list.print();
        list.remove(new Person("Test", "test"));
        list.print();

        System.out.println(list.getSize());
        System.out.println(list.findSize(list.head));
        System.out.println(list.findElement(list.head, new Person("Sandeep", "2616, sec 23")));

        list.swap(new Person("Pradeep", "2616, sec 23"), new Person("Moni", "sec 23"));
        list.print();
        LinkedList<Person> rlist = list.reverse();
        rlist.print();
    }
}
