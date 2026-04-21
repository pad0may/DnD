import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import org.w3c.dom.Node;

class HuffmanNode {
    int num;
    char ch;
    HuffmanNode left;
    HuffmanNode right;

    HuffmanNode(int numb, char cha) {
        num = numb;
        ch = cha;
    }
}

public class Huffman {

    public HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
    public PriorityQueue<HuffmanNode> frequency = new PriorityQueue<>((a, b) -> a.num - b.num);
    public HuffmanNode root;

    public Huffman(String fileName) {
        ReadFile(fileName);
        System.out.println();
    }

    public void ReadFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int charAsInt;
            // Read until the end of the stream (-1 is returned)
            while ((charAsInt = reader.read()) != -1) {
                char character = (char) charAsInt;
                if (hashMap.get(character) == null) {
                    hashMap.put(character, 1);
                } else {
                    hashMap.put(character, hashMap.get(character) + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }

    public void BuildFreqs() {
        Character[] chars = hashMap.keySet().toArray(new Character[0]);
        Integer[] ints = hashMap.values().toArray(new Integer[0]);
        HuffmanNode[] pairs = new HuffmanNode[chars.length];
        for (int i = 0; i < chars.length; i++) {
            pairs[i] = new HuffmanNode(ints[i], chars[i]);
        }
        Arrays.sort(pairs, Comparator.comparingInt(p -> p.num));
        for (HuffmanNode pair : pairs) {
            frequency.add(pair);
        }
    }

    public void BuildTree() {
        HuffmanNode mid = null;
        while (frequency.size() > 1) {
            HuffmanNode left = frequency.poll();
            HuffmanNode right = frequency.poll();
            mid = new HuffmanNode(left.num + right.num, '\0');
            mid.left = left;
            mid.right = right;
            frequency.add(mid);
        }
        root = mid;
    }

    public void BuildReps() {

    }
}