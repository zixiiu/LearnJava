import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int testNo = 7;
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
        }else if(testNo == 5){//binary tree
//            TreeNode root = new TreeNode(1);
//            root.left = new TreeNode(1);
//            root.right = new TreeNode(4);
//            root.left.left = new TreeNode(5);
//            root.left.right = new TreeNode(1);
//            root.right.left = new TreeNode(4);
            BinaryTree sol = new BinaryTree();
            TreeNode root = TreeNode.fromArrayBalanced(new Integer[]{7,3,6,2,5,11,18,1,4,6,12,20});
            System.out.println(root.toStringAfter());
            System.out.println(sol.isBalenced(root));
            System.out.println(sol.isSymmetric(root));
            System.out.println(sol.isTweakedIdentical(root,root));
            System.out.println(sol.isBST(root));
        }else if(testNo == 6){
            TreeNode root = TreeNode.fromArrayBalanced(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
            BinaryTree sol = new BinaryTree();
            System.out.println(root.toStringAfter());
            sol.preOrderTravRecur(root);
            System.out.println("(pre,recur");
            sol.preOrderTravIter(root);
            System.out.println("(pre,iter");
            sol.inOrderTravRecur(root);
            System.out.println("(in,recur");
            sol.inOrderTravIter(root);
            System.out.println("(in,iter");
            sol.postOrderTravRecur(root);
            System.out.println("(post,recur");
            sol.postOrderTravIter(root);
            System.out.println("(post,iter");

        }else if(testNo == 7){
            DFS sol = new DFS();
            //int[] res = sol.coinSelection(99);
            List<String> ressubset = sol.subSets("ABC");
            //System.out.println(ressubset.toArray().toString());
            List<List<Integer>> coinRes = sol.combinations(99, new int[]{25,10,5,2});
            System.out.println(coinRes.toString());
            List<String> resPr = sol.validParentheses(3);
            System.out.println(resPr.toString());
            List<String> resPer = sol.permutations("abc");
            System.out.println(resPer.toString());



        }else if(testNo == 8){
            BFS sol = new BFS();
            int[] test = new int[]{7,4,8,6,9,3,7,5,9,7};
            int[] res = sol.kSmallest(test, 2);
            System.out.println(Arrays.toString(res));
            TreeNode root = TreeNode.fromArrayBalanced(new Integer[]{2,1,3});
            sol.layerByLayer(root);

            int[][] testMat = new int[][]{{1,3,5,7},{2,4,8,9},{3,5,11,15},{6,8,13,18}};
            sol.kthSmallest(testMat, 6);

            List<GraphNode> testGraph = new ArrayList<>();
            GraphNode node1 = new GraphNode(0);
            GraphNode node2 = new GraphNode(1);
            node1.neighbors.add(node2);
            node2.neighbors.add(node1);
            testGraph.add(node1);
            testGraph.add(node2);
            System.out.println(sol.isBipartiteIter(testGraph));
        }else if(testNo == 9){

        }

    }
}





