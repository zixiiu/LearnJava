import java.util.*;


public class BFS {
    public int[] kSmallest(int[] array, int k) {
        Queue<Integer> PQ = new PriorityQueue<>(Comparator.reverseOrder());
        //int i = 0;
        if (k == 0) return new int[0];
        for (int i = 0 ; i < array.length; i++){
            if (i < k){
                PQ.offer(array[i]);
            }else if(array[i] < PQ.peek()){
                PQ.poll();
                PQ.offer(array[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[k-i-1] = PQ.poll();
        }
        return res;
    }

    public List<List<Integer>> layerByLayer(TreeNode root) {
        Queue<TreeNode> toGo = new ArrayDeque<>();
        TreeNode cur;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallRes = new ArrayList<>();
        if (root == null) {
            return res;
        }
        toGo.offer(root);
        smallRes.add(root.key);
        res.add(smallRes);
        smallRes = new ArrayList<>();
        while (!toGo.isEmpty()){
            int size = toGo.size();
            for (int i = 0; i<size; i++){
                cur = toGo.poll();
                if (cur.left != null){
                    smallRes.add(cur.left.key);
                    toGo.offer(cur.left);
                }
                if (cur.right != null) {
                    smallRes.add(cur.right.key);
                    toGo.offer(cur.right);
                }
            }
            if(!smallRes.isEmpty()) res.add(smallRes);
            smallRes = new ArrayList<>();

        }
        return res;
    }

    public boolean isCompleted(TreeNode root) {
        Queue<TreeNode> toGo = new LinkedList<>();
        toGo.offer(root);
        TreeNode cur;
        TreeNode fin;
        while(true){
            cur = toGo.poll();
            if (cur == null){
                while(!toGo.isEmpty()){
                    fin = toGo.poll();
                    if (fin != null){
                        return false;
                    }
                }
                return true;
            }
            toGo.offer(cur.left);
            toGo.offer(cur.right);
        }
    }


//    class MyComparator implements Comparator<MatrixCoord>{
//        @Override
//        public int compare(MatrixCoord o1, MatrixCoord o2) {
//            return 0;
//        }
//    }
    public int kthSmallest(int[][] matrix, int k) {
        Queue<MatrixCoord> toGo = new PriorityQueue<>();
        int col = 0;
        int row = 0;
        int res = matrix[col][row];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        MatrixCoord cur = new MatrixCoord(0,0,matrix[0][0]);
        toGo.offer(cur);
        for(int i = 1; i < k+1; i++){
            cur = toGo.poll();
            if(cur.col + 1 < matrix.length && !visited[cur.col+1][cur.row]){
                toGo.offer(new MatrixCoord(cur.col +1, cur.row, matrix[cur.col+1][cur.row]));
                visited[cur.col+1][cur.row] = true;
            }
            if(cur.row + 1 < matrix[0].length && !visited[cur.col][cur.row + 1] ){
                toGo.offer(new MatrixCoord(cur.col, cur.row+1, matrix[cur.col][cur.row+1]));
                visited[cur.col][cur.row+1] = true;
            }

        }
        System.out.println(cur.value);
        return cur.value;
    }

    class MatrixCoord implements Comparable<MatrixCoord>{
        int row;
        int col;
        int value;
        public MatrixCoord(int col, int row, int value){
            this.row = row;
            this.col = col;
            this.value = value;
        }
        @Override
        public int compareTo(MatrixCoord ano) {
            if (ano.value == this.value) return 0;
            return ano.value < this.value ? 1 : -1;
        }
    }

    public boolean isBipartiteIter(List<GraphNode> graph) {
        if (graph.isEmpty()) return true;
        Set<GraphNode> visited = new HashSet<>();
        Set<GraphNode> black = new HashSet<>();
        Set<GraphNode> white = new HashSet<>();
        Queue<GraphNode> toGo = new ArrayDeque<>();

        GraphNode startAt = graph.get(0);
        toGo.offer(startAt);
        visited.add(startAt);
        black.add(startAt);

        GraphNode cur;
        boolean paintWhite = true; //true: white, false: black

        while(!toGo.isEmpty()){
            cur = toGo.poll();
            for(GraphNode item : cur.neighbors){
                if(!visited.contains(item)){
                    toGo.offer(item);
                    visited.add(item);
                }
                if(paintWhite){//time to color white
                    if(black.contains(item)) return false;
                    if(!white.contains(item)) white.add(item);
                }else{//time to color white
                    if(white.contains(item)) return false;
                    if(!black.contains(item)) black.add(item);
                }

            }
            paintWhite = !paintWhite;
        }
        return true;
    }
}
