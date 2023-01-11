class MyCalendar {
    private TreeMap<Integer, Integer> tm;

    public MyCalendar() {
        tm = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        if (tm.containsKey(start)) return false;
        Map.Entry<Integer, Integer> leftEntry = tm.floorEntry(start);
        if (leftEntry != null && leftEntry.getValue() > start) return false;
        Map.Entry<Integer, Integer> rightEntry = tm.ceilingEntry(start);
        if (rightEntry != null && rightEntry.getKey() < end) return false;
        tm.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
 