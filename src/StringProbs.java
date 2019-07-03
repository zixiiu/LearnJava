import java.util.*;

public class StringProbs {
    public String[] topKFrequent(String[] combo, int k) {
        // construct map
        Map<String, Integer> freqMap = new HashMap<>();
        for (String each : combo) {
            Integer cur = freqMap.get(each);
            if (cur == null) cur = 1;
            else cur++;
            freqMap.put(each, cur);

        }

//        if( k > freqMap.size()){
//            Set<String> resSet = freqMap.keySet();
//
//            return resSet.toArray(new String[resSet.size()]);
//        }

        //  Compartor of map entry
        class FreqComparator implements Comparator<Map.Entry<String, Integer>> {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) return 0;
                return o1.getValue() < o2.getValue() ? -1 : 1;
            }
        }
        //  Flatten map
        Set<Map.Entry<String, Integer>> freqMapSet = freqMap.entrySet();
        List<Map.Entry<String, Integer>> freqMapFlattened = new ArrayList<>();
        for (Map.Entry<String, Integer> each : freqMapSet) {
            freqMapFlattened.add(each);
        }

        // select top k by min heap
        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new FreqComparator());
        int i;
        String[] res;
        if (k <= freqMap.size()) {
            res = new String[k];
            for (i = 0; i < k; i++) {
                pq.add(freqMapFlattened.get(i));
            }
            for (i = k; i < freqMapFlattened.size(); i++) {
                Map.Entry<String, Integer> cur = freqMapFlattened.get(i);
                if (cur.getValue() > pq.peek().getValue()) {
                    pq.poll();
                    pq.add(cur);
                }
            }
            int index = k - 1;
            while (!pq.isEmpty()) {
                res[index--] = pq.poll().getKey();
            }
        } else {
            res = new String[freqMapFlattened.size()];
            for (i = 0; i < freqMapFlattened.size(); i++) {
                pq.add(freqMapFlattened.get(i));
            }
            int index = res.length - 1;
            while (!pq.isEmpty()) {
                res[index--] = pq.poll().getKey();
            }
        }


        return res;
    }

    public String remove(String input, String t) {
        if (input.length() == 0) return input;
        char[] inputC = input.toCharArray();
        char[] tC = t.toCharArray();
        Set<Character> toDelete = new HashSet<>();
        for (char each : tC) toDelete.add(each);
//        int i = 0;
        int j = 0;
//        while(true){
//            if (toDelete.contains(inputC[i])){
//                i++;
//            }else{
//                i++; j++;
//            }
//            if(i == inputC.length) break;
//            inputC[j] = inputC[i];
//        }
        for (int i = 0; i < inputC.length; i++) {
            inputC[j] = inputC[i];
            if (!toDelete.contains(inputC[i])) j++;
        }
        return new String(inputC, 0, j);
    }

    public String removeSpaces(String input) {
        if (input.length() == 0) return input;
        char[] inputC = input.toCharArray();
        int j = 0;
        for (int i = 0; i < inputC.length; i++) {
            char cur = inputC[i];
            inputC[j] = cur;
            if (cur == ' ' && (i == inputC.length - 1 || inputC[i + 1] == ' ')) continue;
            j++;
        }
        while (j != 0 && inputC[j - 1] == ' ') j--;
        int i = 0;
        while (i < j && inputC[i] == ' ') i++;
        return new String(inputC, i, j - i);
    }

    public String deDup(String input) {
        if (input.length() == 0) return input;
        char[] inputC = input.toCharArray();
        int f = 0;
        int s = 0;
        int c = 0;
        while (f < input.length()) {
            f++;
            if (f == input.length() || inputC[f] != inputC[c]) {
                inputC[s] = inputC[f - 1];
                s++;
                c = f;
            }
        }
        return new String(inputC, 0, s);
    }

    public String deDup2(String input) {
        if (input.length() == 0) return input;
        char[] inputC = input.toCharArray();
        int f = 0;
        Deque<Character> stack = new ArrayDeque<>();

        while (f < inputC.length) {
            char cur = inputC[f];
            if (stack.isEmpty() || stack.peekFirst() != cur) {
                ;
                stack.offerFirst(cur);
                f++;
            } else if (stack.peekFirst() == cur) {
                while (f < inputC.length && inputC[f] == stack.peekFirst()) f++;
                stack.pollFirst();
            }
        }
        int resSize = stack.size();
        for (int i = resSize - 1; i >= 0; i--) {
            inputC[i] = stack.pollFirst();
        }
        ;
        return new String(inputC, 0, resSize);
    }

    public String deDup2NoStack(String input) {
        if (input.length() == 0) return input;
        char[] inputC = input.toCharArray();
        int f = 0;
        int x = 0;

        while (f < inputC.length) {
            char cur = inputC[f];
            if (x == 0 || inputC[x - 1] != cur) {
                ;
                inputC[x] = inputC[f];
                x++;
                f++;
            } else if (inputC[x - 1] == cur) {
                while (f < inputC.length && inputC[f] == inputC[x - 1]) f++;
                x--;
            }
        }
        return new String(inputC, 0, x);
    }

    public int strstr(String large, String small) {
        if (small.length() == 0) return 0;
        char[] smallC = small.toCharArray();
        char[] largeC = large.toCharArray();
        int i = 0;
        int j = 0;
        int m = 0;
        while (i < largeC.length) {
            if (smallC[j] == largeC[i]) {
                i++;
                if (j == 0) m = i;
                j++;
                if (j == smallC.length) return i - smallC.length;
            } else if (j != 0) {
                i = m;
                j = 0;
            } else {
                i++;
            }
        }
        ;
        return -1;
    }

    public String reverse(String input) {
        if (input.length() == 0) return input;
        char[] inputC = input.toCharArray();
        int f = 0;
        int l = inputC.length - 1;
        while (f < l) {
            swap(inputC, f, l);
            f++;
            l--;
        }
        return new String(inputC);
    }

    private void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public String reverseWords(String input) {
        if (input.length() == 0) return input;
        char[] inputC = input.toCharArray();
        reverseHelper(inputC, 0, inputC.length - 1);
        int thisLeft = 0;
        for (int i = 0; i < inputC.length; i++) {
            if (inputC[i] == ' ') {
                reverseHelper(inputC, thisLeft, i - 1);
                thisLeft = i + 1;
            }
        }
        reverseHelper(inputC, thisLeft, inputC.length - 1);
        return new String(inputC);
    }

    private void reverseHelper(char[] input, int left, int right) {
        int f = left;
        int l = right;
        while (f < l) {
            swap(input, f, l);
            f++;
            l--;
        }
    }

    public String rightShift(String input, int n) {
        if (input.length() == 0) return input;
        char[] inputC = input.toCharArray();
        n = n % inputC.length;
        return new String(inputC, inputC.length - n, n) + new String(inputC, 0, inputC.length - n);
    }

    public String replace(String input, String source, String target) {
        if (input.length() == 0) return input;

        if (target.length() <= source.length()) {// smaller, no resize, left to right;
            char[] inputC = input.toCharArray();
            char[] sourceC = source.toCharArray();
            char[] targetC = target.toCharArray();
            int s = 0;
            int f = 0;
            int c = 0;

            int is = 0;
            int it;

            boolean needReplace;

            while (f < inputC.length) {
                is = 0;
                if (inputC[f] == sourceC[is]) {
                    c = f;
                    needReplace = true;
                    while (is < sourceC.length) {
                        if (c == inputC.length || inputC[c] != sourceC[is]) {//do not need to replace
                            needReplace = false;
                            break;
                        }
                        ;
                        is++;
                        c++;
                    }
                } else needReplace = false;

                if (needReplace) {
                    for (it = 0; it < targetC.length; it++) {
                        inputC[s] = targetC[it];
                        s++;
                    }
                    f = c;
                    continue;

                }
                inputC[s] = inputC[f];
                f++;
                s++;
            }
            return new String(inputC, 0, s);

        } else {// larger, need resize, right to left.
            //calculate all match
            Set<Integer> occ = allOccurance(input, source);


            char[] targetC = target.toCharArray();
            char[] inputC = input.toCharArray();
            char[] resC = new char[occ.size() * (target.length() - source.length()) + inputC.length];
            //copy to resC
            for (int i = 0; i < inputC.length; i++) resC[i] = inputC[i];

            int s = resC.length - 1;
            int f = inputC.length - 1;
            while (f >= 0) {
                if (occ.contains(f)) {
                    for (int it = targetC.length - 1; it >= 0; it--) {
                        resC[s] = targetC[it];
                        s--;
                    }
                    f -= source.length();
                    continue;
                }
                resC[s] = resC[f];
                f--;
                s--;
            }

            return new String(resC);
        }
    }

    private Set<Integer> allOccurance(String large, String small) {
        Set<Integer> res = new HashSet<>();
        char[] smallC = small.toCharArray();
        char[] largeC = large.toCharArray();
        int i = 0;
        int j = 0;
        int m = 0;
        while (i < largeC.length) {
            if (smallC[j] == largeC[i]) {
                i++;
                if (j == 0) m = i;
                j++;
                if (j == smallC.length) {
                    res.add(i - 1);
                    j = 0;
                }
            } else if (j != 0) {
                i = m;
                j = 0;
            } else {
                i++;
            }
        }
        return res;
    }

    public int[] reorder(int[] array) {
        int size = array.length;
        if (size == 1 || size == 0 || size == 2 || size == 3) return array;
        int left = 1;
        int mid = (size-2)/2;
        while (left <= mid) {
            int j = mid +1;
            for (int i = left; i <= mid; i++) {
                swapIntArray(array,i,j);
                j++;
            }
            left++;
        }
        return array;

    }
    private void swapIntArray(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public int[] reorderRecur(int[] array) {
        return new int[]{1};
    }
    private void reorderRecurHelper(int[] array, int left, int right){
        if(left == right) return;
        reorderRecurHelper(array, left,right/2);
        reorderRecurHelper(array,right/2+1, right);
    }

    public String compress(String input) {// not in-place!!!
        if (input.length() == 0) return input;
        char[] inputC = input.toCharArray();
        char lastSeen = inputC[0];
        Integer charCount = 1;
        StringBuilder res = new StringBuilder();
        res.append(inputC[0]);
        int i = 0;
        while(i < input.length()){
            while(i<inputC.length && inputC[i] == lastSeen) {
                i++;
                charCount++;
            }

            res.append(charCount-1);
            if (i<inputC.length) {
                res.append(inputC[i]);
                lastSeen = inputC[i];
            }
            charCount = 1;
        }
        return res.toString();
    }

    public String decompress(String input) {
        if (input.length() == 0) return input;
        int i = 0;
        StringBuilder res = new StringBuilder();
        while(i<input.length()) {
            char cur = input.charAt(i);
            i++;
            for (int j = 0; j < Character.getNumericValue(input.charAt(i)); j++) res.append(cur);
            i++;
        }
        return res.toString();
    }

    public int longest(String input) {
        if (input.length() == 0) return 0;
        char[] inputC = input.toCharArray();
        int maxLength = 0;
        int i = 0;
        int j = 0;
        Set<Character> exist = new HashSet<>();
        while (i < inputC.length){
            if (!exist.contains(inputC[i])){
                exist.add(inputC[i]);
                i++;
            }else{
                exist.remove(inputC[j]);
                j++;
            }
            if (exist.size() > maxLength) maxLength = exist.size();
        }
        return maxLength;
    }

    public List<Integer> allAnagrams(String sh, String lo) {
        List<Integer> res = new ArrayList<>();
        if (lo.length() == 0) return res;
        char[] inputC = sh.toCharArray();
        Set<String> allPermu = permutationsRep(sh);
        String tmpStr;
        for(int i = 0; i < lo.length() - sh.length() + 1; i++){

            if(allPermu.contains(lo.substring(i,i+lo.length()))){
                res.add(i);
            };
        }
        return res;
    }

    private Set<String> permutationsRep(String set) {
        Set<String> res = new HashSet<>();
        StringBuilder fullString = new StringBuilder(set);
        permutationsRep(fullString, new StringBuilder(), res);
        return res;
    }

    private void permutationsRep(StringBuilder set, StringBuilder tmpRes, Set<String> res) {
        if (set.length() == 0) {
            res.add(tmpRes.toString());
            return;
        }
        Set<Character> visited = new HashSet<>();
        for(int i = 0; i < set.length(); i++){
            char thisChar = set.charAt(i);
            if(!visited.contains(thisChar)) {
                visited.add(thisChar);
                tmpRes.append(thisChar);
                set.deleteCharAt(i);
                permutationsRep(set, tmpRes, res);
                set.insert(i, thisChar);
                tmpRes.deleteCharAt(tmpRes.length() - 1);
            }

        }
    }

}
