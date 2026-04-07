import java.math.BigInteger;

public class MiniGPTTester {
    public static void main(String[] args) {
        MiniGPT gatsby = new MiniGPT("lawsuit.txt", 5);
        gatsby.generateText("lawsuit2.txt", 100000);
    }
}
