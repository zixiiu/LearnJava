import java.util.*;

class RandomListNode {
    public int value;
    public RandomListNode next;
    public RandomListNode random;

    public RandomListNode(int value) {
        this.value = value;
    }
}

public class CrossTrainingII {
    //Count Array, MergeSort
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


    //Count Array, QuickSort, still need tinkering
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
        for (int i = pivotIndex; i <= left; i--) res[index[i]]++;
        pivotIndex = left;

        while (cur <= right) {
            if (array[index[cur]] < compareVal) {
                swap(index, cur, pivotIndex);
                res[index[pivotIndex]]++;
                res[index[cur]]--;
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


    //Deep Copy linkedlist w/Random


    public RandomListNode copy(RandomListNode head) {
        if (head == null) return null;
        RandomListNode cur = head;
        RandomListNode newHead = new RandomListNode(cur.value);
        RandomListNode newCur = newHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, newHead);
        while (true) {
            if (cur.next != null) {
                if (!map.containsKey(cur.next)) {
                    newCur.next = new RandomListNode(cur.next.value);
                    map.put(cur.next, newCur.next);
                } else {
                    newCur.next = map.get(cur.next);
                }
            }
            if (cur.random != null) {
                if (!map.containsKey(cur.random)) {
                    newCur.random = new RandomListNode(cur.random.value);
                    map.put(cur.random, newCur.random);
                } else {
                    newCur.random = map.get(cur.random);
                }
            }
            cur = cur.next;
            newCur = newCur.next;
            if (cur == null) break;
        }
        return newHead;
    }


    // deep copy a graph
    public List<GraphNode> copy(List<GraphNode> graph) {
        Map<GraphNode, GraphNode> lut = new HashMap<>();
        List<GraphNode> res = new ArrayList<>();
        for (GraphNode i : graph) {
            GraphNode newI;
            if (lut.containsKey(i)) {
                newI = lut.get(i);
            } else {
                newI = new GraphNode(i.key);
                lut.put(i, newI);
                res.add(newI);
            }
            for (GraphNode j : i.neighbors) {
                if (lut.containsKey(j)) {
                    newI.neighbors.add(lut.get(j));
                } else {
                    GraphNode newJ = new GraphNode(j.key);
                    lut.put(j, newJ);
                    res.add(newJ);
                    newI.neighbors.add(newJ);
                }
            }
        }
        return res;
    }

    // K-way merge
    class KMergeElement implements Comparable<KMergeElement> {
        int index;
        int value;
        int arrayIndex;

        public KMergeElement(int i, int ai, int v) {
            index = i;
            value = v;
            arrayIndex = ai;
        }

        @Override
        public int compareTo(KMergeElement e) {
            if (e.value == this.value) return 0;
            return e.value < this.value ? 1 : -1;
        }
    }

    public int[] merge(int[][] arrayOfArrays) {
        Queue<KMergeElement> pq = new PriorityQueue<>();

        int count = 0;
        for (int[] i : arrayOfArrays) {
            for (int j : i) {
                count++;
            }
        }

        int[] res = new int[count];
        int fillIndex = 0;

        for (int i = 0; i < arrayOfArrays.length; i++) { // for all array
            if (arrayOfArrays[i].length != 0) {
                pq.add(new KMergeElement(0, i, arrayOfArrays[i][0]));
            }
        }
        while (!pq.isEmpty()) {
            KMergeElement cur = pq.poll();
            if (arrayOfArrays[cur.arrayIndex].length - 1 != cur.index) {//not the last one
                pq.add(new KMergeElement(cur.index + 1, cur.arrayIndex, arrayOfArrays[cur.arrayIndex][cur.index + 1]));
            }
            res[fillIndex] = cur.value;
            fillIndex++;
        }
        return res;
    }


    //Closest in BST
    public int closest(TreeNode root, int target) {
        TreeNode cur = root;
        int prev;
        while (true) {

            if (target < cur.key) cur = cur.left;
            else cur = cur.right;

        }

    }

    //2Sum using hashset
    public boolean existSum(int[] array, int target) {
        Set<Integer> exist = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (exist.contains(target - array[i])) return true;
            if (!exist.contains(array[i])) exist.add(array[i]);
        }
        return false;
    }


    //2Sum all Pairs
    public List<List<Integer>> allPairs(int[] array, int target) {
        Map<Integer, List<Integer>> exist = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (exist.containsKey(target - array[i])) {
                for (int each : exist.get(target - array[i])) {
                    res.add(Arrays.asList(i, each));
                }

            }
            if (!exist.containsKey(array[i])) {
                exist.put(array[i], new ArrayList<>());
            }
            exist.get(array[i]).add(i);
        }
        return res;
    }


    // Binary tree Sum to target
    public boolean exist(TreeNode root, int target) {
        Map<Integer, Integer> tmpSum = new HashMap<>();
        boolean[] res = new boolean[1];
        tmpSum.put(0, 1);
        existHelper(root, target, tmpSum, 0, res);
        return res[0];
    }

    private void existHelper(TreeNode root, int target, Map<Integer, Integer> tmpSum, int preSum, boolean[] res) {
        if (root != null) preSum += root.key;
        if (tmpSum.containsKey(preSum - target)) {
            res[0] = true;
            return;
        }
        if (root == null) return;
        if (tmpSum.containsKey(preSum)) tmpSum.replace(preSum, tmpSum.get(preSum) + 1);
        else tmpSum.put(preSum, 1);
        existHelper(root.left, target, tmpSum, preSum, res);
        existHelper(root.right, target, tmpSum, preSum, res);
        if (tmpSum.get(preSum) == 1) tmpSum.remove(preSum);
        else tmpSum.replace(preSum, tmpSum.get(preSum) - 1);
    }

    //2Sum distinct pairs
    public List<List<Integer>> allPairsDistinct(int[] array, int target) {
        Set<Integer> exist = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> added = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (exist.contains(target - array[i])) {
                if (!added.contains(array[i])) {
                    res.add(Arrays.asList(array[i], target - array[i]));
                    added.add(array[i]);
                    added.add(target - array[i]);
                }
            }
            if (!exist.contains(array[i])) exist.add(array[i]);
        }
        return res;
    }


    //3Sum distinct pairs
    public List<List<Integer>> allTriples(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> added = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (!added.contains(array[i])) {
                allPairsDistinctFor3Sum(array, target - array[i], array[i], res, added, i);
            }
        }
        return res;
    }

    public void allPairsDistinctFor3Sum(int[] array, int target, int thisIterNum, List<List<Integer>> res, Set<Integer> added3, int mask) {
        Set<Integer> exist = new HashSet<>();
        // List<List<Integer>> res = new ArrayList<>();
        Set<Integer> added = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (i == mask) continue;
            if (exist.contains(target - array[i])) {
                if (!added.contains(array[i])) {
                    res.add(Arrays.asList(array[i], target - array[i], thisIterNum));
                    added.add(array[i]);
                    added.add(target - array[i]);
                    added3.add(array[i]);
                    added3.add(target - array[i]);
                    added3.add(thisIterNum);
                }
            }
            if (!exist.contains(array[i])) exist.add(array[i]);
        }
        return;
    }

    //4 sum
    public boolean exist4Sum(int[] array, int target) {
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if(existSumFor4Sum(array, target - array[i] - array[j], i, j)) return true;
            }
        }
        return false;
    }

    public boolean existSumFor4Sum(int[] array, int target, int mask1, int mask2) {
        Set<Integer> exist = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if(i == mask1 || i == mask2) continue;
            if (exist.contains(target - array[i])) return true;
            if (!exist.contains(array[i])) exist.add(array[i]);
        }
        return false;
    }

}
