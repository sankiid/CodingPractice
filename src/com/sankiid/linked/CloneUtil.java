package com.sankiid.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sandeep on 11/2/17.
 */
public class CloneUtil {
    public static void main(String[] args) {
        NodeWithRandomPointer<Integer> head = new NodeWithRandomPointer<Integer>(10);
        head.next = new NodeWithRandomPointer<Integer>(20);
        head.next.next = new NodeWithRandomPointer<Integer>(30, null, head);
        head.next.random = head.next.next;
        System.out.println();

        NodeWithRandomPointer<Integer> cloneHead = clone(head);
        System.out.println();
    }

    private static NodeWithRandomPointer<Integer> clone(NodeWithRandomPointer<Integer> head) {
        NodeWithRandomPointer<Integer> tmp = head;
        NodeWithRandomPointer<Integer> clonedHead = null;
        NodeWithRandomPointer<Integer> tail = null;
        Map<NodeWithRandomPointer<Integer>, NodeWithRandomPointer<Integer>> map = new HashMap<NodeWithRandomPointer<Integer>, NodeWithRandomPointer<Integer>>();
        while (tmp != null) {
            NodeWithRandomPointer<Integer> node = new NodeWithRandomPointer<Integer>(tmp.data);
            if (clonedHead == null) {
                clonedHead = node;
            } else {
                tail.next = node;
            }
            map.put(tmp, node);
            tail = node;
            tmp = tmp.next;
        }

        tmp = head;
        while(tmp != null){
            NodeWithRandomPointer<Integer> ran = tmp.random;
            NodeWithRandomPointer<Integer> n1 = map.get(tmp);
            NodeWithRandomPointer<Integer> n2 = map.get(ran);
            n1.random = n2;
            tmp = tmp.next;
        }
        return clonedHead;
    }
}
