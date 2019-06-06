import java.util.LinkedList;

public class Stacks {
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

    public void sortWithTwoStack(LinkedList<Integer> s1){
        LinkedList<Integer> s2 = new LinkedList<>();
        int sortedItemCount = 0;
        int thisMin = Integer.MAX_VALUE;
        while (s1.isEmpty() == false){
            int cur = s1.pop();
            if(cur < thisMin){
                thisMin = cur;
            }
            s2.push(cur);
        }
    }

}
