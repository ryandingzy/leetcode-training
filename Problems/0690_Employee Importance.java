/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        int res = 0;
        while (!q.isEmpty()) {
            Employee e = map.get(q.poll());
            res += e.importance;
            for (Integer s : e.subordinates) {
                q.offer(s);
            }
        }
        return res;
    }
}
