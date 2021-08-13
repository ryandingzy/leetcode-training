class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int containsGas = 0;
        int start = 0;
        int i = 0;
        while (true) {
            int station = i % gas.length;
            if (start == gas.length) return -1;
            if (containsGas < 0) {
                containsGas = containsGas - gas[start] + cost[start];
                start++;
            } else {
                containsGas = containsGas + gas[station] - cost[station];
                i++;
                if (i % gas.length == start && containsGas >= 0) return start;
            }
        }
    }
}


// Better solution
public int canCompleteCircuit(int[] gas, int[] cost) {
    int len = gas.length;
    int spare = 0;
    int minSpare = Integer.MAX_VALUE;
    int minIndex = 0;

    for (int i = 0; i < len; i++) {
        spare += gas[i] - cost[i];
        if (spare < minSpare) {
            minSpare = spare;
            minIndex = i;
        }
    }

    return spare < 0 ? -1 : (minIndex + 1) % len;
}

