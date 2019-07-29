public class Exam2 {
    public int maxSum(TreeNode root) {
        int[] gMax = new int[]{Integer.MIN_VALUE};
        maxSumHelper(root, gMax);
        return gMax[0];
    }

    private int maxSumHelper(TreeNode root, int[] gMax) {
        if (root == null) {
            return 0;
        }
        int l = maxSumHelper(root.left, gMax);
        int r = maxSumHelper(root.right, gMax);
        if (root.left != null && root.right != null) {
            gMax[0] = gMax[0] < l + r + root.key ? l + r + root.key : gMax[0];
            return l > r ? l + root.key : r + root.key;
        }
        return root.left == null ? r + root.key : l + root.key;
    }

    public void test(int[] i) {
        i[0] += 1;
    }

    public int minCut(String s) {
        if(s.length() == 0) return 0;
        char[] sa = s.toCharArray();
        int[] m = new int[sa.length];
        // min cut of substring (0,i]
        m[0] = 0;
        for (int i = 1; i < m.length; i++) {
            if (isPali(sa, 0,i)){
                m[i] = 0;
                continue;
            }
            int lMin = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isPali(sa, j + 1, i)) {
                    lMin = lMin > m[j] + 1 ? m[j] + 1 : lMin;

                }
            }
            m[i] = lMin;
        }
        return m[m.length-1];
    }

    private boolean isPali(char[] si, int start, int stop) {
        //left right pointer, go inside at the same time, check each time
        int right = stop;
        int left = start;
        while (left <= right) {
            if (si[left] != si[right]) return false;
            left++;
            right--;
        }
        return true;
    }


}
