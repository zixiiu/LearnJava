import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int key;
    public TreeNode(int value){
        this.key = value;
    }

    public static TreeNode fromArrayBalanced(Integer[] array){
        if(array.length == 0 || array == null) return null;
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> toGo = new ArrayDeque<>();
        toGo.offer(root);
        int i = 1;
        TreeNode curr;
        TreeNode next;
        while (true){
            curr = toGo.poll();
            next = array[i] == null ? null:new TreeNode(array[i]);
            curr.left = next;
            toGo.offer(next);
            i++;
            if(i == array.length) break;

            next = array[i] == null ? null:new TreeNode(array[i]);
            curr.right = next;
            toGo.offer(next);
            i++;
            if(i == array.length) break;

        }
        return root;
    }
    public String toStringAfter(){
        String res = "";
//        BinaryTree s = new BinaryTree();
//        int h = s.getHeight(this);
        Queue<TreeNode> toGo = new ArrayDeque<>();
        toGo.offer(this);
        TreeNode cur = this;
        int newLineCounter = 0;
        int newLineLimit = 1;
        while (!toGo.isEmpty()){
            cur = toGo.poll();
            res += Integer.toString(cur.key);
            if (cur.left != null) toGo.offer(cur.left);
            if (cur.right != null) toGo.offer(cur.right);
            newLineCounter++;
            if (newLineCounter == newLineLimit){
                res += "\n";
                newLineCounter = 0;
                newLineLimit *= 2;
            }
        }
        return res;
    }

}
public class BinaryTree {
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    public boolean isBalenced(TreeNode root){
        if(root == null) return true;
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalenced(root.left) && isBalenced(root.right);
    }
    public boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        else if ((left == null && right != null) || (left != null && right == null)) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left) && left.key == right.key;
    }
    public boolean isTweakedIdentical(TreeNode one, TreeNode two){
        if (one == null && two == null) return true;
        else if ((one == null && two != null) || (one != null && two == null)) return false;
        return (isTweakedIdentical(one.left, two.left) || isTweakedIdentical(one.left, two.right))
                && (isTweakedIdentical(one.right, two.left) || isTweakedIdentical(one.right, two.right))
                && one.key == two.key;
    }
    public boolean isBST(TreeNode root){
        if (root == null) return true;
        return isBST(root.left, Integer.MIN_VALUE, root.key) && isBST(root.right, root.key, Integer.MAX_VALUE);
    }
    private boolean isBST(TreeNode root,int lower,int upper){
        if( root == null ) return true;
        if( root.key <= lower || root.key >= upper) return false;
        return isBST(root.left,lower,root.key) && isBST(root.right,root.key,upper);
    }

    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> res = new ArrayList<>();
        getRange(root, res, min, max);
        return res;
    }
    private void getRange(TreeNode root, List<Integer> res, int min, int max){
        if (root == null) return;

        if (root.key <= min) getRange(root.right, res, min, max);
        if (root.key <= max && root.key >= min) res.add(root.key);
        if (root.key >= max) getRange(root.left, res, min, max);

    }

}
