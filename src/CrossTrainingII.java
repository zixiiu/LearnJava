import java.util.Random;

public class CrossTrainingII {
    public int[] countArray(int[] array) {
        if (array.length == 0 || array == null) {
            return array;
        }
        int[] res = new int[array.length];
        int[] index = new int[array.length];
        for (int i = 0; i < index.length; i++) index[i] = i;
        countArrayHelper(array, 0, array.length - 1, res, index);
        return res;
    }

    private int[] countArrayHelper(int[] array, int left, int right, int[] res, int[] index) {
        if (left == right) {
            return array;
        }
        int mid = (left + right) / 2 + 1;
        countArrayHelper(array, left, mid - 1, res, index);
        countArrayHelper(array, mid, right, res, index);
        merge(array, left, mid, right, res, index);

        return res;
    }

    public void merge(int[] array, int left, int mid, int right, int[] res, int[] index) {
        int indexLeft = left;
        int indexRight = mid;
        int indexRes = left;
        int[] helper = new int[array.length];
        for (int i = left; i <= right; i++) {
            helper[i] = index[i];
        }
        while (indexLeft <= mid - 1 && indexRight <= right) {
            if (array[helper[indexLeft]] < array[helper[indexRight]]) {
                index[indexRes] = helper[indexLeft];
                res[index[indexRes]] += indexRight - mid;
                indexLeft += 1;
            } else {
                index[indexRes] = helper[indexRight];
                indexRight += 1;
            }
            indexRes += 1;
        }
        for (int i = indexLeft; i < mid; i++) {
            index[indexRes] = helper[i];
            res[index[indexRes]] += indexRight - mid;
            indexRes += 1;
        }
        for (int i = indexRight; i <= right; i++) {
            index[indexRes] = helper[i];
            indexRes += 1;
        }
    }


    //QUICKSORT
    public int[] countArrayQuick(int[] array) {
        if (array.length == 0 || array == null) {
            return array;
        }
        int[] res = new int[array.length];
        int[] index = new int[array.length];
        for (int i = 0; i < index.length; i++) index[i] = i;
        quickSort(array, 0, array.length - 1, res, index);
        return res;
    }

    private void quickSort(int[] array, int left, int right, int[] res, int[] index) {
        if (left >= right) {
            return;
        }

        Random rand = new Random();
        int mid = left + rand.nextInt(right - left + 1);
        int newMid = partition(array, mid, left, right, res, index);

        quickSort(array, left, newMid - 1, res, index);
        quickSort(array, newMid + 1, right, res, index);

    }


    public int partition(int[] array, int pivotIndex, int left, int right, int[] res, int[] index) {
        int cur = left + 1;
        int compareVal = array[index[pivotIndex]];
        swap(index, left, pivotIndex);
        for(int i = pivotIndex; i <= left; i--) res[index[i]] ++;
        pivotIndex = left;

        while (cur <= right) {
            if (array[index[cur]] < compareVal) {
                swap(index, cur, pivotIndex);
                res[index[pivotIndex]] ++;
                res[index[cur]] --;
                pivotIndex = cur;
                cur++;
            } else {
                swap(index, cur, right);
                right--;
            }
        }
        return pivotIndex;
    }

    public void swap(int[] array, int i, int j) {
        // Write your solution here
        int mem;
        mem = array[j];
        array[j] = array[i];
        array[i] = mem;

    }

}
