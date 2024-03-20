import java.util.*;
import java.io.*;
import java.util.LinkedList;

/**
 * ADV Comp Sci

 *
 * difines nodes for the doubly linked list
 * includes methods to get and set the nodes values
 * constructors for initializing instances of the node
 *
 *
 *
 * @version 02/1/2024
 * @author Emmet Christan
 *
 */


public class DoubleListNode<T> {
    private T val;
    private DoubleListNode<T> next;
    private DoubleListNode<T> prev;

    /**
     *
     * @return val
     */
    public T getVal() {
        return val;
    }

    /**
     * sets val of node
     * @param val
     */
    public void setVal(T val) {
        this.val = val;
    }

    /**
     *
     * @return next
     */
    public DoubleListNode<T> getNext() {
        return next;
    }

    /**
     * sets next
     * @param next
     */
    public void setNext(DoubleListNode<T> next) {
        this.next = next;
    }

    /**
     *
     * @return prev
     */
    public DoubleListNode<T> getPrev() {
        return prev;
    }

    /**
     * sets prev
     * @param prev
     */
    public void setPrev(DoubleListNode<T> prev) {
        this.prev = prev;
    }

    /**
     * initializes with given val, setts both next and prev to null
     * @param t
     */
    public DoubleListNode(T t) {
        this.val = t;
        next = null;
        prev = null;
    }

    /**
     * initialzies node with given val and specifies next and prev nodes
     * @param t
     * @param next
     * @param prev
     */
    public DoubleListNode(T t, DoubleListNode<T> next, DoubleListNode<T> prev)  {
        this.val = t;
        this.next = next;
        this.prev = prev;
    }

    /**
     * initialzies node with given val and specifies val, next and prev
     * @param node
     */
    public DoubleListNode(DoubleListNode<T> node)      {
        this.val = node.val;
        this.next = node.next;
        this.prev = node.prev;
    }

    /**
     *
     * @return ""+val;
     */
    public String toString()        {
        return ""+val;
    }

}
