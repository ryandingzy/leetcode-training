class Solution {
    String zero = "zero";
    String one = "one";
    String two = "two";
    String three = "three";
    String four = "four";
    String five = "five";
    String six = "six";
    String seven = "seven";
    String eight = "eight";
    String nine = "nine";

    private Map<Character, Integer> countStr(String str) {
        Map<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            res.put(str.charAt(i), res.getOrDefault(str.charAt(i), 0) + 1);
        }
        return res;
    }

    private void removeAll(Map<Character, Integer> sMap, String num, int count) {
        Map<Character, Integer> numMap = countStr(num);
        for (Map.Entry<Character, Integer> entry : numMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (sMap.get(key) == value * count) {
                sMap.remove(key);
            } else {
                sMap.put(key, sMap.get(key) - value * count);
            }
        }
    }

    public String originalDigits(String s) {
        Map<Character, Integer> sMap = countStr(s);
        Map<Integer, Integer> countMap = new HashMap<>();
        //zero
        if (sMap.containsKey('z')) {
            int count = sMap.get('z');
            countMap.put(0, count);
            removeAll(sMap, zero, count);
        }
        // two
        if (sMap.containsKey('w')) {
            int count = sMap.get('w');
            countMap.put(2, count);
            removeAll(sMap, two, count);
        }
        // four
        if (sMap.containsKey('u')) {
            int count = sMap.get('u');
            countMap.put(4, count);
            removeAll(sMap, four, count);
        }
        // six
        if (sMap.containsKey('x')) {
            int count = sMap.get('x');
            countMap.put(6, count);
            removeAll(sMap, six, count);
        }
        // eight
        if (sMap.containsKey('g')) {
            int count = sMap.get('g');
            countMap.put(8, count);
            removeAll(sMap, eight, count);
        }
        // one
        if (sMap.containsKey('o')) {
            int count = sMap.get('o');
            countMap.put(1, count);
            removeAll(sMap, one, count);
        }
        // three
        if (sMap.containsKey('h')) {
            int count = sMap.get('h');
            countMap.put(3, count);
            removeAll(sMap, three, count);
        }
        // five
        if (sMap.containsKey('f')) {
            int count = sMap.get('f');
            countMap.put(5, count);
            removeAll(sMap, five, count);
        }
        // seven
        if (sMap.containsKey('s')) {
            int count = sMap.get('s');
            countMap.put(7, count);
            removeAll(sMap, seven, count);
        }
        // nine
        if (sMap.containsKey('i')) {
            int count = sMap.get('i');
            countMap.put(9, count);
            removeAll(sMap, nine, count);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (countMap.containsKey(i)) {
                for (int j = 0; j < countMap.get(i); j++) {
                    sb.append((char)('0' + i));
                }
            }
        }
        return sb.toString();
    }
}
