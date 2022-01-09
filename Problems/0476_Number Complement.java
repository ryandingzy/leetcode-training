class Solution {
    public int findComplement(int num) {
        int res = 0;
        int i = 0;
        while (num != 0) {
            res |= (1 - (num & 1)) << i;
            num >>= 1;
            i++;
        }
        return res;
    }
}


// other method -- slow
class Solution {
  public int findComplement(int num) {
    return (Integer.highestOneBit(num) << 1) - num - 1;
  }
}
