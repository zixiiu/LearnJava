import java.util.*;

public class RecurII {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        nqueensHelper(n, 0, res, new ArrayList<>(Collections.nCopies(n, 0)));
        return res;
    }

    private void nqueensHelper(int total, int current, List<List<Integer>> res, List<Integer> tmpRes) {
        if (current == total) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        Set<Integer> canNotPlaceQueen = new HashSet<>();
        for (int i = 0; i < current; i++) {
            int placeAt = tmpRes.get(i);
            canNotPlaceQueen.add(placeAt);
            canNotPlaceQueen.add(placeAt - (current - i));
            canNotPlaceQueen.add(placeAt + (current - i));
        }
        for (int i = 0; i < total; i++) {
            if (!canNotPlaceQueen.contains(i)) {
                tmpRes.set(current, i);
                nqueensHelper(total, current + 1, res, tmpRes);
            }
        }
    }

    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next.next;
        newHead = reverseInPairs(newHead);
        head.next.next = head;
        ListNode resHead = head.next;
        head.next = newHead;
        return resHead;
    }

    public int[][] spiralGenerate(int n) {
        int[][] res = new int[n][n];
        int curX = 0;
        int curY = 0;
        int cur = 1;
        int i;
        for (i = n; i >= 0; i -= 2) {
            for (int k = 0; k < i - 1; k++) {
                res[curY][curX] = cur;
                cur++;
                curX++;
            }
            for (int k = 0; k < i - 1; k++) {
                res[curY][curX] = cur;
                cur++;
                curY++;
            }
            for (int k = 0; k < i - 1; k++) {
                res[curY][curX] = cur;
                cur++;
                curX--;
            }
            for (int k = 0; k < i - 1; k++) {
                res[curY][curX] = cur;
                cur++;
                curY--;
            }
            curX++;
            curY++;
        }
        if (i == -1) res[curY - 1][curX - 1] = cur;
        return res;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        TreeNode res = LCAHelper(root, one, two);
        if (res == one) {
            if (LCAHelper(root, two, two) == two)
                return res;
            else return null;
        } else if (res == two) {
            if (LCAHelper(root, one, one) == two)
                return res;
            else return null;
        } else return res;
    }

    private TreeNode LCAHelper(TreeNode root, TreeNode one, TreeNode two) {
        if (root == one || root == two || root == null) return root;
        TreeNode leftRes = LCAHelper(root.left, one, two);
        TreeNode rightRes = LCAHelper(root.right, one, two);
        if (leftRes == null && rightRes == null) return null;
        if (leftRes == null) return rightRes;
        if (rightRes == null) return leftRes;
        return root;
    }

    public List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        spiralHelper(matrix, res, 0, matrix[0].length);
        return res;
    }

    private void spiralHelper(int[][] in, List<Integer> res, int offset, int length) {
        if (length == 0) return;
        if (length == 1) {
            res.add(in[offset][offset]);
            return;
        }
        int curY = offset;
        int curX = offset;
        for (int k = 0; k < length - 1; k++) {
            res.add(in[curY][curX]);
            curX++;
        }
        for (int k = 0; k < length - 1; k++) {
            res.add(in[curY][curX]);
            curY++;
        }
        for (int k = 0; k < length - 1; k++) {
            res.add(in[curY][curX]);
            curX--;
        }
        for (int k = 0; k < length - 1; k++) {
            res.add(in[curY][curX]);
            curY--;
        }
        spiralHelper(in, res, offset + 1, length - 2);
    }

    public List<Integer> spiralNonSquare(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        spiralNonSquareHelper(matrix, res, 0, matrix[0].length,matrix.length);
        return res;
    }

    private void spiralNonSquareHelper(int[][] in, List<Integer> res, int offset, int length, int height){
        if (length == 0) return;
        if (length == 1){
            res.add(in[offset][offset]);
            return;
        }
        int curY = offset;
        int curX = offset;
        for (int k = 0; k < length - 1; k++) {
            res.add(in[curY][curX]);
            curX ++;
        }
        for (int k = 0; k < height - 1; k++) {
            res.add(in[curY][curX]);
            curY ++;
        }
        for (int k = 0; k < length - 1; k++) {
            res.add(in[curY][curX]);
            curX --;
        }
        for (int k = 0; k < height - 1; k++) {
            res.add(in[curY][curX]);
            curY --;
        }
        spiralNonSquareHelper(in, res, offset+1, length - 2, height - 2);
    }

}

