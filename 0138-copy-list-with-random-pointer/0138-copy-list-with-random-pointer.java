/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    void insertCopyInBetween(Node head) {
        Node temp = head;
        while (temp != null) {
            Node nextNode = temp.next;
            Node copy = new Node(temp.val);
            temp.next = copy;
            copy.next = nextNode;
            temp = nextNode;
        }
    }
    void connectRandomPointers(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copyNode = temp.next;
            if (temp.random != null) {
                copyNode.random = temp.random.next;
            }
            temp = copyNode.next;
        }
    }
    Node separateLists(Node head) {
        Node temp = head;
        Node dummy = new Node(-1);
        Node copyTail = dummy;
        while (temp != null) {
            Node copyNode = temp.next;
            copyTail.next = copyNode;
            copyTail = copyNode;
            temp.next = copyNode.next;
            temp = temp.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        insertCopyInBetween(head);
        connectRandomPointers(head);
        return separateLists(head);
    }
}