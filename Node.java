public class Node {
    Kendaraan data;
    Node prev;
    Node next;

    public Node(Kendaraan data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
