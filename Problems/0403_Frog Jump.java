// My solution
class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp.add(new HashSet<Integer>());
        }
        dp.get(0).add(1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int gap = stones[i] - stones[j];
                if (dp.get(j).contains(gap)) {
                    dp.get(i).add(gap - 1);
                    dp.get(i).add(gap);
                    dp.get(i).add(gap + 1);
                } else if (gap > j + 1) break;
            }
        }
        return !dp.get(n-1).isEmpty();
    }
}


