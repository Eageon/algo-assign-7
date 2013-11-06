public class MergeSort implements Sorter {

	@Override
	public void sort(int[] array) {
		int[] tmpArray = new int[array.length];
		mergeSort(array, tmpArray, 0, array.length - 1);
	}

	private void mergeSort(int[] array, int[] tmpArray, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(array, tmpArray, left, center);
			mergeSort(array, tmpArray, center + 1, right);
			merge(array, tmpArray, left, center + 1, right);
		}
	}

	private void merge(int[] array, int[] tmpArray, int leftPos, int rightPos,
			int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		// Main loop
		while (leftPos <= leftEnd && rightPos <= rightEnd)
			if (array[leftPos] <= array[rightPos])
				tmpArray[tmpPos++] = array[leftPos++];
			else
				tmpArray[tmpPos++] = array[rightPos++];

		while (leftPos <= leftEnd)
			// Copy rest of first half
			tmpArray[tmpPos++] = array[leftPos++];

		while (rightPos <= rightEnd)
			// Copy rest of right half
			tmpArray[tmpPos++] = array[rightPos++];

		// Copy tmpArray back
		for (int i = 0; i < numElements; i++, rightEnd--)
			array[rightEnd] = tmpArray[rightEnd];
	}
}
