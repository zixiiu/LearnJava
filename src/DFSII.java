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
            if(dedup.peek() == null || dedup.peek() == 'm' || dedup.peek() == 'n') {
                sb.append('('); // add ll
                dedup.push('l');
                validParenthesesHelperIII(l, m, n, ll + 1, lr, ml, mr, nl, nr, res, sb, dedup);
                dedup.pop();
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        if (ml < m) {
            if(dedup.peek() == null || dedup.peek() == 'n') {
                sb.append('<'); // add ll
                dedup.push('m');
                validParenthesesHelperIII(l, m, n, ll, lr, ml + 1, mr, nl, nr, res, sb, dedup);
                dedup.pop();
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        if (nl < n) {
            if(dedup.peek() == null) {
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

}
