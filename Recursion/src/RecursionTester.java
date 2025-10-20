public class RecursionTester {
    public static void main(String[] args) throws Exception {
        String[][] array = new String[2][4];
        String[] row = {"a", "b", "c", "d"};
        array[0] = row;
        array[1] = row;

        Recursion.infect(array, 0, 0);
        for (String[] r : array) {
            for (String c : r) {
                System.out.print(c + " ");
            }
            System.out.println("");
        }
    }
}
