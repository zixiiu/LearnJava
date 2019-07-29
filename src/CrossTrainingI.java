import jdk.nashorn.api.tree.Tree;

import java.util.*;

public class CrossTrainingI {
    // Array Dedup 1
    public int[] dedup(int[] array) {
        if (array.length == 0 || array == null) return array;
        int s = 1, f = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[f] == array[s - 1]) {
                f++;
            } else {
                array[s] = array[f];
                f++;
                s++;
            }
        }
        return Arrays.copyOfRange(array, 0, s);
    }

    // Dedup 2, keep 2 at most.
    public int[] dedup2(int[] array) {
        if (array.length < 3 || array == null) return array;
        int s = 2, f = 2;
        for (int i = 2; i < array.length; i++) {
            if (array[f] == array[s - 2]) {
                f++;
            } else {
                array[s] = array[f];
                f++;
                s++;
            }
        }
        return Arrays.copyOfRange(array, 0, s);
    }

    // do not keep any dedup.
    public int[] dedup3(int[] array) {
        int s = 0, f = 0, next = 0;
        while (f < array.length) {
            while (next < array.length && array[next] == array[f]) {
                next++;
            }
            if (next == f + 1) {
                array[s] = array[f];
                f++;
                s++;
            }
            f = next;

        }
        return Arrays.copyOfRange(array, 0, s);
    }

    //zuma
    public int[] dedup4(int[] array) {
        int s = 0, f = 0;
        while (f < array.length) {
            if (s != 0 && array[s - 1] == array[f]) {
                while (f < array.length && array[f] == array[s - 1]) {
                    f++;
                }
                s--;
            } else {
                array[s] = array[f];
                s++;
                f++;
            }
        }
        return Arrays.copyOfRange(array, 0, s);
    }

    //move zero to end 2
    public int[] moveZero(int[] array) {
        int s = 0, f = 0;
        while (f < array.length) {
            if (array[f] == 0) {
                f++;
            } else {
                array[s] = array[f];
                s++;
                f++;
            }
        }
        while (s < array.length) {
            array[s] = 0;
            s++;
        }
        return array;
    }

    // 2N
    public int[] largestAndSmallest(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            max = max < array[i] ? array[i] : max;
            min = min > array[i] ? array[i] : min;
        }
        return new int[]{max, min};
    }
    //zigzag binary tree trav
    public List<Integer> zigZag(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        while(!q.isEmpty()){
            int s = q.size();
            for(int i = 0; i < s; i++){ //odd
                TreeNode cur = q.pollLast();
                res.add(cur.key);
                if(cur.right != null) q.offerFirst(cur.right);
                if(cur.left != null) q.offerFirst(cur.left);
            }
            s = q.size();
            for(int i = 0; i < s; i++) { //odd
                TreeNode cur = q.pollFirst();
                res.add(cur.key);
                if(cur.left != null) q.offerLast(cur.left);
                if(cur.right != null) q.offerLast(cur.right);
            }
        }
        return res;
    }

    // LCA, multiple points.
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        if(root == null) return null;
        TreeNode l = lowestCommonAncestor(root.left, nodes);
        TreeNode r = lowestCommonAncestor(root.right, nodes);
        if(l != null && r != null) return root;
        if(l == null && r == null && nodes.contains(root)) return root;
        return r == null? l:r;
    }
}
