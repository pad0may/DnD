public class BSTtester {
    public static void main(String[] args) {
        MyBST bst = new MyBST<>();

        // BinaryNode node1 = new BinaryNode("1");
        // BinaryNode node2 = new BinaryNode("2");
        // BinaryNode node3 = new BinaryNode("3");
        // BinaryNode node4 = new BinaryNode("4");

        // bst.add("ab");
        // bst.add("ac");
        // bst.add("aa");
        // bst.add("ap");
        // bst.add("ad");

        // bst.add("ab");
        // bst.add("ac");
        // bst.add("aa");
        // bst.add("ap");
        // bst.add("ad");

        // bst.remove("ad");

        // System.out.println(bst.toStringHeight());
        // bst.remove("ac");
        // bst.remove("ap");
        // bst.remove("ab");

        // System.out.println(bst.toStringHeight());
        // System.out.println(bst.getRoot().getValue());

        bst.add("a");
        bst.add("c");
        bst.add("b");
        bst.add("bb");

        // bst.add("a");
        // bst.add("b");
        // bst.add("c");
        

        System.out.println(bst.toStringHeight());

        bst.remove("a");

        System.out.println(bst.toStringHeight());
    }
}
