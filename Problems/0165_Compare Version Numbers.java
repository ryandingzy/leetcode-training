class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i = 0;
        while (i < arr1.length && i < arr2.length) {
            int num1 = getInt(arr1[i]);
            int num2 = getInt(arr2[i]);
            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
            i++;
        }
        while (i < arr1.length) {
            int num1 = getInt(arr1[i]);
            if (num1 > 0) return 1;
            i++;
        }
        while (i < arr2.length) {
            int num2 = getInt(arr2[i]);
            if (num2 > 0) return -1;
            if (num2 < 0) return 1;
            i++;
        }
        return 0;
    }
    
    public int getInt(String str) {
        if (str == null || str.length() == 0) return 0;
        int start = 0;
        while (start != str.length() - 1 && str.charAt(start) == '0') {
            start++;
        }
        int num = 0;
        for (int i = start; i < str.length(); i++) {
            num = num * 10 + (str.charAt(i) - '0');
        }
        return num;
    }
}
