import java.util.ArrayList;

public class MinHeap {
    ArrayList<Integer> heapArray = new ArrayList<>();

    public MinHeap(ArrayList<Integer> inputArray){
        this.heapArray = inputArray;
    }

    private int findLeft(int index){
        return index * 2 + 1;
    }
    private int findRight(int index){
        return index * 2 + 2;
    }
    private int findParent(int index){
        return (index - 1)/2;
    }
    private boolean checkCorrect(int index){
        if (index == 0) {// at top
            return heapArray.get(index) > heapArray.get(findLeft(index))&&
                    heapArray.get(index) > heapArray.get(findRight(index));
        }
        if (findLeft(index)>=heapArray.size()) {//at bottom, no child
            return heapArray.get(index) > heapArray.get(findParent(index));
        }
        if (findRight(index)>=heapArray.size()) {//at bottom, only left child
            return heapArray.get(index) > heapArray.get(findParent(index))&&
                    heapArray.get(index) > heapArray.get(findLeft(index));
        }
        //at middle, got both.
        return heapArray.get(index) > heapArray.get(findParent(index))&&
                heapArray.get(index) > heapArray.get(findLeft(index))&&
                heapArray.get(index) > heapArray.get(findRight(index));
    }
    private void maintain(int indexEdited){
        while(!checkCorrect(indexEdited)){
            if (indexEdited == 0) {// at top
                if (heapArray.get(findLeft(indexEdited)) > heapArray.get(findRight(indexEdited))){
                    swap(indexEdited, findParent(indexEdited));
                }
            }
            if (findLeft(indexEdited)>=heapArray.size()) {//at bottom, no child

            }
            if (findRight(indexEdited)>=heapArray.size()) {//at bottom, only left child

            }
            //at middle, got both.

            return;
        }

    }
    private void swap(int a, int b){
        Integer tmp = this.heapArray.get(a);
        this.heapArray.set(a, this.heapArray.get(b));
        this.heapArray.set(b, tmp);
    }
    public void Add(int toAdd){
        heapArray.add(toAdd);
        maintain(heapArray.size()-1);
    }

}
