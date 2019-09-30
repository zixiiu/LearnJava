import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CrossTrainingIII {
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> res = new ArrayList<>();
        if(set == null) return res;
        subSetHelper(set,new StringBuilder(), 0, res);
        return res;
    }
    private void subSetHelper(String set, StringBuilder sb, int index, List<String> res){
        if (index >= set.length()){
            res.add(sb.toString());
            return;
        }

        //add
        sb.append(set.charAt(index));
        subSetHelper(set, sb, index + 1, res);
        sb.deleteCharAt(sb.length()-1);

        //not
        int next = index;
        while(next < set.length() && set.charAt(index) == set.charAt(next)){
            next++;
        }
        subSetHelper(set, sb, next, res);
    }
}
