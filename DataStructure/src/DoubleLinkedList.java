public class DoubleLinkedList {
    private DLNode head = new DLNode(0);
    public DLNode getHead() { return head; }

    public void add(DLNode node) {
        DLNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void update(DLNode node) {
        if (head.next == null) {
            System.out.println("Empty");
            return;
        }

        DLNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == node.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.data = node.data;
        } else {
            System.out.println("Not found");
        }
    }

    public void delete(int id) {
        if (head.next == null) {
            System.out.println("Empty");
            return;
        }

        DLNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("Not found");
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("Empty");
            return;
        }
        DLNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}


class DLNode {
    public int id;
    public int data;
    public DLNode next;
    public DLNode pre;
    public DLNode(int data) {
        this.data = data;
        this.next = null;
        this.pre = null;
    }
}