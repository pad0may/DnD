import java.util.LinkedList;

public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList<>();
        LinkedList list2 = new LinkedList();
        String str1 = "1";
        String str2 = "2";
        String str3 = "3";
        String str4 = "4";
        String str5 = "5";
        String nullStr = null;

        // System.out.println(list.size());
        // System.out.println(list2.size());

        list.add(str1);
        list.add(str2);
        list.add(str3);
        list.add(str4);
        list.add(nullStr);
        list.add(str5);

        list2.add(str1);
        list2.add(str2);
        list2.add(str3);
        list2.add(str4);
        list2.add(nullStr);
        list2.add(str5);

        list.remove(0);
        list2.remove(0);

        list.remove("4");
        list2.remove("4");

        list.remove(null);
        list2.remove(null);

        list.add(1, str5);
        list2.add(1, str5);

        list.set(0, nullStr);
        list2.set(0, nullStr);


        // System.out.println(list.contains(null));
        // System.out.println(list2.contains(null));

        // System.out.println(list.indexOf(null));
        // System.out.println(list2.indexOf(null));

        // System.out.println(list.size());
        // System.out.println(list2.size());

        // System.out.println(list.getHead());
        // System.out.println(list2.getFirst());

        // System.out.println(list.getTail());
        // System.out.println(list2.getLast());

        // SinglyLinkedList templist = new SinglyLinkedList<>(null);
        // LinkedList templist2 = new LinkedList<>(null);

        // String[] strArray = new String[0];

        // SinglyLinkedList templist = new SinglyLinkedList<>(strArray);
        // LinkedList templist2 = new LinkedList<>(strArray);


        // list.remove(0);
        // list.remove(0);
        // list.remove(0);
        // list.remove(0);
        // list2.remove(0);
        // list2.remove(0);
        // list2.remove(0);
        // list2.remove(0);
        // System.out.println(list.size());
        // System.out.println(list2.size());
        // list.add(str1);
        // list2.add(str1);
        // System.out.println(list.size());
        // System.out.println(list2.size());

        // System.out.println(list.contains(null));
        // System.out.println(list2.contains(null));

        // System.out.println(list.get(0));
        // System.out.println(list2.get(0));

        // System.out.println(list.remove("5"));
        // System.out.println(list2.remove("5"));
        // System.out.println(list.remove("5"));
        // System.out.println(list2.remove("5"));
        // System.out.println(list.remove(2));
        // System.out.println(list2.remove(2));

        // list.add(0, 1);
        // list2.add(0, 1);
        // list.add(0, "my");
        // list2.add(0, "not");

        // list.add(4, "here");
        // list2.add(4, "here");

        list.add(2, nullStr);
        list.add(2, nullStr);
        list2.add(2, nullStr);
        list2.add(2, nullStr);

        // list.remove(1);
        // list2.remove(1);
        // list.remove(1);
        // list2.remove(1);
        // list.remove(1);
        // list2.remove(1);
        // list.remove(1);
        // list2.remove(1);

        String[] temparray = {null, null};
        SinglyLinkedList templist = new SinglyLinkedList<>(temparray);
        System.out.println(templist);

        System.out.println(list);
        System.out.println(list2);
    }
}
