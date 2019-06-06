import java.util.List;

class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        next = null;
    }
    public String toStringAfter(){
        String ret = "[ ";
        ret += this.value;
        ret += " -> ";
        ListNode cur = this.next;
        while(cur != null){
            ret += cur.value;
            ret += " -> ";
            //if(cur.next == null){break;}
            cur = cur.next;
        }
        ret += "null ]";
        return ret;
    }
    public static ListNode fromArray(int[] array){
        ListNode head = new ListNode(array[0]);
        ListNode cur = head;
        for (int i = 1; i<array.length; i++){
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        return head;
    }
}

public class LinkedNode {
    public ListNode reverse(ListNode head) {
        if (head == null){
            return null;
        }else if(head.next == null){
            return head;
        }
        ListNode p = null;
        ListNode c = head;
        ListNode n = head.next;
        while (true){
            c.next = p;
            //update
            p = c;
            if (n == null){break;}
            c = n;
            n = n.next;
        }
        return p;
    }

    public ListNode merge(ListNode one, ListNode two) {
        // Write your solution here
        ListNode dummy = new ListNode(123);
        ListNode curDummy = dummy;
        ListNode curOne = one;
        ListNode curTwo = two;
        while(curOne != null && curTwo != null){
            if(curOne.value < curTwo.value){
                curDummy.next = curOne;
                curOne= curOne.next;
            }else{
                curDummy.next = curTwo;
                curTwo= curTwo.next;
            }
            curDummy = curDummy.next;
        }
        if (curOne == null){
            curDummy.next = curTwo;
        }else{
            curDummy.next = curOne;
        }
        return dummy.next;
    }



    public ListNode reorder(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // find mid
        ListNode mid = middleNode(head);
        //devide
        ListNode fr = head;
        ListNode bk = mid.next;
        mid.next = null;
//        System.out.println(mid.toStringAfter());
//        System.out.println(fr.toStringAfter());
//        System.out.println(bk.toStringAfter());
        //reverse
        bk = reverse(bk);

        //merge
        ListNode newHead = mergeRegardless(fr,bk);
        return newHead;
    }
    public ListNode middleNode(ListNode head) {

        ListNode cur1 = head;
        ListNode cur2 = head;

        if(head == null || head.next == null){
            return head;
        }

        while(cur2.next != null && cur2.next.next != null){
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        return cur1;

    }

    public ListNode mergeRegardless(ListNode one, ListNode two) {
        // Write your solution here
        ListNode dummy = new ListNode(123);
        ListNode curDummy = dummy;
        ListNode curOne = one;
        ListNode curTwo = two;
        while(curOne != null && curTwo != null){
            curDummy.next = curOne;
            curOne= curOne.next;
            curDummy.next.next = curTwo;
            curTwo= curTwo.next;
            curDummy = curDummy.next.next;
        }
        if (curOne == null){
            curDummy.next = curTwo;
        }else{
            curDummy.next = curOne;
        }
        return dummy.next;
    }


}

