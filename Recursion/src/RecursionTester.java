public class RecursionTester {
    public static void main(String[] args) throws Exception {
        // String[][] array = new String[20][10];
        // String[] row = {"a", "b", "c", "d", "vaccinated", "b", "c", "d", "a", "b"};
        // for (int i = 0; i < 20; i++) {
        // array[i] = row;
        // }

        // Recursion.infect(array, 5, 5);
        // for (String[] r : array) {
        // for (String c : r) {
        // System.out.print(c + " ");
        // }
        // System.out.println("");
        // }

        // System.out.println(Recursion.countNonConsecutiveSubsets(9));

        // System.out.println(Recursion.countWaysToJumpUpStairs(1));
        // System.out.println(Recursion.countWaysToJumpUpStairs(2));
        // System.out.println(Recursion.countWaysToJumpUpStairs(3));
        // System.out.println(Recursion.countWaysToJumpUpStairs(4));
        // System.out.println(Recursion.countWaysToJumpUpStairs(5));
        // System.out.println(Recursion.countWaysToJumpUpStairs(6));
        // System.out.println(Recursion.countWaysToJumpUpStairs(7));
        // System.out.println(Recursion.countWaysToJumpUpStairs(8));
        // System.out.println(Recursion.countWaysToJumpUpStairs(9));
        // System.out.println(Recursion.countWaysToJumpUpStairs(10));

        // Recursion.printSubsets("abcde");

        // Recursion.solveHanoi(5);

        int[] times = { 3, 7, 9, 10, 100 };
        int[] points = { 10, 5, 10, 50, 100 };
        System.out.println(Recursion.scavHunt(times, points));
    }
}
