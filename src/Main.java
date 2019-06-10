import jdk.nashorn.api.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int testNo = 5;
        if(testNo == 1){ //QuickSort
            int[] testSet = new int[]{4,2,5,4,7,5,9,4,8,6,9,3,6,0};
            int[] resSet;

            QuickSort sol = new QuickSort();
            resSet = sol.quickSort(testSet);
            System.out.println(Arrays.toString(resSet));
        }else if(testNo == 2) {//Single LinkedList
            ListNode head = ListNode.fromArray(new int[]{2,7,5,9,4,8,6,9,1,35,5,6});
            System.out.println(head.toStringAfter());

            LinkedNode sol = new LinkedNode();
            ListNode newHead = sol.mergeSort(head);
            System.out.println(newHead.toStringAfter());
        }else if(testNo == 3) {//Two LinkedList
            LinkedNode sol = new LinkedNode();
            ListNode l1 = ListNode.fromArray(new int[]{9, 9, 9, 9});
            ListNode l2 = ListNode.fromArray(new int[]{1, 1});
            ListNode resAdd = sol.addTwoNumbers(l1, l2);
            System.out.println(resAdd.toStringAfter());
        }else if(testNo == 4) { //stack
            Stacks sol = new Stacks();
            LinkedList<Integer> test = new LinkedList<>();
            test.push(9);
            test.push(6);
            test.push(2);
            test.push(2);
            test.push(5);
            test.push(3);
            test.push(2);
            test.push(7);
            test.push(6);
            test.push(4);
            test.push(1);
            sol.sortWithTwo(test);
            System.out.println(test.toString());
        }else if(testNo == 5){
//            TreeNode root = new TreeNode(1);
//            root.left = new TreeNode(1);
//            root.right = new TreeNode(4);
//            root.left.left = new TreeNode(5);
//            root.left.right = new TreeNode(1);
//            root.right.left = new TreeNode(4);
            BinaryTree sol = new BinaryTree();
            TreeNode root = TreeNode.fromArrayBalanced(new Integer[]{6,4,10,2,5,6,12});
            System.out.println(root.toStringAfter());
            System.out.println(sol.isBalenced(root));
            System.out.println(sol.isSymmetric(root));
            System.out.println(sol.isTweakedIdentical(root,root));
            System.out.println(sol.isBST(root));
        }

    }
}





