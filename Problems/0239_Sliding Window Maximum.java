// treemap
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> treemap = new TreeMap<>();
        int i = 0;
        for (; i < k; i++) {
            if (treemap.containsKey(nums[i])) {
                treemap.put(nums[i], treemap.get(nums[i]) + 1);
            } else {
                treemap.put(nums[i], 1);
            }
            //treemap.put(nums[i], treemap.getOrDefault(nums[i]) + 1);
        }
        res[i-k] = treemap.lastKey();
        for (; i < nums.length; i++) {
            //treemap.put(nums[i], treemap.getOrDefault(nums[i] + 1));
            if (treemap.containsKey(nums[i])) {
                treemap.put(nums[i], treemap.get(nums[i]) + 1);
            } else {
                treemap.put(nums[i], 1);
            }
            int num = treemap.get(nums[i-k]);
            if (num == 1) treemap.remove(nums[i-k]);
            else treemap.put(nums[i-k], num -1);
            res[i-k+1] = treemap.lastKey();
        }
        return res;
    }
}

// better solutions
// deque
class Solution {
  ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
  int [] nums;

  public void clean_deque(int i, int k) {
    // remove indexes of elements not from sliding window
    if (!deq.isEmpty() && deq.getFirst() == i - k)
      deq.removeFirst();

    // remove from deq indexes of all elements 
    // which are smaller than current element nums[i]
    while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])                           deq.removeLast();
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    if (n * k == 0) return new int[0];
    if (k == 1) return nums;

    // init deque and output
    this.nums = nums;
    int max_idx = 0;
    for (int i = 0; i < k; i++) {
      clean_deque(i, k);
      deq.addLast(i);
      // compute max in nums[:k]
      if (nums[i] > nums[max_idx]) max_idx = i;
    }
    int [] output = new int[n - k + 1];
    output[0] = nums[max_idx];

    // build output
    for (int i  = k; i < n; i++) {
      clean_deque(i, k);
      deq.addLast(i);
      output[i - k + 1] = nums[deq.getFirst()];
    }
    return output;
  }
}

// dynamic programming
class Solution {
  ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
  int [] nums;

  public void clean_deque(int i, int k) {
    // remove indexes of elements not from sliding window
    if (!deq.isEmpty() && deq.getFirst() == i - k)
      deq.removeFirst();

    // remove from deq indexes of all elements 
    // which are smaller than current element nums[i]
    while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])                           deq.removeLast();
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    if (n * k == 0) return new int[0];
    if (k == 1) return nums;

    // init deque and output
    this.nums = nums;
    int max_idx = 0;
    for (int i = 0; i < k; i++) {
      clean_deque(i, k);
      deq.addLast(i);
      // compute max in nums[:k]
      if (nums[i] > nums[max_idx]) max_idx = i;
    }
    int [] output = new int[n - k + 1];
    output[0] = nums[max_idx];

    // build output
    for (int i  = k; i < n; i++) {
      clean_deque(i, k);
      deq.addLast(i);
      output[i - k + 1] = nums[deq.getFirst()];
    }
    return output;
  }
}
