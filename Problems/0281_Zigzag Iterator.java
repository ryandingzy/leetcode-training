public class ZigzagIterator {
    List<List<Integer>> lsts;
    int n = 0;
    List<Integer> ids;
    int turn = 0;
    int num = 2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        lsts = new ArrayList<>();
        lsts.add(v1);
        lsts.add(v2);
        n = v1.size() + v2.size();
        
        ids = new ArrayList<>();
        for (int i = 0; i < num; i++) ids.add(0);
    }

    public int next() {
        while (ids.get(turn) == lsts.get(turn).size()) turn = (turn + 1) % num;
        int res = lsts.get(turn).get(ids.get(turn));
        ids.set(turn, ids.get(turn) + 1);
        turn = (turn + 1) % num;
        n--;
        return res;
    }

    public boolean hasNext() {
        return n > 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
 