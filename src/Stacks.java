import java.util.LinkedList;

public class Stacks {
    public void sortWithTwo(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        int toSortCount = s1.size();

        while (toSortCount != 0) {
            int thisMin = Integer.MIN_VALUE;
            int thisMinCount = 1;
            while (toSortCount != 0) {
                int cur = s1.pop();
                if (cur > thisMin) {
                    thisMin = cur;
                    thisMinCount = 1;
                }else if (cur == thisMin){
                    thisMinCount++;
                }
                toSortCount--;
                s2.push(cur);
            }
            for (int i = 0; i<thisMinCount; i++) s1.push(thisMin);
            while (!s2.isEmpty()) {
                int cur = s2.pop();
                if (cur == thisMin) {

                } else {
                    s1.push(cur);
                    toSortCount++;
                }
            }
        }


    }
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        LinkedList<Integer> s3 = new LinkedList<Integer>();

        while(!s1.isEmpty() || !s2.isEmpty()){
            int thisMin = Integer.MAX_VALUE;
            while (!s1.isEmpty()){
                int cur = s1.pop();
                if(cur < thisMin){
                    thisMin = cur;
                }
                s2.push(cur);
            }
            while(!s2.isEmpty()){
                int cur = s2.pop();
                if (cur == thisMin){
                    s3.push(cur);
                }else {
                    s1.push(cur);
                }
            }
        }
        while (!s3.isEmpty()){
            s1.push(s3.pop());
        }
    }


}
