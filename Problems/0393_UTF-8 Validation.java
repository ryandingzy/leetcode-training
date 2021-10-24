class Solution {
    public boolean validUtf8(int[] data) {
        int numberOfBytesToProcess = 0;

        int mask1 = 1 << 7;
        int mask2 = 1 << 6;

        for(int i = 0; i < data.length; i++) {
            if (numberOfBytesToProcess == 0) {
                int mask = mask1;
                while ((mask & data[i]) != 0) {
                    numberOfBytesToProcess += 1;
                    mask = mask >> 1;
                }

                if (numberOfBytesToProcess == 0) {
                    continue; // 单独数字，不减number，直接继续
                }
                if (numberOfBytesToProcess > 4 || numberOfBytesToProcess == 1) {
                    return false;
                }

            } else {
                if (!((data[i] & mask1) == 1 && (mask2 & data[i]) == 0)) {
                    return false;
                }
            }
            numberOfBytesToProcess--;
        }
        return numberOfBytesToProcess == 0;
    }
}