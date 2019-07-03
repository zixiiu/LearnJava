import java.util.*;

public class HashProbs {
    public int missing(int[] array) {
        Set<Integer> existSet = new HashSet<>();
        for(int i : array){
            existSet.add(i);
        }
        for(int i = 1; i<=array.length + 1; i++){
            if(!existSet.contains(i)) return i;
        }
        return 0;
    }

    public List<Integer> commonHashMap(List<Integer> A, List<Integer> B) {
        Map<Integer, Integer> commonMap = new HashMap();
        List<Integer> res = new ArrayList<>();
        for(Integer each : A){
            Integer cur = commonMap.get(each);
            if(cur == null){
                cur = 1;
            }else{
                cur ++;
            }
            commonMap.put(each,cur);
        }
        for(Integer each : B){
            Integer cur = commonMap.get(each);
            if (cur != null){
                cur--;
                res.add(each);
                if(cur == 0){
                    commonMap.remove(each);
                }else {
                    commonMap.put(each, cur);
                }

            }
        }
        return res;
    }
    public List<Integer> common2P(List<Integer> A, List<Integer> B) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < A.size() && j < B.size()){
            if (A.get(i) == B.get(j)){
                res.add(A.get(i));
                i++;
                j++;
            }
            else if(A.get(i) < B.get(j)) i++;
            else j++;
        }
        return res;
    }
}
