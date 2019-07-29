import java.util.Random;
public class RecurI {
    public int[] mergeSort(int[] array) {
        if (array.length == 0 || array == null) {
            return array;
        }
        mergeSort(array, 0, array.length-1);
        return array;
    }

    private int[] mergeSort(int[] array, int left, int right) {
        if (left == right){
            return array;
        }
        int mid = (left + right) / 2 +1;
        mergeSort(array, left, mid - 1);
        mergeSort(array, mid, right);
        merge(array, left, mid, right);

        return array;
    }

    public int[] merge(int[] array, int left, int mid, int right) {
        int indexAr1 = left;
        int indexAr2 = mid;
        int indexRes = left;
        int[] helper = new int[array.length];
        for (int i = left; i<=right; i++){
            helper[i] = array[i];
        }
        while (indexAr1 <= mid - 1 && indexAr2 <= right) {
            if (helper[indexAr1] < helper[indexAr2]) {
                array[indexRes] = helper[indexAr1];
                indexAr1 += 1;
            } else {
                array[indexRes] = helper[indexAr2];
                indexAr2 += 1;
            }
            indexRes += 1;
        }
        for (int i = indexAr1; i < mid; i++) {
            array[indexRes] = helper[i];
            indexRes += 1;
        }
        for (int i = indexAr2; i <= right; i++) {
            array[indexRes] = helper[i];
            indexRes += 1;
        }
        return array;
    }



    //QUICKSORT
    public int[] quickSort(int[] array) {
        if(array.length == 0 || array == null){
            return array;
        }
        // Write your solution here
        quickSort(array,0,array.length-1);
        return array;
    }

    private void quickSort(int[] array, int left, int right){
        if (left >= right){
            return;
        }

        Random rand = new Random();
        int mid = left + rand.nextInt(right-left+1);
        int newMid = partition(array, mid, left, right);

        quickSort(array,left,newMid-1);
        quickSort(array,newMid+1,right);

    }


    public int partition(int[] array, int pivotIndex, int left, int right) {
        int cur = left + 1;
        int compareVal = array[pivotIndex];
        swap(array, left, pivotIndex);
        pivotIndex = left;
        while(cur <= right){
            if(array[cur] < compareVal){
                swap(array,cur,pivotIndex);
                pivotIndex = cur;
                cur++;
            }else{
                swap(array,cur,right);
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
        array[i]=mem;

    }
}
