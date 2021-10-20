class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');
        set.add('A'); set.add('E'); set.add('I'); set.add('O'); set.add('U');
        
        int left = 0;
        int right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (left < right) {
            if (!set.contains(arr[left])) left++;
            else if (!set.contains(arr[right])) right--;
            else {
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
        return String.valueOf(arr);
    }
}
