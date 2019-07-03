import java.util.*;
import java.lang.String;

public class DFS {
    public List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) return res;
        subSetshelper(res, new StringBuilder(), 0, set);
        return res;
    }

    private void subSetshelper(List<String> res, StringBuilder tmpRes, int index, String set) {
        if (index == set.length()) {
            res.add(tmpRes.toString());
            System.out.println(tmpRes.toString());
            return;
        }
        tmpRes.append(set.charAt(index));
        subSetshelper(res, tmpRes, index + 1, set);
        tmpRes.deleteCharAt(tmpRes.length() - 1);

        subSetshelper(res, tmpRes, index + 1, set);

    }

    public List<List<Integer>> combinations(int target, int[] coinConf) {
        //int[] coinConf = new int[]{1,5,10,25};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmpRes = new ArrayList<>(Collections.nCopies(coinConf.length, 0));
        coinSelection(target, 0, tmpRes, coinConf, res);
        return res;

    }

    private void coinSelection(int value, int coinIndex, List<Integer> result, int[] coinConf, List<List<Integer>> res) {
        if (coinIndex == coinConf.length) {
            if (value == 0) {
                res.add(new ArrayList<>(result));
                //System.out.println(result.toString());
            }
            return;
        }
        for (int i = 0; i * coinConf[coinIndex] <= value; i++) {
            result.set(coinIndex, i);
            coinSelection(value - i * coinConf[coinIndex], coinIndex + 1, result, coinConf, res);
        }
    }

    public List<String> validParentheses(int n) {
        List<String> res = new ArrayList<>();
        //if (set == null)return res;
        validParentheses(res, new StringBuilder(), 0, n, 0, 0);
        return res;
    }

    private void validParentheses(List<String> res, StringBuilder tmpRes, int index, int total, int countLeft, int countRight) {
        if (index == total * 2) {
            res.add(tmpRes.toString());
            return;
        }

        if (countLeft < total) {
            tmpRes.append("(");
            validParentheses(res, tmpRes, index + 1, total, countLeft + 1, countRight);
            tmpRes.deleteCharAt(tmpRes.length() - 1);
        }
        if (countLeft > countRight) {
            tmpRes.append(")");
            validParentheses(res, tmpRes, index + 1, total, countLeft, countRight + 1);
            tmpRes.deleteCharAt(tmpRes.length() - 1);
        }
    }

    public List<String> permutations(String set) {
        List<String> res = new ArrayList<>();
        StringBuilder fullString = new StringBuilder(set);
        permutations(fullString, new StringBuilder(), res);
        return res;
    }

    private void permutations(StringBuilder set, StringBuilder tmpRes, List<String> res) {
        if (set.length() == 0) {
            res.add(tmpRes.toString());
            return;
        }
        for(int i = 0; i < set.length(); i++){
            char thisChar = set.charAt(i);
            tmpRes.append(thisChar);
            set.deleteCharAt(i);
            permutations(set, tmpRes, res);
            set.insert(i,thisChar);
            tmpRes.deleteCharAt(tmpRes.length() - 1);

        }
    }
    public List<String> permutationsRep(String set) {
        List<String> res = new ArrayList<>();
        StringBuilder fullString = new StringBuilder(set);
        permutationsRep(fullString, new StringBuilder(), res);
        return res;
    }

    private void permutationsRep(StringBuilder set, StringBuilder tmpRes, List<String> res) {
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
