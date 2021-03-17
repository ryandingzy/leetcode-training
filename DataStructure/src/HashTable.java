public class HashTable {
    public int size;
    private HTLinkedList[] linkedListArray;
    public HashTable(int size) {
        this.size = size;
        linkedListArray = new HTLinkedList[size];
        // is compulsory
        for (int i = 0; i < size; i++) {
            linkedListArray[i] = new HTLinkedList();
        }
    }

    public void add(HTNode node) {
        int linkId = node.id % size;
       linkedListArray[linkId].add(node);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            linkedListArray[i].list();
        }
    }
}


// define node
class HTNode {
    public int id;
    public int data;
    public HTNode next;
    public HTNode(int id, int data) {
        super();
        this.id = id;
        this.data = data;
    }
}


// define linked list
class HTLinkedList {
    private HTNode head;

    public void add(HTNode node) {
        if (head == null) {
            head = node;
            return;
        }

        HTNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    public void list() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        HTNode temp = head;
        while (true) {
            System.out.print(temp.id + ' ' +  temp.data + '\t');
            if (temp.next == null)
                break;
            temp = temp.next;
        }
        System.out.println();
    }
}
