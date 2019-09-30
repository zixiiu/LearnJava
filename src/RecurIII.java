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
        int lMax = leftMax > rightMax? leftMax + root.key: rightMax + root.key;

        gMax[0] = gMax[0] < lMax ? lMax : gMax[0];

        return leftMax + root.key > rightMax + root.key ? leftMax + root.key : rightMax + root.key;
        }


public int maxPathSumLeafToRoot(TreeNode root) {
        int leftMax = 0;
        int rightMax = 0;

        if(root.left != null) leftMax = maxPathSumLeafToRoot(root.left);
        if(root.right != null) rightMax = maxPathSumLeafToRoot(root.right);

        if(leftMax != 0 && rightMax == 0) return leftMax + root.key;
        if(leftMax == 0 && rightMax != 0) return rightMax + root.key;
        return leftMax + root.key > rightMax + root.key ? leftMax + root.key : rightMax + root.key;

        }
        }
