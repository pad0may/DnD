public class MiniGPTTester {
    public static void main(String[] args) {
        MiniGPT gatsby = new MiniGPT("thegreatgatsby.txt", 6);
        gatsby.generateText("gatsby2.txt", 100000);
    }
}
