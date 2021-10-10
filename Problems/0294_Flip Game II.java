class Solution {
    public boolean canWin(String currentState) {
        if (currentState == null || currentState.length() < 2) return false;
        
        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i+1) == '+') {
                String nextState = currentState.substring(0, i) + "--" + currentState.substring(i + 2);
                if (!canWin(nextState)) return true;
            }
        }
        return false;
    }
}
