import java.util.Scanner;

public class ArrayReader {

	private static final int ARRAY_SIZE = 100;

	public static void main(String[] args) {

		int[] array1 = new int[ARRAY_SIZE];
		int[] array2 = new int[ARRAY_SIZE];

		Scanner scanner = new Scanner(System.in);

		fillArray(array1, scanner, 1);
		fillArray(array2, scanner, 2);

		displayElements(array1, 1);
		displayElements(array2, 2);

		displayCommon(array1, array2);

		displayNonCommonForArray1(array1, array2);
		displayNonCommonForArray2(array1, array2);
	}

	private static void fillArray(int[] array, Scanner scanner, int arrayNumber) {
		for (int i = 0; i < array.length; i++) {

			System.out.print("\nEnter an integer for array " + arrayNumber
					+ ": ");
			int inputValue = scanner.nextInt();

			if (inputValue == 0) {
				break;
			}

			if (!isValueInArrayExist(array, inputValue)) {
				array[i] = inputValue;
			}
		}
	}

	private static boolean isValueInArrayExist(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return true;
			}
		}
		return false;
	}

	private static void displayElements(int[] array, int arrayNumber) {

		System.out.print("\nValues for array " + arrayNumber + " is:");

		for (int i = 0; i < array.length; i++) {

			if (array[i] > 0) {

				System.out.print(" " + array[i]);
			}
		}
	}

	private static void displayCommon(int[] array1, int[] array2) {

		int commonElements = 0;

		System.out.print("\nCommon data is:");

		for (int i = 0; i < array1.length; i++) {
			if (array1[i] > 0 && isValueInArrayExist(array2, array1[i])) {
				System.out.print(" " + array1[i]);
				commonElements = commonElements + 1;
			}
		}

		System.out.print("\nNumber of common data is: " + commonElements);
	}

	private static void displayNonCommonForArray1(int[] array1, int[] array2) {

		System.out.print("\nNon-common values for array 1 is:");

		for (int i = 0; i < array1.length; i++) {
			if (array1[i] > 0 && !isValueInArrayExist(array2, array1[i])) {
				System.out.print(" " + array1[i]);
			}
		}
	}

	private static void displayNonCommonForArray2(int[] array1, int[] array2) {

		System.out.print("\nNon-common values for array 2 is:");

		for (int i = 0; i < array2.length; i++) {
			if (array2[i] > 0 && !isValueInArrayExist(array1, array2[i])) {
				System.out.print(" " + array2[i]);
			}
		}
	}
}