import java.util.EmptyStackException;

public class MyStack<E> {

    private ListNode<E> head;
    private int count;

    public MyStack() {
        this.head = null;
        this.count = 0;
    }

    public void push(ListNode<E> node) {
        if (head == null) {
            head = node;
        }
        node.setNext(head);
        head = node;
        this.count++;
    }

    public ListNode<E> pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        ListNode<E> temp = head;
        head = head.getNext();
        this.count--;
        return temp;
    }

    public E peek() {
        if (head == null) {
            throw new EmptyStackException();
        }
        return head.getValue();
    }

    public boolean empty() {
        return count == 0;
    }
}