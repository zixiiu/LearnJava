import java.util.Random;

public class QuickSort {
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
