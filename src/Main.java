import java.util.*;


public class Main {

    public static void main(String[] args) {
        int testNo = 19;
        if (testNo == 1) { //QuickSort
            int[] testSet = new int[]{4, 2, 5, 4, 7, 5, 9, 4, 8, 6, 9, 3, 6, 0};
            int[] resSet;

            QuickSort sol = new QuickSort();
            resSet = sol.quickSort(testSet);
            System.out.println(Arrays.toString(resSet));
        } else if (testNo == 2) {//Single LinkedList
            ListNode head = ListNode.fromArray(new int[]{2, 7, 5, 9, 4, 8, 6, 9, 1, 35, 5, 6});
            System.out.println(head.toStringAfter());

            LinkedNode sol = new LinkedNode();
            ListNode newHead = sol.mergeSort(head);
            System.out.println(newHead.toStringAfter());
        } else if (testNo == 3) {//Two LinkedList
            LinkedNode sol = new LinkedNode();
            ListNode l1 = ListNode.fromArray(new int[]{9, 9, 9, 9});
            ListNode l2 = ListNode.fromArray(new int[]{1, 1});
            ListNode resAdd = sol.addTwoNumbers(l1, l2);
            System.out.println(resAdd.toStringAfter());
        } else if (testNo == 4) { //stack
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
        } else if (testNo == 5) {//binary tree
//            TreeNode root = new TreeNode(1);
//            root.left = new TreeNode(1);
//            root.right = new TreeNode(4);
//            root.left.left = new TreeNode(5);
//            root.left.right = new TreeNode(1);
//            root.right.left = new TreeNode(4);
            BinaryTree sol = new BinaryTree();
            TreeNode root = TreeNode.fromArrayBalanced(new Integer[]{7, 3, 6, 2, 5, 11, 18, 1, 4, 6, 12, 20});
            System.out.println(root.toStringAfter());
            System.out.println(sol.isBalenced(root));
            System.out.println(sol.isSymmetric(root));
            System.out.println(sol.isTweakedIdentical(root, root));
            System.out.println(sol.isBST(root));
        } else if (testNo == 6) {
            TreeNode root = TreeNode.fromArrayBalanced(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
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

        } else if (testNo == 7) {
            DFS sol = new DFS();
            //int[] res = sol.coinSelection(99);
            List<String> ressubset = sol.subSets("ABC");
            //System.out.println(ressubset.toArray().toString());
            List<List<Integer>> coinRes = sol.combinations(99, new int[]{25, 10, 5, 2});
            System.out.println(coinRes.toString());
            List<String> resPr = sol.validParentheses(3);
            System.out.println(resPr.toString());
            List<String> resPer = sol.permutations("abc");
            System.out.println(resPer.toString());


        } else if (testNo == 8) {
            BFS sol = new BFS();
            int[] test = new int[]{7, 4, 8, 6, 9, 3, 7, 5, 9, 7};
            int[] res = sol.kSmallest(test, 2);
            System.out.println(Arrays.toString(res));
            TreeNode root = TreeNode.fromArrayBalanced(new Integer[]{2, 1, 3});
            sol.layerByLayer(root);

            int[][] testMat = new int[][]{{1, 3, 5, 7}, {2, 4, 8, 9}, {3, 5, 11, 15}, {6, 8, 13, 18}};
            sol.kthSmallest(testMat, 6);

            List<GraphNode> testGraph = new ArrayList<>();
            GraphNode node1 = new GraphNode(0);
            GraphNode node2 = new GraphNode(1);
            node1.neighbors.add(node2);
            node2.neighbors.add(node1);
            testGraph.add(node1);
            testGraph.add(node2);
            System.out.println(sol.isBipartiteIter(testGraph));
        } else if (testNo == 9) {
            StringProbs sol = new StringProbs();
            String[] test = new String[]{"a", "a", "b"};
            String[] res = sol.topKFrequent(test, 2);
            //System.out.println(Arrays.toString(res));
            //System.out.println(sol.remove("abcde","cd"));
            //System.out.println(sol.removeSpaces("   "));
            //System.out.println(sol.deDup("abbbccd"));
            //System.out.println(sol.deDup2NoStack("aabccdc"));
            System.out.println(sol.replace("abcdefghicdeasfwecdeaweasc", "cde", "xxxx"));
            //System.out.println(sol.allOccurance("abcdefghicdeasfwecdeaweasc", "cde"));
            System.out.println(Arrays.toString(sol.reorder(new int[]{1, 2, 3, 4, 5, 6, 7, 8})));
            System.out.println(sol.compress("aaaabbbbccccddde"));
            System.out.println(sol.decompress("a4b4c4d4"));
            sol.allAnagrams("ababacbbaac", "aab");


        } else if (testNo == 10) {
            HashProbs sol = new HashProbs();
            List<Integer> commonTest1 = Arrays.asList(1, 1, 2, 3);
            List<Integer> commonTest2 = Arrays.asList(1, 1, 1, 1, 1, 2, 3);
            List<Integer> res = sol.commonHashMap(commonTest1, commonTest2);
            System.out.println(res);

        } else if (testNo == 11) { //bit
            Bit sol = new Bit();
            sol.allUnique("lodqomabca");
            sol.hex(15);
            LinkedNode sol2 = new LinkedNode();
            ListNode head = ListNode.fromArray(new int[]{2, 7, 5, 9, 4, 8, 6, 9, 1, 35, 5, 6});
            ListNode res = sol2.reverseRecu(head);
            //System.out.println(res.toStringAfter());

        } else if (testNo == 12) {//exam1
            Exam1 sol = new Exam1();
            ListNode head = ListNode.fromArray(new int[]{2, 7, 5, 9, 4, 8, 6, 9, 1, 35, 5, 6});
            ListNode res = sol.reverseIter(head);
            System.out.println(res.toStringAfter());
            head = ListNode.fromArray(new int[]{2, 7, 5, 9, 4, 8, 6, 9, 1, 35, 5, 6});
            res = sol.reverseRecur(head);
            System.out.println(res.toStringAfter());
            System.out.println(sol.kTHsmallest(new int[]{1, 3, 5}, new int[]{2, 3, 4}, 6));
            System.out.println(sol.removeSpace("     I love   yahoo    "));
        } else if (testNo == 13) {//recur2
            RecurII sol = new RecurII();
            sol.nqueens(1);
            sol.spiralGenerate(6);
            TreeNode root = TreeNode.fromArrayBalanced(new Integer[]{7, 3, 6, 2, 5, 11, 18, 1, 4, 6, 12, 20});
            sol.lowestCommonAncestor(root, root.left.left.left, root.left.left.right);
        } else if (testNo == 14) {//dp
            DP sol = new DP();
            sol.fibonacci(2);
            sol.longest(new int[]{4, 3, 2, 1});
            sol.maxProduct(25);
            sol.canJump(new int[]{1, 1, 6, 1, 1});
            sol.minJumpLast(new int[]{4, 2, 1, 3, 2, 1, 1, 4});
            sol.largestSum(new int[]{1, 2, -3});
            sol.canBreak("bcdbcdabc", new String[]{"abc", "bcd", "def"});
            sol.editDistance("abcde", "efghi");
            sol.largest(new int[][]{{0, 1}, {1, 0}});
            sol.maxProfit3(new int[]{3, 4, 1, 2, 6, 2, 3, 5, 1, 7, 3, 8});
        } else if (testNo == 15) {
            DP3 sol = new DP3();
            sol.largestCross(new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 0}, {0, 0, 0, 1, 1}});
            sol.largestX(new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 0}, {0, 0, 0, 1, 1}});
            sol.largestSquareOfMatches(new int[][]{{1, 1}, {1, 2}, {2, 0}, {3, 1}, {3, 0}, {1, 1}, {1, 2}, {0, 0}});
            sol.largestSubmatrixSum(new int[][]{{-4, 2, -1, 0, 2}, {2, 3, 2, 1, -3}, {-3, -3, -2, 2, 4}, {1, 1, 2, -2, 5}, {-4, 0, 1, 1, -4}});
            int a = 1162261467;
            System.out.println(a * 2);
            Exam2 t2 = new Exam2();
            int[] b = new int[]{20};
            t2.test(b);
            System.out.println(b[0]);
            t2.minCut("aaaaaabbabb");


        } else if(testNo == 16){
            CrossTrainingI sol = new CrossTrainingI();
            sol.zigZag(TreeNode.fromArrayBalanced(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));


        } else if(testNo == 17) {//Xtrain2
            CrossTrainingII sol = new CrossTrainingII();
//            RandomListNode test1 = new RandomListNode(1);
//            RandomListNode test2 = new RandomListNode(2);
//            RandomListNode test3 = new RandomListNode(3);
//            RandomListNode test4 = new RandomListNode(4);
//            RandomListNode test5 = new RandomListNode(5);
//            test1.next = test2;
//            test1.random = test1;
//            test2.next = test3;
//            test2.random = test2;
//            test3.next = test4;
//            test3.random = test3;
//            test4.next = test5;
//            test4.random = test4;
//            test5.random = test5;
//            sol.copy(test1);


            sol.allPairs(new int[]{3,1,9,2,3}, 4);
        }else if(testNo == 18){//exam3
            Exam3 sol = new Exam3();
            sol.addSpace("abcdef");
        } else if (testNo == 19) {//DFS2
            DFSII sol = new DFSII();
            sol.combinations(12);
        }



    }
}




