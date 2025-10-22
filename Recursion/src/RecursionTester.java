public class RecursionTester {
    public static void main(String[] args) throws Exception {
        String[][] array = new String[20][10];
        String[] row = {"a", "b", "c", "d", "vaccinated", "b", "c", "d", "a", "b"};
        for (int i = 0; i < 20; i++) {
            array[i] = row;
        }


        Recursion.infect(array, 5, 5);
        for (String[] r : array) {
            for (String c : r) {
                System.out.print(c + " ");
            }
            System.out.println("");
        }
    }
}
