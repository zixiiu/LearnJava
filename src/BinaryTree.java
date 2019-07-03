import com.sun.source.tree.Tree;

import java.util.*;


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
        int newLineLimit = 2;

        res += Integer.toString(cur.key);
        res += '\n';

        while (!toGo.isEmpty()){
            cur = toGo.poll();
            if (cur.left != null){
                res += Integer.toString(cur.left.key);
                toGo.offer(cur.left);
            }else{
                res += ' ';
            }
            res += '\t';
            if (cur.right != null) {
                res += Integer.toString(cur.right.key);
                toGo.offer(cur.right);
            }else{
                res += ' ';
            }
            res += '\t';
            newLineCounter+=2;
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

    public void postOrderTravIter(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        stack.offerFirst(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if(prev == null || prev.left == cur || prev.right == cur){// go left
                if (cur.left == null){
                    System.out.print(cur.key);
                    stack.pollFirst();
                }else {
                    stack.offerFirst(cur.left);
                }
            }else if(cur.left == prev){//go right
                if (cur.right == null) {
                    System.out.print(cur.key);
                    stack.pollFirst();
                }else{
                    stack.offerFirst(cur.right);
                }
            }else if(cur.right == prev){//go up
                System.out.print(cur.key);
                stack.pollFirst();
            }
            prev = cur;
        }


    }

    public void inOrderTravIter(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode helper = root;
        while(!stack.isEmpty() || helper != null){
            if (helper == null){
                helper = stack.pollFirst();
                System.out.print(helper.key);
                helper = helper.right;
            }else{
                stack.offerFirst(helper);
                helper = helper.left;

            }
        }
    }
    public void preOrderTravIter(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root != null) stack.offerFirst(root);
        TreeNode cur;
        while (!stack.isEmpty()){
            cur = stack.pollFirst();
            System.out.print(cur.key);
            if (cur.right != null) stack.offerFirst(cur.right);
            if (cur.left != null) stack.offerFirst(cur.left);
        }
    }
    public void preOrderTravRecur(TreeNode root){
        if (root == null) return;
        System.out.print(root.key);
        preOrderTravRecur(root.left);
        preOrderTravRecur(root.right);
    }
    public void inOrderTravRecur(TreeNode root){
        if (root == null) return;
        inOrderTravRecur(root.left);
        System.out.print(root.key);
        inOrderTravRecur(root.right);
    }
    public void postOrderTravRecur(TreeNode root){
        if (root == null) return;
        postOrderTravRecur(root.left);
        postOrderTravRecur(root.right);
        System.out.print(root.key);
    }
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
