import java.util.HashMap;
import java.util.Map;

public class RecurIII {
    public int maxPathSum(TreeNode root) {
        int[] gMax = new int[1];
        gMax[0] = Integer.MIN_VALUE;
        maxPathSumHelper(root, gMax);
        return gMax[0];
    }

    private int maxPathSumHelper(TreeNode root, int[] gMax) {
        if (root == null) return 0;

        int leftMax = maxPathSumHelper(root.left, gMax);
        int rightMax = maxPathSumHelper(root.right, gMax);
        leftMax = leftMax < 0 ? 0 : leftMax;
        rightMax = rightMax < 0 ? 0 : rightMax;
        int lMax = leftMax + rightMax + root.key;

        gMax[0] = gMax[0] < lMax ? lMax : gMax[0];

        return leftMax + root.key > rightMax + root.key ? leftMax + root.key : rightMax + root.key;
    }

    public int maxPathSum2(TreeNode root) {
        int[] gMax = new int[1];
        gMax[0] = Integer.MIN_VALUE;
        maxPath2SumHelper(root, gMax);
        return gMax[0];
    }

    private int maxPath2SumHelper(TreeNode root, int[] gMax) {
        if (root == null) return 0;

        int leftMax = maxPath2SumHelper(root.left, gMax);
        int rightMax = maxPath2SumHelper(root.right, gMax);
        leftMax = leftMax < 0 ? 0 : leftMax;
        rightMax = rightMax < 0 ? 0 : rightMax;
        int lMax = leftMax > rightMax ? leftMax + root.key : rightMax + root.key;

        gMax[0] = gMax[0] < lMax ? lMax : gMax[0];

        return leftMax + root.key > rightMax + root.key ? leftMax + root.key : rightMax + root.key;
    }


    public int maxPathSumLeafToRoot(TreeNode root) {
        int leftMax = 0;
        int rightMax = 0;

        if (root.left != null) leftMax = maxPathSumLeafToRoot(root.left);
        if (root.right != null) rightMax = maxPathSumLeafToRoot(root.right);

        if (leftMax != 0 && rightMax == 0) return leftMax + root.key;
        if (leftMax == 0 && rightMax != 0) return rightMax + root.key;
        return leftMax + root.key > rightMax + root.key ? leftMax + root.key : rightMax + root.key;

    }


    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        int len = inOrder.length;
        Map<Integer, Integer> inIndex = new HashMap<>();
        for (int i = 0; i < len; i++) {
            inIndex.put(inOrder[i], i);
        }
        TreeNode res = reconstructHelper(inOrder, preOrder, 0, len - 1, 0, len - 1, inIndex);
        return res;

    }

    private TreeNode reconstructHelper(int[] inOrder, int[] preOrder, int startIn, int endIn, int startPre, int endPre, Map<Integer, Integer> inIndex) {
        //base case
        if (startPre > endPre) {
            return null;
        }
        if (startIn == endIn) {
            return new TreeNode(inOrder[startIn]);
        }


        TreeNode cur = new TreeNode(preOrder[startPre]);
        int curIn = inIndex.get(preOrder[startPre]);
        cur.left = reconstructHelper(inOrder, preOrder, startIn, curIn - 1, startPre + 1, startPre + curIn - startIn, inIndex);
        cur.right = reconstructHelper(inOrder, preOrder, curIn + 1, endIn, startPre + curIn - startIn + 1, endPre, inIndex);
        return cur;
    }
}
