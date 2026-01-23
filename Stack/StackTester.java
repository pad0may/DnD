public class StackTester {
    public static void main(String[] args) {
        MyStack stack = new MyStack<>();

        System.out.println(stack.empty());
        ListNode a = new ListNode("a");
        ListNode b = new ListNode("b");
        ListNode c = new ListNode("c");
        stack.push(a);
        stack.push(b);
        stack.push(c);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.empty());
    }
}
