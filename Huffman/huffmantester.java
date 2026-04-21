public class huffmantester {
    public static void main(String[] args) {
        Huffman code = new Huffman("text.txt");
        code.BuildFreqs();
        code.BuildTree();
    }
}
