class Solution {
    public int maximumSwap(int num) {
        List<Integer> lst = new ArrayList<>();
        while (num != 0) {
            lst.add(num % 10);
            num /= 10;
        }
        
        int size = lst.size();
        for (int i = size - 1; i > 0; i--) {
            if (lst.get(i - 1) <= lst.get(i))
                continue;
            int maxId = getMax(lst, 0, i - 1);
            int targetId = binarySearch(lst, i, size - 1, lst.get(maxId));
            // swap
            int temp = lst.get(maxId);
            lst.set(maxId, lst.get(targetId));
            lst.set(targetId, temp);
            break;
        }
        int res = 0;
        for (int i = size - 1; i >= 0; i--) {
            res *= 10;
            res += lst.get(i);
        }
        return res;
    }
    
    private int getMax(List<Integer> lst, int left, int right) {
        int max = lst.get(left);
        int id = left;
        for (int i = left + 1; i <= right; i++) {
            if (lst.get(i) > max) {
                id = i;
                max = lst.get(i);
            }
        }
        return id;
    }
    
    private int binarySearch(List<Integer> lst, int left, int right, int target) {
        if (left == right) return left;
        if (left + 1 == right) {
            return lst.get(right) < target ? right : left;
        }
        int mid = (left + right) / 2;
        if (lst.get(mid) >= target) {
            return binarySearch(lst, left, mid - 1, target);
        } else {
            return binarySearch(lst, mid, right, target);
        }
    }
}
