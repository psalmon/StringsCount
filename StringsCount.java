import java.util.HashMap;
import java.util.Map;

class StringsCount {

    private final Node root = new Node();
    private final Map<String, Node> nodes = new HashMap<>(); // Map for constant-time access to nodes

    public StringsCount() {
        root.next = root;
        root.prev = root;
    }

    public void inc(String key) {
        if (!nodes.containsKey(key)) { // New key
            if (root.next == root || root.next.count > 1) {
                // If it's the root itself, then we're empty. If it's greater than 1
                // that means the next node already represents keys with counts > 1
                nodes.put(key, root.insert(new Node(key, 1)));
            } else {
                // Otherwise, add the key to the existing node with count 1
                root.next.keys.add(key);
                nodes.put(key, root.next);
            }
        } else { // Existing key
            Node current = nodes.get(key);
            Node next = current.next;

            if (next == root || next.count > current.count + 1) {
                // If the next node is the root or has count > current count + 1, insert a new node
                nodes.put(key, current.insert(new Node(key, current.count + 1)));
            } else {
                // Else, add the key to the existing node with an incremented count
                next.keys.add(key);
                nodes.put(key, next);
            }

            // Remove the key from the current node
            current.keys.remove(key);

            // Remove the current node if it becomes empty
            if (current.keys.isEmpty()) {
                current.remove();
            }
        }
    }

    public void dec(String key) {
        Node current = nodes.get(key);

        if (current.count == 1) {
            nodes.remove(key);
        } else {
            Node prev = current.prev;

            if (prev == root || prev.count < current.count - 1) {
                nodes.put(key, prev.insert(new Node(key, current.count - 1)));
            } else {
                // Otherwise, add the key to the existing node with a decremented count
                prev.keys.add(key);
                nodes.put(key, prev);
            }
        }

        // Remove the key from the current node
        current.keys.remove(key);

        // Remove the current node if it becomes empty
        if (current.keys.isEmpty()) {
            current.remove();
        }
    }

    public String getMaxKey() {
        if (root.prev == root) return "";
        return root.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (root.next == root) return "";
        return root.next.keys.iterator().next();
    }
}