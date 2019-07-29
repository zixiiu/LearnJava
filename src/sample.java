import java.util.*;

public class sample {
    public void swap(int[] array, int i, int j) {
        // Write your solution here
        int mem;
        mem = array[j];
        array[j] = array[i];
        array[i] = mem;
    }

    public void shuffle(int[] array) {
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            int cur = r.nextInt(array.length - i) + i;
            swap(array, cur, i);
        }
    }

    //Res sample
    class Solution {
        Integer res;
        int count;
        Random r;

        public Solution() {
            res = null;
            count = 0;
            r = new Random();
        }

        public void read(int value) {
            count++;
            // nextInt returns [0,bound), uniform dist
            if (r.nextInt(count) == 0) res = value;
        }

        public Integer sample() {
            return res;
        }
    }

    //res sample k
    public class Solution2 {
        private final int k;
        private int count;
        private List<Integer> res;
        private Random r = new Random();


        public Solution2(int k) {
            res = new ArrayList<>();
            int count = 0;
            this.k = k;
        }

        public void read(int value) {
            count++;
            if(count <= k){
                res.add(value);
            }else{
                if(r.nextInt(count) < k){
                    res.set(r.nextInt(k),value);
                }
            }
        }

        public List<Integer> sample() {
            return res;
        }
    }

}
