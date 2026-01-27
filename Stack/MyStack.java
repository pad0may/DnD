import java.util.EmptyStackException;
import java.util.List;

public class MyStack<E> {

    private ListNode<E> head;

    public MyStack() {
        this.head = null;
    }

    public void push(E value) {
        ListNode<E> add = new ListNode<E>(value, head);
        head = add;
    }

    public ListNode<E> pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        ListNode<E> temp = head;
        head = head.getNext();
        return temp;
    }

    public E peek() {
        if (head == null) {
            return null;
        }
        return head.getValue();
    }

    public boolean empty() {
        if (head == null) {
            return true;
        }
        return false;
    }
}