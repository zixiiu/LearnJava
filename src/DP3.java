public class DP3 {
    public int longest(int[] array) {
        if (array.length == 0 || array == null) return 0;
        int[] m = new int[array.length];
        m[0] = array[0];
        int gMax = array[0];
        for (int i = 1; i < m.length; i++) {
            if (array[i] == 1) m[i] = m[i - 1] + 1;
            else m[i] = 0;
            gMax = gMax < m[i] ? m[i] : gMax;
        }
        return gMax;
    }

    public int largestCross(int[][] matrix) {
        //pre
        int[][] m1 = new int[matrix.length][matrix[0].length];
        int[][] m2 = new int[matrix.length][matrix[0].length];
        int[][] m3 = new int[matrix.length][matrix[0].length];
        int[][] m4 = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) m1[i][j] = matrix[i][j];
                else if (matrix[i][j] == 1) m1[i][j] = m1[i][j - 1] + 1;
                else m1[i][j] = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (j == matrix[0].length - 1) m2[i][j] = matrix[i][j];
                else if (matrix[i][j] == 1) m2[i][j] = m2[i][j + 1] + 1;
                else m2[i][j] = 0;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == 0) m3[j][i] = matrix[j][i];
                else if (matrix[j][i] == 1) m3[j][i] = m3[j - 1][i] + 1;
                else m3[j][i] = 0;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                if (j == matrix.length - 1) m4[j][i] = matrix[j][i];
                else if (matrix[j][i] == 1) m4[j][i] = m4[j + 1][i] + 1;
                else m4[j][i] = 0;
            }
        }
        int gMax = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int gMin = m1[i][j];
                gMin = gMin > m2[i][j] ? m2[i][j] : gMin;
                gMin = gMin > m3[i][j] ? m3[i][j] : gMin;
                gMin = gMin > m4[i][j] ? m4[i][j] : gMin;
                gMax = gMax < gMin ? gMin : gMax;
            }
        }
        return gMax;
    }


    public int largestX(int[][] matrix) {
        if (matrix.length == 0) return 0;
        if (matrix[0].length == 0) return 0;

        int[][] m1 = new int[matrix.length][matrix[0].length];
        int[][] m2 = new int[matrix.length][matrix[0].length];
        int[][] m3 = new int[matrix.length][matrix[0].length];
        int[][] m4 = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0 || i == 0) m1[i][j] = matrix[i][j];
                else if (matrix[i][j] == 1) m1[i][j] = m1[i - 1][j - 1] + 1;
                else m1[i][j] = 0;
            }
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (j == matrix[0].length - 1 || i == matrix.length - 1) m2[i][j] = matrix[i][j];
                else if (matrix[i][j] == 1) m2[i][j] = m2[i + 1][j + 1] + 1;
                else m2[i][j] = 0;
            }
        }
        for (int i = matrix[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == 0 || i == matrix[0].length - 1) m3[j][i] = matrix[j][i];
                else if (matrix[j][i] == 1) m3[j][i] = m3[j - 1][i + 1] + 1;
                else m3[j][i] = 0;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                if (j == matrix.length - 1 || i == 0) m4[j][i] = matrix[j][i];
                else if (matrix[j][i] == 1) m4[j][i] = m4[j + 1][i - 1] + 1;
                else m4[j][i] = 0;
            }
        }
        int gMax = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int gMin = m1[i][j];
                gMin = gMin > m2[i][j] ? m2[i][j] : gMin;
                gMin = gMin > m3[i][j] ? m3[i][j] : gMin;
                gMin = gMin > m4[i][j] ? m4[i][j] : gMin;
                gMax = gMax < gMin ? gMin : gMax;
            }
        }
        return gMax;
    }


    public int largestSquareSurroundedByOne(int[][] matrix) {
        //pre
        int[][] m2 = new int[matrix.length][matrix[0].length];
        int[][] m4 = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (j == matrix[0].length - 1) m2[i][j] = matrix[i][j];
                else if (matrix[i][j] == 1) m2[i][j] = m2[i][j + 1] + 1;
                else m2[i][j] = 0;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                if (j == matrix.length - 1) m4[j][i] = matrix[j][i];
                else if (matrix[j][i] == 1) m4[j][i] = m4[j + 1][i] + 1;
                else m4[j][i] = 0;
            }
        }

        int gMax = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int gMin = m2[i][j] > m4[i][j] ? m4[i][j] : m2[i][j];
                for (int k = gMin; k > 0; k--) {
                    if (m2[i + gMin - 1][j] >= gMin && m4[i][j + gMin - 1] >= gMin) break;
                    gMin--;
                }
                gMax = gMax < gMin ? gMin : gMax;
            }
        }
        return gMax;
    }

    public int largestSquareOfMatches(int[][] matrix) {
        // MATCHes 1= right, 2= bot, 3= both 0= none
        int[][] m2 = new int[matrix.length][matrix[0].length];
        int[][] m4 = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (j == matrix[0].length - 1) m2[i][j] = 0;
                else if (matrix[i][j] == 1 || matrix[i][j] == 3) m2[i][j] = m2[i][j + 1] + 1;
                else m2[i][j] = 0;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                if (j == matrix.length - 1) m4[j][i] = 0;
                else if (matrix[j][i] == 2 || matrix[j][i] == 3) m4[j][i] = m4[j + 1][i] + 1;
                else m4[j][i] = 0;
            }
        }

        int gMax = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int gMin = m2[i][j] > m4[i][j] ? m4[i][j] : m2[i][j];
                for (int k = gMin; k >= 0; k--) {
                    if (k == 0) {
                        gMin = 0;
                        break;
                    }
                    if (m2[i + gMin][j] >= gMin && m4[i][j + gMin] >= gMin) break;
                    gMin--;
                }
                gMax = gMax < gMin ? gMin : gMax;
            }
        }
        return gMax;

    }

    public int largestSubmatrixSum(int[][] matrix) {
        int[][] m0 = new int[matrix.length + 1][matrix[0].length];
        for (int i = 0; i < matrix.length + 1; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) m0[i][j] = 0;
                else if (i == 1) m0[i][j] = matrix[i - 1][j];
                else m0[i][j] = m0[i - 1][j] + matrix[i - 1][j];
            }
        }
        int gMax = Integer.MIN_VALUE;
        for (int i = 0; i < m0.length; i++) {
            for (int j = i + 1; j < m0.length; j++) {
                int[] m = new int[matrix[0].length];
                for (int k = 0; k < matrix[0].length; k++) {
                    int curr = m0[j][k] - m0[i][k];
                    if (k == 0 || m[k - 1] < 0) m[k] = curr;
                    else m[k] = m[k - 1] + curr;
                    gMax = gMax < m[k] ? m[k] : gMax;
                }
            }

        }
        return gMax;
    }


}
