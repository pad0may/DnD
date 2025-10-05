public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList<>();
        String str1 = "1";
        String str2 = "2";
        String str3 = "3";
        String str4 = null;
        String str5 = "5";

        list.add(str1);
        list.add(str2);
        list.add(str3);
        list.add(str1);
        list.add(str2);

        list.add(0, str4);
        // list.add(str5);
        list.remove("1");
        list.remove("2");
        list.remove("3");
        list.remove(null);
        list.remove("1");
        list.remove("5");
        list.remove("2");
        // System.out.println(list.contains(str5));
        // list.set(0, str5);
        // System.out.println(list.indexOf("2"));

        System.out.println(list.toString());
        // list.remove(5);
        System.out.println(list.toString());
        // System.out.println(list.getTail().getValue());

    }
}
