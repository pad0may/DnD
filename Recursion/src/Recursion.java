import java.util.ArrayList;

public class Recursion {

	// Prints the value of every node in the singly linked list with the given head,
	// but in reverse
	public static void printListInReverse(ListNode head) {

	}

	// For the given 2D array of Strings, replaces the String at index[r][c]
	// with "infected" unless the String is "vaccinated";
	// also, any Strings they are orthogonally adjacent to
	// that are not "vaccinated" will also be infected, and any adjacent to
	// them as well etc.
	// Infecting someone who is already infected has no effect
	// Trying to infect outside the confines of the grid also has no effect
	// Precondition: grid has no null entries
	public static void infect(String[][] grid, int r, int c) {
		if (!grid[r][c].equals("vaccinated") && !grid[r][c].equals("infected")) {
			grid[r][c] = "infected";
		} else {
			return;
		}
		if (r > 0 && !grid[r - 1][c].equals("vaccinated")) {
			// grid[r - 1][c] = "infected";
			infect(grid, r - 1, c);
		}
		if (r < grid.length - 1 && !grid[r + 1][c].equals("vaccinated")) {
			// grid[r + 1][c] = "infected";
			infect(grid, r + 1, c);
		}
		if (c > 0 && !grid[r][c - 1].equals("vaccinated")) {
			// grid[r][c - 1] = "infected";
			infect(grid, r, c - 1);
		}
		if (c < grid[0].length - 1 && !grid[r][c + 1].equals("vaccinated")) {
			// grid[r][c + 1] = "infected";
			infect(grid, r, c + 1);
		}
	}

	// How many subsets are there of the numbers 1...n
	// that don't contain any consecutive integers?
	// e.g. for n = 4, the subsets are {}, {1}, {2}, {3}, {4},
	// {1, 3}, {1, 4}, {2, 4}
	// The other subsets of 1,2,3,4 that DO contain consecutive integers are
	// {1,2}, {2,3}, {3,4}, {1,2,3}, {1,2,4}, {1,3,4}, {1,2,3,4}
	// Precondition: n > 0
	public static long countNonConsecutiveSubsets(int n) {
		if (n <= 1)
			return n + 1;
		return countNonConsecutiveSubsets(n - 1) + countNonConsecutiveSubsets(n - 2);
	}

	// A kid at the bottom of the stairs can jump up 1, 2, or 3 stairs at a time.
	// How many different ways can they jump up n stairs?
	// Jumping 1-1-2 is considered different than jumping 1-2-1
	// Precondition: n > 0
	public static long countWaysToJumpUpStairs(int n) {
		if (n <= 2)
			return n / 2 + 1;
		return countWaysToJumpUpStairs(n - 1) + countWaysToJumpUpStairs(n - 2) + countWaysToJumpUpStairs(n - 3);
	}

	// Everything above this line does NOT require a recursive helper method
	// ----------------------------------
	// Everything below this line requires a recursive helper method
	// Any recursive helper method you write MUST have a comment describing:
	// 1) what the helper method does/returns
	// 2) your description must include role of each parameter in the helper method

	// Prints all the subsets of str on separate lines
	// You may assume that str has no repeated characters
	// For example, subsets("abc") would print out "", "a", "b", "c", "ab", "ac",
	// "bc", "abc"
	// Order is your choice
	public static void printSubsets(String str) {
		ArrayList<String> arr = new ArrayList<>();
		arr.add("");
		ArrayList<String> ret = subsetPrinter(arr, str);
		for (int i = 0; i < ret.size(); i++) {
			System.out.println(ret.get(i));
		}
	}

	private static ArrayList<String> subsetPrinter(ArrayList<String> arr, String str) {
		ArrayList<String> array = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			array.add(arr.get(i) + str.substring(0, 1));
		}
		for (int i = 0; i < array.size(); i++) {
			arr.add(array.get(i));
		}
		if (str.length() <= 1) {
			return arr;
		}
		return subsetPrinter(arr, str.substring(1));
	}

	// List contains a single String to start.
	// Prints all the permutations of str on separate lines
	// You may assume that str has no repeated characters
	// For example, permute("abc") could print out "abc", "acb", "bac", "bca",
	// "cab", "cba"
	// Order is your choice
	public static void printPermutations(String str) {
		ArrayList<String> arr = new ArrayList<>();
		arr.add("");
		ArrayList<String> ret = permutationPrinter(arr, str);
		for (int i = 0; i < ret.size(); i++) {
			System.out.println(ret.get(i));
		}
	}

	private static ArrayList<String> permutationPrinter(ArrayList<String> arr, String str) {
		if (str.length() == 0) {
			return arr;
		}
		ArrayList<String> ret = new ArrayList<>();
		char curChar = str.charAt(0);
		for (String s : arr) {
			for (int i = 0; i <= s.length(); i++) {
				ret.add(s.substring(0, i) + curChar + s.substring(i));
			}
		}
		return permutationPrinter(ret, str.substring(1));
	}

	// Performs a mergeSort on the given array of ints
	// Precondition: you may assume there are NO duplicates!!!
	public static void mergeSort(int[] ints) {
		mergeSort(ints, 0, ints.length - 1);
	}

	private static void mergeSort(int[] ints, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		int midIndex = (startIndex + endIndex) / 2;
		mergeSort(ints, startIndex, midIndex);
		mergeSort(ints, midIndex + 1, endIndex);
		sortMerge(ints, startIndex, midIndex, midIndex + 1, endIndex);
	}

	private static void sortMerge(int[] ints, int start1, int end1, int start2, int end2) {
		int[] firstHalf = new int[end1 - start1 + 1];
		int[] secondHalf = new int[end2 - start2 + 1];
		int newI = 0;
		for (int i = start1; i <= end1; i++, newI++) {
			firstHalf[newI] = ints[i];
		}
		newI = 0;
		for (int i = start2; i <= end2; i++, newI++) {
			secondHalf[newI] = ints[i];
		}
		int firstI = 0;
		int secondI = 0;
		int i = 0;
		while (firstI < firstHalf.length && secondI < secondHalf.length) {
			if (firstHalf[firstI] < secondHalf[secondI]) {
				ints[i++] = firstHalf[firstI++];
			} else {
				ints[i++] = secondHalf[secondI++];
			}
		}
	}

	// Performs a quickSort on the given array of ints
	// Use the middle element (index n/2) as the pivot
	// Precondition: you may assume there are NO duplicates!!!
	public static void quickSort(int[] ints) {
		ArrayList<Integer> intArr = new ArrayList<>();
		for (int i = 0; i < ints.length; i++) {
			intArr.add(ints[i]);
		}
		ArrayList<Integer> arr = sortQuick(intArr);
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

	private static ArrayList<Integer> sortQuick(ArrayList<Integer> ints) {
		if (ints.size() <= 1) {
			return ints;
		}
		int pivot = ints.size() / 2;
		int pivotVal = ints.get(pivot);
		ArrayList<Integer> less = new ArrayList<>();
		ArrayList<Integer> more = new ArrayList<>();
		for (int i = 0; i < ints.size(); i++) {
			if (ints.get(i) > pivotVal) {
				more.add(ints.get(i));
			}
			if (ints.get(i) < pivotVal) {
				less.add(ints.get(i));
			}
		}
		less = sortQuick(less);
		more = sortQuick(more);
		less.add(pivotVal);
		for (int i = 0; i < more.size(); i++) {
			less.add(more.get(i));
		}
		return less;
	}

	// Prints a sequence of moves (one on each line)
	// to complete a Towers of Hanoi problem:
	// disks start on tower 0 and must end on tower 2.
	// The towers are number 0, 1, 2, and each move should be of
	// the form "1 -> 2", meaning "take the top disk of tower 1 and
	// put it on tower 2" etc.
	public static void solveHanoi(int startingDisks) {
		hanoiSolver(startingDisks, "0", "2", "1");
	}

	private static void hanoiSolver(int disks, String from, String to, String other) {
		if (disks == 1) {
			System.out.println(from + " -> " + to);
			return;
		}
		hanoiSolver(disks - 1, from, other, to);
		System.out.println(from + " -> " + to);
		hanoiSolver(disks - 1, other, to, from);
	}

	// You are partaking in a scavenger hunt!
	// You've gotten a secret map to find many of the more difficult
	// items, but they are only available at VERY specific times at
	// specific places. You have an array, times[], that lists at which
	// MINUTE an item is available. Times is sorted in ascending order.
	// Items in the ScavHunt are worth varying numbers of points.
	// You also have an array, points[], same length as times[],
	// that lists how many points each of the corresponding items is worth.
	// Problem is: to get from one location to the other takes 5 minutes,
	// so if there is an item, for example, available at time 23 and another
	// at time 27, it's just not possible for you to make it to both: you'll
	// have to choose!
	// (but you COULD make it from a place at time 23 to another at time 28)
	// Write a method that returns the maximum POINTS you can get.
	// For example, if times = [3, 7, 9]
	// and points = [10, 15, 10]
	// Then the best possible result is getting the item at time 3 and the one at
	// time 9
	// for a total of 20 points, so it would return 20.
	public static int scavHunt(int[] times, int[] points) {
		if (times[times.length - 2] == 0) {
			return points[points.length - 1];
		}
		int[] times2 = times.clone();
		int[] points2 = points.clone();
		int largest = 0;
		int prevTime = 0;
		for (int i = 0; i < times.length; i++) {
			times2[i] = 0;
			points2[i] = 0;
			if (times[i] != 0 && prevTime == 0) {
				prevTime = times[i];
				largest = points[i];
				break;
			}

		}
		for (int i = 0; i < times.length; i++) {
			if (times[i] != 0) {
				if (times[i] - 5 >= prevTime) {
					largest += scavHunt(times, points);
				}
				times[i] = 0;
				points[i] = 0;
			}
		}
		int next = scavHunt(times2, points2);
		if (next > largest) {
			largest = next;
		}
		return largest;

	}

}
