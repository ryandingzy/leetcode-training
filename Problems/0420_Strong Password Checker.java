/*
len < 6:
    aaaaA1 -> aabaaA1
    insertion meet both conditions 1 & 3
len >= 6 && len <= 20
    only need swap
len > 20:
    aaaa -> aaBa (need 1 swap)
    aaaaa -> aaBaa (need 1 swap) 效率最高，尽量转换成这种
    aaaaaa -> aBaaBa (need 2 swaps)
    delete remaining repeating string length 3 by 3 to meed most 20 characters
    swap to remove repeating string
*/
class Solution {
    private int missingTypes(String s) {
        int needUpper = 1, needLower = 1, needNum = 1;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) needLower = 0;
            if (Character.isUpperCase(c)) needUpper = 0;
            if (Character.isDigit(c)) needNum = 0;
        }
        return needUpper + needLower + needNum;
    }

    private List<Integer> countRepeat(String s) {
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        int count = 1;
        while (idx < s.length()) {
            if (s.charAt(idx) == s.charAt(idx - 1)) count += 1;
            else {
                if (count >= 3) list.add(count);
                count = 1;
            }
            idx++;
        }
        if (count >= 3) list.add(count);
        return list;
    }

    public int strongPasswordChecker(String password) {
        int len = password.length();
        int needTypes = missingTypes(password);
        List<Integer> repeatLens = countRepeat(password);
        if (len < 6) {
            return Math.max(needTypes, 6 - len);
        } else if (len >= 6 && len <= 20) {
            int swapCount = 0;
            for (int l : repeatLens) swapCount += l / 3;
            return Math.max(needTypes, swapCount);
        } else {
            int needRemove = len - 20;
            int idx = 0;
            while (idx < repeatLens.size() && needRemove > 0) {
                int l = repeatLens.get(idx);
                if (l % 3 == 0) {
                    needRemove -= 1;
                    repeatLens.set(idx, l - 1);
                }
                idx += 1;
            }
            idx = 0;
            while (idx < repeatLens.size() && needRemove > 0) {
                int l = repeatLens.get(idx);
                if (l % 3 == 1 && needRemove > 1) {
                    needRemove -= 2;
                    repeatLens.set(idx, l - 2);
                }
                idx += 1;
            }
            idx = 0;
            while (idx < repeatLens.size() && needRemove > 0) {
                int l = repeatLens.get(idx);
                while (l >= 3 && needRemove >= 3) {
                    l -= 3;
                    needRemove -= 3;
                }
                repeatLens.set(idx, l);
                idx += 1;
            }
            int swapCount = 0;
            for (int l : repeatLens) swapCount += l / 3;
            return Math.max(needTypes, swapCount) + len - 20;
        }
    }
}