import java.util.ArrayList;

public class TestDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        ArrayList<Nucleotide> list2 = new ArrayList<Nucleotide>();
        Nucleotide A = Nucleotide.A;
        Nucleotide G = Nucleotide.G;
        Nucleotide C = Nucleotide.C;
        Nucleotide T = Nucleotide.T;

        // list.add(A);
        list.add(G);
        list.add(C);
        list.add(C);
        list.add(A);
        list.add(G);
        list.add(G);
        list.add(T);

        list2.add(G);
        list2.add(C);
        list2.add(C);
        list2.add(A);
        list2.add(G);
        list2.add(G);
        list2.add(T);

        // System.out.println(list.indexOf(T));

        // list.remove(A);
        // list.remove(T);
        // list.remove(C);
        // list.remove(T);

        // System.out.println(list.get(8));
        // System.out.println(list.get(51));

        // list.remove(8);

        // DoublyLinkedList templist = new DoublyLinkedList();

        // templist.add(A);
        // templist.add(G);
        // templist.add(C);
        // templist.add(C);
        // templist.add(A);
        // templist.add(G);
        // templist.add(G);
        // templist.add(T);

        // list.add(T);
        // for (int i = 0; i < 16; i++) {
        // list.add(A);
        // }
        // list.add(G);
        // ListNode2 node = new ListNode2<Nucleotide>(T);
        // list.removeCCCCCCCCGGGGGGGG(node);


        // list.addSegmentToEnd(templist);

        // DoublyLinkedList dellist = new DoublyLinkedList();
        // dellist.add(A);
        // dellist.add(G);
        // dellist.add(G);
        // dellist.add(T);


        // System.out.println(list);
        // System.out.println(list.size());
        // System.out.println(list.deleteSegment(dellist));

        // list.deleteLastThree();

        // list.add(A);
        // list.replaceEveryAWithTAC();
        // System.out.println(list);

        list.add(2, Nucleotide.T);
        // System.out.println(list.getNode(2).getValue());
        // System.out.println(list.getNode(2).getPrevious().getValue());
        // System.out.println(list.getNode(2).getNext().getValue());

        // System.out.println(list.set(1, T));

        // System.out.println(list.getNode(0).getValue());

        // list.remove(7);
        // System.out.println(list.get(8));

        System.out.println(list);

        // list.deleteLastThree();
        // System.out.println(list2);
        // System.out.println(list.size());
    }
}
