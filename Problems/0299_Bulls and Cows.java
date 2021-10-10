class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapG = new HashMap<>();
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i< secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) bulls++;
            else {
                if (mapS.containsKey(g)) {
                    cows++;
                    int num = mapS.get(g);
                    if (num == 1) mapS.remove(g);
                    else mapS.put(g, num - 1);
                } else {
                    mapG.put(g, mapG.getOrDefault(g, 0) + 1);
                }
                if (mapG.containsKey(s)) {
                    cows++;
                    int num = mapG.get(s);
                    if (num == 1) mapG.remove(s);
                    else mapG.put(s, num - 1);
                } else {
                    mapS.put(s, mapS.getOrDefault(s, 0) + 1);
                }
            }
        }
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}

// better solution
class Solution {
    public String getHint(String secret, String guess) {
        int[] h = new int[10];
            
        int bulls = 0, cows = 0;
        int n = guess.length();
        for (int idx = 0; idx < n; ++idx) {
            char s = secret.charAt(idx);
            char g = guess.charAt(idx);
            if (s == g) {
                bulls++;    
            } else {
                if (h[s - '0'] < 0) 
                    cows++;
                if (h[g - '0'] > 0)
                    cows++;
                h[s - '0']++;
                h[g - '0']--;
            }
        } 
                
        StringBuilder sb = new StringBuilder();
        sb.append(bulls); 
        sb.append("A"); 
        sb.append(cows); 
        sb.append("B");
        return sb.toString();
    }
}