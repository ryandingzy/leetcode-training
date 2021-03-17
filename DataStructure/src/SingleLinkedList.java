public class SingleLinkedList {
    private SLNode head = new SLNode(0);

    public void add(SLNode node) {
        SLNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    public void addByOrder (SLNode node)
    {
        SLNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id > node.id) {
                break;
            } else if (temp.next.id == node.id) {
                flag = true;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("exit already");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void update(SLNode node) {
        if (head.next == null) {
            System.out.println("Empty");
            return;
        }

        SLNode temp = head.next;
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

        SLNode temp = head;
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
            temp.next = temp.next.next;
        } else {
            System.out.println("Not found");
        }
    }

    public void showAll() {
        if (head.next == null) {
            System.out.println("Empty");
            return;
        }

        SLNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

class SLNode {
    public int id;
    public int data;
    public SLNode next;
    public SLNode(int data) {
        this.data = data;
        this.next = null;
    }
}