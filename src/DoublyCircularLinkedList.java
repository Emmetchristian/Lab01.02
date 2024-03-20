
/**
 * ADV Comp Sci

 * DoublyCircularLinkedList<T> allows the manipulation of nodes
 * containing generic values. It can operate to adding elements
 * to the front or tail, checking for containment, and adding
 * elements in order
 *
 * @version 02/1/2024
 * @author Emmet Christan
 */

/**
 *
 * @param <T>
 */
public class DoublyCircularLinkedList<T> {
    private DoubleListNode<T> head, tail;
    private int nodeCount;

    public DoublyCircularLinkedList() {
        head = null;
        tail = null;
        nodeCount = 0;
    }

    /**
     * establishes connection between head and tail nodes
     * @param val
     */
    public DoublyCircularLinkedList(T val) {
        head = new DoubleListNode<>(val);
        tail = head;
        head.setNext(tail);
        head.setPrev(tail);
        tail.setNext(head);
        tail.setPrev(head);
        nodeCount++;
    }

    /**
     * adds new node with given value to the front of the list
     * and maintains the structure
     * @param val
     */
    public void addToFront(T val) {
        DoubleListNode<T> newNode = new DoubleListNode<>(val, null, null);
        if (head == null) {
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            head = tail = newNode;

        } else {
            newNode.setNext(head);
            newNode.setPrev(tail);
            head.setPrev(newNode);
            tail.setNext(newNode);
            head = newNode;
        }
        nodeCount++;
    }

    /**
     * adds new node with given value to the tail of the list
     * and maintains the structure
     * @param val
     */
    public void addToTail(T val) {
        DoubleListNode<T> newNode = new DoubleListNode<>(val, null, null);
        if (head == null) {
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            head = tail = newNode;

        } else {
            newNode.setNext(head);
            newNode.setPrev(tail);
            tail.setNext(newNode);
            head.setPrev(newNode);
            tail = newNode;
        }
        nodeCount++;
    }

    /**
     *
     * @return head
     */
    public DoubleListNode<T> getHead() {
        return head;
    }

    /**
     *
     * @return tail
     */
    public DoubleListNode<T> getTail() {
        return tail;
    }

    /**
     *
     * @return nodeCount
     */
    public int getLength() {
        return nodeCount;
    }

    /**
     * generates a string representation of the list so it can be printed
     * handles null values
     * @return sb.toString().trim();
     */
    public String toString() {
        // https://stackoverflow.com/questions/3960712/stringbuilder-append-and-null-values
        StringBuilder sb = new StringBuilder();
        DoubleListNode<T> current = head;

        if (head != null) {
            do {
                sb.append(current.getVal()).append(" ");
                current = current.getNext();
            } while (current != head);
        }

        return sb.toString().trim();
    }

    /**
     * checks whether the list contains a node with a certain val
     * @param val
     * @return true/false
     */
    public boolean contains(T val) {
        for(DoubleListNode<T> temp = head; temp.getNext() != head; temp = temp.getNext()) {
            if(temp.getVal().equals(val)) {
                return true;
            }
        }
        return false;
    }

    /**
     * adds a new node to the Doubly Circular Linked List
     * while maintaining the order based on the natural ordering of the elements.
     * handles insertion at the front, end, and in between
     * throws a ClassCastException if the value is not comparable.
     * @param val
     * @throws Exception
     */
    public void addInOrder(T val) throws Exception {
        if (val instanceof Comparable) {
            Comparable<T> item = (Comparable<T>) val;
            //System.out.println("what is val: " + val);
            DoubleListNode<T> newNode = new DoubleListNode<>(val, null, null);
            //System.out.println(newNode);
            if (head == null) {
                newNode.setNext(newNode);
                newNode.setPrev(newNode);
                head = tail = newNode;
                nodeCount++;
                //System.out.println("added " + newNode);

            }
            else if(item.compareTo(head.getVal()) < 0) {
                addToFront(val);
            }
            // or at the end?
            else if(item.compareTo(tail.getVal()) > 0) {
                addToTail(val);
            }
            else    {
                DoubleListNode<T> temp = head;
                while(temp.getNext() != head && item.compareTo(temp.getVal()) > 0)  {
                    if (item.compareTo(temp.getVal()) == 0) {
                        System.out.println("It's already in the list.");
                        return; // return nothing
                    }
                    temp = temp.getNext();
                }
                newNode.setNext(temp);
                newNode.setPrev(temp.getPrev());
                temp.getPrev().setNext(newNode);
                temp.setPrev(newNode);
                nodeCount++;
            }
        } else
            throw new ClassCastException();
    }
    public void remove(T val)  {
        DoubleListNode<T> temp = head;
        while(temp.getNext() != head && !val.equals(temp.getVal())) {
            temp = temp.getNext();
        }
    }
}

