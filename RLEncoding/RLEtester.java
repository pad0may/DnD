import java.io.IOException;

public class RLEtester {
    public static void main(String[] args) throws IOException {
        RLECompression.encode("text");
        RLECompression.decode("text.rle");
        // RLECompression.bwTransform("text");
        // RLECompression.invertBWTransform("text.bw");
    }
}
