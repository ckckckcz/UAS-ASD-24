public class DLL {
    private Node head;
    private Node tail;

    public DLL() {
        this.head = null;
        this.tail = null;
    }

    public void insert(Kendaraan data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public Node getHead() {
        return head;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            current.data.printKdr();
            current = current.next;
        }
    }
}
