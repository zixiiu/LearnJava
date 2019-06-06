import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        int[] testSet = new int[]{4,2,5,4,7,5,9,4,8,6,9,3,6,0};
//        int[] resSet;
//
//        QuickSort sol = new QuickSort();
//        resSet = sol.quickSort(testSet);
//        System.out.println(Arrays.toString(resSet));

        ListNode head = ListNode.fromArray(new int[]{1,2,3,4,5,6,7,8,9,10});
        System.out.println(head.toStringAfter());

        LinkedNode sol = new LinkedNode();
        ListNode newHead = sol.reorder(head);
        System.out.println(newHead.toStringAfter());

//        Stacks sol = new Stacks();
//        LinkedList<Integer> test = new LinkedList<Integer>();
//        test.push(1);
//        test.push(1);
//        test.push(2);
//        test.push(5);
//        test.push(3);
//        test.push(7);
//        test.push(8);
//        test.push(9);
//        sol.sort(test);

    }
}





