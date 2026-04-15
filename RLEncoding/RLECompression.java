import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class RLECompression {

    // Creates a compressed version with fileName + ".rle.bw"
    public static void compress(String fileName) throws IOException {
        bwTransform(fileName);
        encode(fileName + ".bw");
    }

    // Decompresses a .rle.bw file
    public static void decompress(String fileName) throws IOException {
        decode(fileName);
        invertBWTransform(fileName.substring(0, fileName.length() - 4));
    }

    // Encodes the contents of a file using the RLE compression scheme:
    // single characters are left alone, and runs of 2+ characters are encoded as
    // that letter twice, followed by the length of the run, cast as a char
    public static void encode(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        PrintWriter pw = new PrintWriter(fileName + ".rle");

        char previousChar = (char) br.read();
        int count = 1;

        while (br.ready()) {
            char c = (char) br.read();
            if (c == previousChar) {
                count++;
            } else {
                if (count > 1) {
                    pw.write("" + previousChar + previousChar);
                    pw.write("" + count);
                    count = 1;
                } else {
                    pw.write("" + previousChar);
                }
            }
            previousChar = c;
        }
        if (count > 1) {
            pw.write("" + previousChar + previousChar);
            pw.write("" + count);
            count = 1;
        } else {
            pw.write("" + previousChar);
        }

        br.close();
        pw.close();
    }

    // Decodes the above scheme
    public static void decode(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        PrintWriter pw = new PrintWriter(fileName.substring(0, fileName.length() - 4));

        char previousChar = (char) br.read();

        while (br.ready()) {
            char c = (char) br.read();
            if (c == previousChar) {
                int i =((int)(br.read()-'0'));
                while (i > 0) {
                    pw.write("" + previousChar);
                    i--;
                }
                previousChar = (char) br.read();
            } else {
                pw.write(previousChar);
                previousChar = c;
            }
        }
        if (previousChar != '￿') pw.write(previousChar);

        br.close();
        pw.close();
    }

    public static void bwTransform(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        // Add a null character at the beginning, as a
        // "beginning of file" character
        StringBuilder originalText = new StringBuilder("" + '\0');

        while (br.ready()) {
            char c = (char) br.read();
            originalText.append(c);
        }
        br.close();

        ArrayList<String> rotations = new ArrayList<String>();

        for (int i = 0; i < originalText.length(); i++) {
            String add = originalText.substring(originalText.length()-i) + originalText.substring(0, originalText.length()-i);
            rotations.add(add);
        }
        rotations.sort(String::compareTo);
        // And then write the transformation into a file
       PrintWriter pw = new PrintWriter(fileName + ".bw");
        for (int i = 0; i < originalText.length(); i++) {
            pw.write("" + (rotations.get(i).charAt(originalText.length()-1)));
        }
        pw.close();
    }

    public static void invertBWTransform(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        StringBuilder originalText = new StringBuilder();

        while (br.ready()) {
            char c = (char) br.read();
            originalText.append(c);
        }
        br.close();

        StringBuilder[] reconstructions = new StringBuilder[originalText.length()];
        for (int i = 0; i < reconstructions.length; i++) {
                reconstructions[i] = new StringBuilder("");
            }
        for (int i = 0; i < reconstructions.length; i++) {
            for (int j = 0; j < reconstructions.length; j++) {
                reconstructions[j].insert(0, originalText.charAt(j));
            }
            java.util.Arrays.sort(reconstructions);
        }
    
        String ret = "";
        for (int i = 0; i < reconstructions.length; i++) {
            if (reconstructions[i].charAt(0) == 0) {
                ret = reconstructions[i].toString();
            }
        }

        PrintWriter pw = new PrintWriter(fileName.substring(0, fileName.length() - 3));
        pw.write(ret.substring(1));
        pw.close();
    }
}
