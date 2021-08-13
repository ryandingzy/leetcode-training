class Solution {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        int leftPeak = 0;
        for (int i = 0; i < ratings.length; i++) {
            if (i != ratings.length - 1 && ratings[i+1] >= ratings[i]) {
                candy[i] = 1;
                // left
                for (int j = i - 1; j >= leftPeak; j--) {
                    if (j == leftPeak && candy[leftPeak] != 0) {
                        candy[j] = Math.max(candy[j], candy[j + 1] + 1);
                    } else {
                        candy[j] = candy[j+1] + 1;
                    }
                }
                // right
                while (i + 1 < ratings.length && ratings[i+1] > ratings[i]) {
                    candy[i+1] = candy[i] + 1;
                    i++;
                }
                // update left peak
                if (i + 1 < ratings.length) leftPeak = ratings[i+1] == ratings[i] ? i + 1 : i;
            }
            if (i == ratings.length - 1 && candy[i] == 0) {
                candy[i] = 1;
                for (int j = i - 1; j >= leftPeak; j--) {
                    if (j == leftPeak && candy[leftPeak] != 0) {
                        candy[j] = Math.max(candy[j], candy[j + 1] + 1);
                    } else {
                        candy[j] = candy[j+1] + 1;
                    }
                }
            }
        }
        int sum = 0;
        for (int num : candy) {
            sum += num;
        }
        return sum;
    }
}

// Greedy Algorithm
class Solution {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i < ratings.length; i++)
            if(ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        int count = left[ratings.length - 1];
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}
