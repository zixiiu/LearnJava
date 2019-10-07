import java.util.*;

public class DFSII {
    public List<String> validParentheses(int l, int m, int n) {
        List<String> res = new ArrayList<>();
        Deque<Character> dedup = new ArrayDeque<>();
        validParenthesesHelper(l, m, n, 0, 0, 0, 0, 0, 0, res, new StringBuilder(), dedup);
        return res;
    }

    private void validParenthesesHelper(int l, int m, int n, int ll, int lr, int ml, int mr, int nl, int nr, List<String> res, StringBuilder sb, Deque<Character> dedup) {
        if (lr == l && mr == m && nr == n) {
            res.add(sb.toString());
            return;
        }
        if (ll < l) {
            sb.append('('); // add ll
            dedup.push('l');
            validParenthesesHelper(l, m, n, ll + 1, lr, ml, mr, nl, nr, res, sb, dedup);
            dedup.pop();
            sb.deleteCharAt(sb.length() - 1);
        }
        if (ml < m) {
            sb.append('<'); // add ll
            dedup.push('m');
            validParenthesesHelper(l, m, n, ll, lr, ml + 1, mr, nl, nr, res, sb, dedup);
            dedup.pop();
            sb.deleteCharAt(sb.length() - 1);
        }
        if (nl < n) {
            sb.append('{'); // add ll
            dedup.push('n');
            validParenthesesHelper(l, m, n, ll, lr, ml, mr, nl + 1, nr, res, sb, dedup);
            dedup.pop();
            sb.deleteCharAt(sb.length() - 1);
        }
        if (lr < ll) {
            if (dedup.peek() == 'l') {
                sb.append(')'); // add lr
                dedup.pop();
                validParenthesesHelper(l, m, n, ll, lr + 1, ml, mr, nl, nr, res, sb, dedup);
                sb.deleteCharAt(sb.length() - 1);
                dedup.push('l');
            }
        }
        if (mr < ml) {
            if (dedup.peek() == 'm') {
                sb.append('>'); // add lr
                dedup.pop();
                validParenthesesHelper(l, m, n, ll, lr, ml, mr + 1, nl, nr, res, sb, dedup);
                sb.deleteCharAt(sb.length() - 1);
                dedup.push('m');
            }
        }
        if (nr < nl) {
            if (dedup.peek() == 'n') {
                sb.append('}'); // add lr
                dedup.pop();
                validParenthesesHelper(l, m, n, ll, lr, ml, mr, nl, nr + 1, res, sb, dedup);
                sb.deleteCharAt(sb.length() - 1);
                dedup.push('n');
            }
        }
    }

    public List<String> validParenthesesIII(int l, int m, int n) {
        List<String> res = new ArrayList<>();
        Deque<Character> dedup = new ArrayDeque<>();
        validParenthesesHelperIII(l, m, n, 0, 0, 0, 0, 0, 0, res, new StringBuilder(), dedup);
        return res;
    }

    private void validParenthesesHelperIII(int l, int m, int n, int ll, int lr, int ml, int mr, int nl, int nr, List<String> res, StringBuilder sb, Deque<Character> dedup) {
        if (lr == l && mr == m && nr == n) {
            res.add(sb.toString());
            return;
        }
        if (ll < l) {
            if (dedup.peek() == null || dedup.peek() == 'm' || dedup.peek() == 'n') {
                sb.append('('); // add ll
                dedup.push('l');
                validParenthesesHelperIII(l, m, n, ll + 1, lr, ml, mr, nl, nr, res, sb, dedup);
                dedup.pop();
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        if (ml < m) {
            if (dedup.peek() == null || dedup.peek() == 'n') {
                sb.append('<'); // add ll
                dedup.push('m');
                validParenthesesHelperIII(l, m, n, ll, lr, ml + 1, mr, nl, nr, res, sb, dedup);
                dedup.pop();
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        if (nl < n) {
            if (dedup.peek() == null) {
                sb.append('{'); // add ll
                dedup.push('n');
                validParenthesesHelperIII(l, m, n, ll, lr, ml, mr, nl + 1, nr, res, sb, dedup);
                dedup.pop();
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        if (lr < ll) {
            if (dedup.peek() == 'l') {
                sb.append(')'); // add lr
                dedup.pop();
                validParenthesesHelperIII(l, m, n, ll, lr + 1, ml, mr, nl, nr, res, sb, dedup);
                sb.deleteCharAt(sb.length() - 1);
                dedup.push('l');
            }
        }
        if (mr < ml) {
            if (dedup.peek() == 'm') {
                sb.append('>'); // add lr
                dedup.pop();
                validParenthesesHelperIII(l, m, n, ll, lr, ml, mr + 1, nl, nr, res, sb, dedup);
                sb.deleteCharAt(sb.length() - 1);
                dedup.push('m');
            }
        }
        if (nr < nl) {
            if (dedup.peek() == 'n') {
                sb.append('}'); // add lr
                dedup.pop();
                validParenthesesHelperIII(l, m, n, ll, lr, ml, mr, nl, nr + 1, res, sb, dedup);
                sb.deleteCharAt(sb.length() - 1);
                dedup.push('n');
            }
        }
    }

    public List<String> subSets(String set) { //TODO: WRONG!
        // Write your solution here.
        List<String> res = new ArrayList<>();
        if (set == null) return res;
        subSetHelper(set, new StringBuilder(), 0, res);
        return res;
    }

    private void subSetHelper(String set, StringBuilder sb, int index, List<String> res) {
        if (index >= set.length()) {
            res.add(sb.toString());
            return;
        }

        //add
        sb.append(set.charAt(index));
        subSetHelper(set, sb, index + 1, res);
        sb.deleteCharAt(sb.length() - 1);

        //not
        int next = index;
        while (next < set.length() && set.charAt(index) == set.charAt(next)) {
            next++;
        }
        subSetHelper(set, sb, next, res);

    }


    public List<String> subSetsOfSizeK(String set, int k) {
        List<String> res = new ArrayList<>();
        if (set == null) return res;
        subSetsOfSizeKHelper(set, new StringBuilder(), 0, res, k);
        return res;
    }

    private void subSetsOfSizeKHelper(String set, StringBuilder sb, int index, List<String> res, int k) {
        if (sb.length() >= k) {
            res.add(sb.toString());
            return;
        }
        if (index >= set.length()) {
            return;
        }


        //add
        sb.append(set.charAt(index));
        subSetsOfSizeKHelper(set, sb, index + 1, res, k);
        sb.deleteCharAt(sb.length() - 1);

        //not
        int next = index;
        while (next < set.length() && set.charAt(index) == set.charAt(next)) {
            next++;
        }
        subSetsOfSizeKHelper(set, sb, next, res, k);

    }

    public List<List<Integer>> combinations(int target) {
        // get minimum factors
        List<List<Integer>> res = new ArrayList<>();
        if (target == 1) return res;
        List<Integer> factors = allFactors(target);
        combinationsHelper(target, res, new ArrayList<>(), factors, 0);
        return res;
    }

    private List<Integer> allFactors(int target) {
        List<Integer> res = new ArrayList<>();
        for (int i = target - 1; i > 1; i--) {
            if (target % i == 0){
                res.add(i);
            }
        }
        return res;
    }

    private void combinationsHelper(int rem, List<List<Integer>> res, List<Integer> tmp, List<Integer> factors, int factorIndex) {
        // done
        if (factorIndex == factors.size()) {
            if(rem == 1) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        int divider = factors.get(factorIndex);
        for (int i = 0; Math.pow(divider, i) <= rem; i++) {
            if (i == 0 || rem % Math.pow(divider, i) == 0) {
                for (int j = 0; j < i; j++) {
                    tmp.add(divider);
                }
                combinationsHelper(i == 0 ? rem : rem / (int) Math.pow(divider, i), res, tmp, factors, factorIndex + 1);
                for (int j = 0; j < i; j++) {
                    tmp.remove(tmp.size() - 1);
                }


            }
        }

    }

}
