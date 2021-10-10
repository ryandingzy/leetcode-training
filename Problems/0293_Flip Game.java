class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> res = new ArrayList<>();
        char[] arr = currentState.toCharArray();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '+' && arr[i-1] == '+') {
                arr[i] = '-';
                arr[i-1] = '-';
                res.add(new String(arr));
                arr[i] = '+';
                arr[i-1] = '+';
            }
        }
        return res;
    }
}
