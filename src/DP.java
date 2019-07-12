import java.lang.invoke.LambdaMetafactory;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DP {
    public long fibonacci(int K) {
        if (K <= 0) return 0;
        if (K == 0) return 0;
        if (K == 1) return 1;
        long prev1 = 0;
        long prev2 = 1;
        long curr = 0;
        for (int i = 1; i < K; i++) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }

    //Longest Ascending Subarray
    public int longest(int[] array) {
        int[] m = new int[array.length];
        int max = 0;
        for (int i = 0; i < m.length; i++) {
            if (i == 0) m[i] = 1;
            else m[i] = array[i] > array[i - 1] ? m[i - 1] + 1 : 1;
            if (max < m[i]) max = m[i];
        }
        return max;
    }


    public int maxProduct(int length) {
        int[] m = new int[length + 1];

        for (int i = 0; i < m.length; i++) {
            if (i == 0) m[i] = 0;
            else if (i == 1) m[i] = 0;
            else if (i == 2) m[i] = 1;
            else {
                int max = 0;
                for (int j = 2; j < i; j++) {//cut in middle
                    int tmp = m[j] * (i - j);
                    if (tmp > max) max = tmp;
                    tmp = (i - j) * j;
                    if (tmp > max) max = tmp;
                }
                //if (i > max) max = i;//no cut in middle
                m[i] = max;
            }
        }
        return m[length];
    }


    public boolean canJump(int[] array) {
        boolean[] m = new boolean[array.length];
        for (int i = m.length - 1; i >= 0; i--) {
            if (i == m.length - 1) m[i] = true;
            else {
                for (int j = i; j <= array[i] + i; j++) {
                    if (m[j] == true) {
                        m[i] = true;
                        break;
                    }
                }
            }
        }
        return m[0];
    }

    public int minJump(int[] array) {
        int[] m = new int[array.length];
        for (int i = m.length - 1; i >= 0; i--) {
            if (array[i] == 0) m[i] = -1;
            else {
                if (i == m.length - 1) m[i] = 1;
                else if (array[i] + i >= array.length) m[i] = 1;
                else {
                    int localMin = Integer.MAX_VALUE;
                    for (int j = i + 1; j <= array[i] + i; j++) {
                        if (m[j] != -1) {
                            if (m[j] < localMin) {
                                localMin = m[j];
                            }
                        }
                    }
                    m[i] = localMin == Integer.MAX_VALUE ? -1 : localMin + 1;
                }
            }
        }
        return m[0];
    }

    public int minJumpLast(int[] array) {
        int[] m = new int[array.length];
        for (int i = m.length - 1; i >= 0; i--) {
            if (i == m.length - 1) m[i] = 0;
            else {
                if (array[i] == 0) m[i] = -1;
                int localMin = Integer.MAX_VALUE;
                for (int j = i + 1; j < array.length && j <= array[i] + i; j++) {
                    if (m[j] != -1) {
                        if (m[j] < localMin) {
                            localMin = m[j];
                        }
                    }
                }
                m[i] = localMin == Integer.MAX_VALUE ? -1 : localMin + 1;
            }

        }
        return m[0];
    }

    public int largestSum(int[] array) {
        int[] m = new int[array.length];
        m[0] = array[0];
        int globalMax = m[0];
        for (int i = 1; i < m.length; i++) {
            if (m[i - 1] < 0) m[i] = array[i];
            else m[i] = m[i - 1] + array[i];
            if (m[i] > globalMax) globalMax = m[i];
        }
        return globalMax;
    }

    public boolean canBreak(String input, String[] dict) {
        Set<String> dictSet = new HashSet<>(Arrays.asList(dict));
        boolean[] m = new boolean[input.length() + 1];
        m[0] = true;
        for (int i = 1; i < input.length() + 1; i++) {
            boolean curr = false;
            String sub = input.substring(0, i);
            for (int j = 0; j <= i; j++) {
                String subSub = sub.substring(j);
                curr = curr || (m[j] && dictSet.contains(subSub));
            }
            m[i] = curr;
        }
        return m[input.length()];
    }

    public int editDistance(String one, String two) {
        int[][] m = new int[one.length() + 1][two.length() + 1];
        for (int i = 0; i < one.length() + 1; i++) {
            for (int j = 0; j < two.length() + 1; j++) {
                if (i == 0) m[i][j] = j;
                else if (j == 0) m[i][j] = i;
                else if (one.charAt(i - 1) == two.charAt(j - 1)) m[i][j] = m[i - 1][j - 1];
                else {
                    int localMin = m[i - 1][j - 1];
                    if (m[i - 1][j] < localMin) localMin = m[i - 1][j];
                    if (m[i][j - 1] < localMin) localMin = m[i][j - 1];
                    m[i][j] = localMin + 1;
                }
            }
        }
        return m[one.length()][two.length()];
    }

    public int largest(int[][] matrix) {
        int[][] m = new int[matrix.length][matrix[0].length];
        int globalMax = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) m[i][j] = matrix[i][j];
                else if (matrix[i][j] == 0) m[i][j] = 0;
                else {
                    int localMin = m[i - 1][j - 1];
                    if (m[i - 1][j] < localMin) localMin = m[i - 1][j];
                    if (m[i][j - 1] < localMin) localMin = m[i][j - 1];
                    m[i][j] = localMin + 1;
                }
                globalMax = m[i][j] > globalMax ? m[i][j] : globalMax;
            }
        }
        return globalMax;
    }

    public int maxProfit(int[] array) {
        int[] m = new int[array.length];
        m[0] = 0;
        int gMax = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < (array[i - 1] - m[i - 1])) m[i] = 0;
            else m[i] = m[i - 1] + (array[i] - array[i - 1]);
            gMax = gMax < m[i] ? m[i] : gMax;
        }
        return gMax;
    }

    public int maxProfit2(int[] array) {
        int[] m = new int[array.length];
        m[0] = 0;
        int gMax = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) m[i] = gMax;
            else m[i] = m[i - 1] + (array[i] - array[i - 1]);
            gMax = gMax < m[i] ? m[i] : gMax;
        }
        return gMax;
    }

    public int maxProfit3(int[] array) {
        int[][] m = new int[array.length][array.length];
        int gMax = 0;

        for (int i = 0; i < array.length; i++) {
            int lMax = 0;
            for (int j = i; j < array.length; j++) {
                if (i == j) m[i][j] = 0;
                else if (array[j] < (array[j - 1] - m[i][j - 1])) m[i][j] = 0;
                else m[i][j] = m[i][j - 1] + (array[j] - array[j - 1]);
                lMax = lMax < m[i][j] ? m[i][j] : lMax;
            }
            gMax = gMax < m[0][i] + lMax ? m[0][i] + lMax : gMax;
        }
        return gMax;
    }


}
