public class Bit {
    public boolean isPowerOfTwo(int number) {
        int count = 0;
        if(number <= 0) return false;
        for(int i = 0; i < 32; i++){
            count += number >> i & 1;
            if(count == 2) return false;
        }
        return true;
    }

    public int diffBits(int a, int b) {
        int cross = a^b;
        int count = 0;
        for(int i = 0; i < 32; i++) {
            count += cross >>> i & 1;
        }
        return count;
    }
    public boolean allUnique(String word) {
        int[] unique = new int[8];
        for(int i = 0; i < word.length(); i++){
            char cur = word.charAt(i);
            int y = (int) cur /32;
            int x = (int) cur %32;
            if((unique[y] >> x & 1) == 1) return false;
            else unique[y] = unique[y] | (1 << x);
        }
        return true;
    }
    public String hex(int number) {
        StringBuilder res = new StringBuilder();
        String preflex = "0x";
        if (number == 0) preflex+="0";
        while(number != 0){
            int rem = number % 16;
            if (rem < 10){
                res.append((char) '0'+ rem);
            }else{
                res.append((char) (rem - 10 + 'A'));
            }
            number >>>= 4;
        }
        return preflex + res.reverse().toString();
    }

}
