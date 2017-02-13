package com.sankiid.linked;

/**
 * Created by sandeep on 11/2/17.
 */
public class LinkedList<T> {

    public Node<T> head;
    public int size;

    public LinkedList() {
        head = null;
        this.size = 0;
    }

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    public void insert(T p) {
        Node<T> node = new Node(p);
        node.next = head;
        head = node;
        this.size += 1;

    }

    public Node insert(T data, Node<T> n) {
        Node<T> node = new Node(data);
        node.next = n;
        if (head == null) {
            head = node;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = node;
        }
        return node;
    }

    public void remove(T p) {
        if (head != null && p != null) {
            Node<T> tmp = head;
            if (p.equals(head.data)) {
                tmp = tmp.next;
                head.next = null;
                head = tmp;
                return;
            }

            while (tmp != null && tmp.next != null) {
                if (p.equals(tmp.next.data)) {
                    Node<T> temp = tmp.next;
                    tmp.next = tmp.next.next;
                    temp.next = null;
                    this.size -= 1;
                    break;
                }
                tmp = tmp.next;
            }
        }
    }

    public void print() {
        Node<T> tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " -> ");
            tmp = tmp.next;
        }
        System.out.print("\n");
    }

    public int getSize() {
        return this.size;
    }

    public int findSize(Node<T> head) {
        if (head == null) return 0;
        return 1 + findSize(head.next);
    }

    public int findElement(Node<T> head, T element) {
        return findElementUtil(head, element, new ValueIndex(0));
    }

    private int findElementUtil(Node<T> head, T element, ValueIndex valueIndex) {
        if (head == null) return -1;
        if (head.data.equals(element)) {
            return valueIndex.index;
        }
        valueIndex.index += 1;
        return findElementUtil(head.next, element, valueIndex);
    }

    public void swap(T data1, T data2) {
        if (data1.equals(data2)) return;

        Node pn1 = null;
        Node n1 = head;
        while (n1 != null) {
            if (n1.data.equals(data1)) {
                break;
            }
            pn1 = n1;
            n1 = n1.next;
        }
        Node pn2 = null;
        Node n2 = head;
        while (n2 != null) {
            if (n2.data.equals(data2)) {
                break;
            }
            pn2 = n2;
            n2 = n2.next;
        }

        if (n1 == null || n2 == null) {
            // do nothing as one of the node is not present in linked list
        } else if (pn1 == null || pn2 == null) {
            //head handling
            Node h = pn1 == null ? n1 : n2;
            Node o = pn1 == null ? n2 : n1;
            Node po = pn1 == null ? pn2 : pn1;
            po.next = h;
            Node t = h.next;
            h.next = o.next;
            o.next = t;
            head = o;
        } else {
            pn1.next = n2;
            pn2.next = n1;
            Node t = n1.next;
            n1.next = n2.next;
            n2.next = t;
        }
    }

    public LinkedList<T> reverse() {
        Node<T> pre = null;
        Node<T> cur = head;
        while (cur != null) {
            cur = cur.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        head = pre;
        return new LinkedList<T>(pre);
    }

    public LinkedList<T> reverse(int count) {
        Node<T> curHead = null;
        Node<T> last = this.head;
        while (this.head != null) {
            Node<T> cur = getListToken(count);
            Node<T> lastNode = cur;
            Node<T> pre = null;
            Node<T> tmp = cur;
            while (tmp != null) {
                tmp = tmp.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            if (curHead == null) {
                curHead = pre;
            } else {
                last.next = pre;
            }
            last = lastNode;
        }
        return new LinkedList<T>(curHead);
    }

    private Node<T> getListToken(int count) {
        Node<T> list = head;
        while (count-- > 1 && head != null) {
            head = head.next;
        }
        Node<T> tmp = head;
        if(head != null){
            head = head.next;
            tmp.next = null;
        }
        return list;
    }


//    public LinkedList<T> reverse(int count) {
//        Node<T> prevList = head;
//        Node<T> newHead = null;
//        while(head != null){
//            Node<T> pre = null;
//            Node<T> cur = head;
//            int j = 0;
//            while (j < count && cur != null) {
//                cur = cur.next;
//                head.next = pre;
//                pre = head;
//                head = cur;
//                j++;
//            }
//            if(newHead == null){
//                newHead = pre;
//            }else{
//                prevList.next = pre;
//                pre = prevList;
//                prevList = head;
//            }
//        }
//        return new LinkedList<T>(newHead);
//    }


    public boolean detectLoop() {
        if (head == null) return false;
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null) {
            if (slow != null)
                slow = slow.next;
            if (fast != null && fast.next != null)
                fast = fast.next.next;
            if (slow.data.equals(fast.data)) {
                return true;
            }
        }
        return false;
    }

    public void resolveLoop() {
        if (head == null) return;
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null) {
            if (slow != null)
                slow = slow.next;
            if (fast != null && fast.next != null)
                fast = fast.next.next;
            if (slow.data.equals(fast.data)) {
                break;
            }
        }
        slow = head;
        if (slow.data.equals(fast.data)) {
            while (!slow.next.data.equals(fast.data)) {
                slow = slow.next;
            }
            slow.next = null;
        } else {
            while (!slow.next.data.equals(fast.next.data)) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
    }

    public boolean isPalindrome() {
        return isPalindromeUtil(this.head, new PointerWrapper(this.head));
    }

    private boolean isPalindromeUtil(Node<T> last, PointerWrapper first) {
        if (last == null) return true;
        boolean s = isPalindromeUtil(last.next, first);
        if (!s)
            return false;
        boolean status = last.data.equals(first.tNode.data);
        first.tNode = first.tNode.next;
        return status;
    }

    class ValueIndex {
        int index;

        public ValueIndex(int index) {
            this.index = index;
        }
    }

    class PointerWrapper<T> {
        Node<T> tNode;

        public PointerWrapper(Node<T> next) {
            this.tNode = next;
        }
    }
}
