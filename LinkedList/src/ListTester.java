public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList<>();
        String str1 = "1";
        String str2 = "2";
        String str3 = "3";
        // String str4 = null;
        String str5 = "5";

        list.add(str1);
        list.add(str2);
        list.add(str3);
        list.add(str1);
        list.add(str2);

        // list.add(3, str4);
        list.add(str5);
        // list.remove("5");
        System.out.println(list.contains(str5));

        System.out.println(list.toString());

    }
}
