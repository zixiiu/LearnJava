import java.util.ArrayList;
import java.util.List;

public class Exam3 {
    //using DFS.
    //@Each level: add space or not
    public List<String> addSpace(String input) {
        if (input.length() == 1 || input.length() == 0) return null;
        //need to specify because used length - 2.
        List<String> res = new ArrayList<>();
        StringBuilder tmpRes = new StringBuilder();
        addSpaceHelper(input, tmpRes, res, 0);
        return res;
    }

    private void addSpaceHelper(String input, StringBuilder tmpRes, List<String> res, int index) {
        if (index == input.length() - 1) {//stop at the last char.
            tmpRes.append(input.charAt(index));
            res.add(tmpRes.toString());
            tmpRes.deleteCharAt(tmpRes.length() - 1);
            return;
        }
        tmpRes.append(input.charAt(index));//do not add space
        addSpaceHelper(input, tmpRes, res, index + 1);
        // add space
        tmpRes.append(" ");
        addSpaceHelper(input, tmpRes, res, index + 1);
        // restore the stringbuilder.
        tmpRes.deleteCharAt(tmpRes.length() - 1);
        tmpRes.deleteCharAt(tmpRes.length() - 1);
    }


    public boolean isCousins(TreeNode root, TreeNode a, TreeNode b){
        //assume a and b are all in the tree.
        int res = isCousinsHelper( root,  a,  b);
        if (res == -3) return true;
        return false;

    }

    private int isCousinsHelper(TreeNode root, TreeNode a, TreeNode b){
        if (root == null) return -1;
        if (root == a || root == b) return 0;
        int leftRes = isCousinsHelper( root.left,  a,  b);
        int rightRes = isCousinsHelper( root.right,  a,  b);
        if(leftRes == -1 &&  rightRes == -1) return -1;
        if(leftRes == -1) return rightRes + 1;
        if(rightRes == -1) return leftRes + 1;
        //both are not -1
        if(leftRes != rightRes){// not in
            //-2: not cousin!
            return -2;
        }
        if(leftRes == 1 && rightRes == 1){// in the same level but same parent
            return -2;
        }
        //-3: is cousin
        return -3;
    }


    public int cut(int n) {
        if (n <= 3) return n;
        int[] m = new int[n];
        m[0] = 0;
        for (int i = 1; i < n; i++) {
            int lMin = m[i-1];
            for (int j = 1; i - j * j > 0; j++) {
                lMin = lMin < m[i - j * j] ? lMin : m[i - j * j];
            }
            m[i] = lMin + 1;
        }
        return m[n - 1];
    }


    public boolean canCircle(String[] arr){
        boolean[] res = new boolean[1];
        boolean[] used = new boolean[arr.length];
        String[] tmp = new String[arr.length];
        //it doesn't metter what to put first. so put the first one.
        tmp[0] = arr[0];
        canCircleHelper(arr, 0, tmp, used, res);
        return res[0];
    }
    private void canCircleHelper(String[] arr, int index, String[] tmp, boolean[] used, boolean[] res){
        if (res[0] == true) return; // already found one result.
        if (index == arr.length - 1){// finished placing all to tmp.
            if(tmp[0].charAt(0) == tmp[tmp.length-1].charAt(tmp[tmp.length-1].length()-1)) res[0] = true;
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(used[i] == false && tmp[index].charAt(tmp[index].length()-1) == arr[i].charAt(0)){//can chain.
                used[i] = true;
                tmp[index+1] = arr[i];
                canCircleHelper(arr, index+1, tmp, used, res);
                used[i] = false;
                tmp[index+1] = null;
            }
        }

    }
}
