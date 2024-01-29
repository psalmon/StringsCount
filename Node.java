import java.util.HashSet;
import java.util.Set;

public class Node {
    //Typical doubly LL implementation
    int count;
    final Set<String> keys;
    Node prev;
    Node next;

    public Node() {
        this.count = 0;
        this.keys = new HashSet<>();
    }

    public Node(String key, int count) {
        this.count = count;
        this.keys = new HashSet<>();
        this.keys.add(key);
    }

    // Insert a new node with the given count after this node
    public Node insert(Node newNode) {
        newNode.next = this.next;
        newNode.prev = this;
        this.next.prev = newNode;
        this.next = newNode;
        return newNode;
    }

    // Remove this node from the linked list
    public void remove() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }
}