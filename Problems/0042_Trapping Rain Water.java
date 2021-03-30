// First Answer, bad efficiency
/*
class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while(l + 1 < r) {
            if (height[l] <= 0) {
                l++;
                continue;
            }
            if (height[r] <= 0) {
                r--;
                continue;
            }
            for (int i = l; i <= r; i++) {
                if (height[i] == 0) {
                    res++;
                } else {
                    height[i]--;
                }
            }
        }
        return res;
    }
}
*/

// Dynamic programming
class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int[] leftH = new int[height.length];
        int[] rightH = new int[height.length];
        int max = 0;
        leftH[0] = 0;
        for (int i = 1; i < height.length; i++) {
            leftH[i] = Math.max(leftH[i-1], height[i-1]);
        }
        rightH[height.length-1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            rightH[i] = Math.max(rightH[i+1], height[i+1]);
        }
        int sum = 0;
        int h = 0;
        for (int i = 0; i < height.length; i++) {
            h = Math.min(leftH[i], rightH[i]);
            if (h > height[i]) {
                sum += h - height[i];
            }
        }
        return sum;
    }
}

// optimize dynamic programming
/*
public int trap(int[] height) {
    int sum = 0;
    int max_left = 0;
    int max_right = 0;
    int left = 1;
    int right = height.length - 2; // 加右指针进去
    for (int i = 1; i < height.length - 1; i++) {
        //从左到右更
        if (height[left - 1] < height[right + 1]) {
            max_left = Math.max(max_left, height[left - 1]);
            int min = max_left;
            if (min > height[left]) {
                sum = sum + (min - height[left]);
            }
            left++;
        //从右到左更
        } else {
            max_right = Math.max(max_right, height[right + 1]);
            int min = max_right;
            if (min > height[right]) {
                sum = sum + (min - height[right]);
            }
            right--;
        }
    }
    return sum;
}

*/

// stack solution
/*
public int trap6(int[] height) {
    int sum = 0;
    Stack<Integer> stack = new Stack<>();
    int current = 0;
    while (current < height.length) {
        //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
        while (!stack.empty() && height[current] > height[stack.peek()]) {
            int h = height[stack.peek()]; //取出要出栈的元素
            stack.pop(); //出栈
            if (stack.empty()) { // 栈空就出去
                break; 
            }
            int distance = current - stack.peek() - 1; //两堵墙之前的距离。
            int min = Math.min(height[stack.peek()], height[current]);
            sum = sum + distance * (min - h);
        }
        stack.push(current); //当前指向的墙入栈
        current++; //指针后移
    }
    return sum;
}

*/