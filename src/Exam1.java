import jdk.nashorn.api.tree.Tree;

import java.util.*;

public class Exam1 {
    //p1 reverse linked list
    //iter
    //Time O(n)
    //Space O(1)
    public ListNode reverseIter(ListNode head) {
        ListNode p = null;
        ListNode c = head;
        ListNode n = head.next;
        while (n != null) {
            c.next = p;
            p = c;
            c = n;
            n = n.next;
        }
        c.next = p;
        return c;
    }
    //Recur
    //Time O(n)
    //Space O(n)
    public ListNode reverseRecur(ListNode head) {
        if (head.next == null) return head;
        ListNode newHead = reverseRecur(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //p2 isBST
    //Time O(n)
    //Space O(n)
    public boolean isBST(TreeNode root) {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTHelper(TreeNode root, int left, int right) {
        if (root == null) return true;
        if (root.key <= left || root.key >= right) return false;
        return isBSTHelper(root.left, left, root.key) && isBSTHelper(root.right, root.key, right);
    }

    //p3 allPerm
    //Time O(n!)
    //Space O(n^2)
    public List<String> allPerm(String input) {
        List<String> res = new ArrayList<>();
        if (input == null || input.length() == 0) return res;
        char[] inputC = input.toCharArray();
        allPermHelper(inputC, 0, res, new StringBuilder());
        return res;
    }

    private void allPermHelper(char[] input, int validIndex, List<String> res, StringBuilder sb) {
        if (validIndex == input.length) {
            res.add(sb.toString());
            return;
        }
        Set<Character> visited = new HashSet<>();
        for (int i = validIndex; i < input.length; i++) {
            char curr = input[i];
            if (!visited.contains(curr)) {
                visited.add(curr);
                sb.append(curr);
                swap(input, i, validIndex);
                allPermHelper(input, validIndex + 1, res, sb);
                swap(input, i, validIndex);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }



    //removeSpace
    //Time O(n)
    //Space O(1)
    public String removeSpace(String input) {
        char[] inputC = input.toCharArray();
        int s = 0;
        for (int f = 0; f < inputC.length; f++) {
            if (inputC[f] == ' ' && (f == 0 || inputC[f - 1] == ' ')) {
                continue;
            }
            inputC[s] = inputC[f];
            s++;
        }
        if (s > 0 && inputC[s - 1] == ' ') {
            return new String(inputC, 0, s - 1);
        }
        return new String(inputC, 0, s);
    }

    //Q5
    //Time O(klogk)
    //Space O(m*n)
    class MapElement implements Comparable<MapElement> {
        int val;
        int x;
        int y;

        public MapElement(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(MapElement o) {
            if (this.val == o.val) return 0;
            return this.val < o.val ? -1 : 1;
        }
    }
    public int kTHsmallest(int[] A, int[] B, int k) {
        if(k == 0) return -1;

        Queue<MapElement> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[A.length][B.length];

        pq.offer(new MapElement(A[0]+B[0], 0, 0));
        visited[0][0] = true;
        for(int i = 1; i<k; i++){
            MapElement cur = pq.poll();
            if(cur.x + 1 < A.length && !visited[cur.x+1][cur.y]){
                pq.offer(new MapElement( A[cur.x+1]+ B[cur.y],cur.x+1,cur.y));
                visited[cur.x+1][cur.y] = true;
            }
            if(cur.y+1<B.length && !visited[cur.x][cur.y+1]){
                pq.offer(new MapElement( A[cur.x]+ B[cur.y+1],cur.x,cur.y+1));
                visited[cur.y][cur.x+1] = true;
            };
        }

        return pq.poll().val;
    }


    //Q5 Additional

    class kTHsmallPath implements Comparable<kTHsmallPath> {
        int sum;
        int visitedIndexA;
        int visitedIndexB;

        public kTHsmallPath(int sum, int visitedIndexA, int visitedIndexB) {
            this.sum = sum;
            this.visitedIndexA = visitedIndexA;
            this.visitedIndexB = visitedIndexB;
        }

        @Override
        public int compareTo(kTHsmallPath o) {
            if (this.sum == o.sum) return 0;
            return this.sum < o.sum ? -1 : 1;
        }
    }

    public int kTHsmallestsum(int[] A, int[] B, int k) {
        if (A.length == 0) return B[k];
        if (B.length == 0) return A[k];
        Queue<kTHsmallPath> pq = new PriorityQueue<>();
        pq.add(new kTHsmallPath(A[0], 1, 0));
        pq.add(new kTHsmallPath(B[0], 0, 1));
        int visitedNum = 0;
        kTHsmallPath cur = null;
        while (visitedNum < k) {
            cur = pq.poll();
            visitedNum = cur.visitedIndexA + cur.visitedIndexB;
            if (cur.visitedIndexA < A.length) {
                pq.add(new kTHsmallPath(cur.sum + A[cur.visitedIndexA], cur.visitedIndexA + 1, cur.visitedIndexB));
            }
            if (cur.visitedIndexB < B.length) {
                pq.add(new kTHsmallPath(cur.sum + B[cur.visitedIndexB], cur.visitedIndexA, cur.visitedIndexB + 1));
            }
        }
        return cur.sum;
    }

}
