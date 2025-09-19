public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList<>();
        String str1 = "1";
        String str2 = "2";
        String str3 = "3";

        list.add(str1);
        list.add(str2);
        list.add(str3);
        list.add(str1);
        list.add(str2);

        list.remove(1);

    }
}
