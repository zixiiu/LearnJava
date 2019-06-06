public class ClosetBinaryTree {

    public int[] kClosest(int[] array, int target, int k) {
        int left = 0;
        int right = array.length - 1;
        int mid = right / 2;
        int curZero = -1;
        while (left + 1 < right) {
            mid = (left + right) / 2;
            if (target == array[mid]) {
                curZero = mid;
                break;
            } else if (target < array[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (curZero == -1){
            curZero = Math.abs(target - array[left])<Math.abs(target - array[right]) ? left:right;
        }

        int[] res = new int[k];
        int curLeft = curZero;
        int curRight = curZero;
        for(int i = 0;i<k;i++){
            if (curLeft == curRight){
                res[i] = array[curZero];
                curRight = curMoveRight(array,curRight);
                curLeft = curMoveLeft(array,curLeft);
            }else if(Math.abs(target - array[curLeft]) < Math.abs(target - array[curRight])){
                res[i] = array[curLeft];
                curLeft = curMoveLeft(array,curLeft);
            }else{
                res[i] = array[curRight];
                curRight = curMoveRight(array,curRight);
            }

        }
        return res;

    }
    private int curMoveRight(int[] array, int cur){
        if (cur == array.length -1){
            array[cur] = Integer.MAX_VALUE;
        }else{
            cur++;
        }
        return cur;
    }

    private int curMoveLeft(int[] array, int cur){
        if (cur == 0){
            array[cur] = Integer.MAX_VALUE;
        }else{
            cur--;
        }
        return cur;
    }



    public int closest(int[] array, int target) {
        if(array.length == 0 || array == null){return -1;}
        int left = 0;
        int right = array.length -1;
        int mid = right/2;
        //int last_seen = -1;
        while(left+2 <= right ){
            mid = (left+right)/2;
            if(target == array[mid]){
                return mid;
                //last_seen = mid;
            }else if(target < array[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        if (Math.abs(target - array[mid])>Math.abs(target - array[left]) && Math.abs(target - array[right])>Math.abs(target - array[left])){return left;}
        else if (Math.abs(target - array[mid])>Math.abs(target - array[right])){return right;}
        else{return mid;}

    }
}
