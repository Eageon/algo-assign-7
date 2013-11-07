public class QuickSort implements Sorter {

	private static final int CUTOFF = 10;

	@Override
	public void sort(int[] array) {
		quicksort(array, 0, array.length - 1);
	}

	private int median3(int[] array, int left, int right) {
		int center = (left + right) / 2;
		if (array[center] < array[left])
			swapReferences(array, left, center);
		if (array[right] < array[left])
			swapReferences(array, left, right);
		if (array[right] < array[center])
			swapReferences(array, center, right);

		// Place pivot at position right - 1
		swapReferences(array, center, right - 1);
		return array[right - 1];
	}

	private void quicksort(int[] array, int left, int right) {
		if (left + CUTOFF <= right) {
			int pivot = median3(array, left, right);

			// Begin partitioning
			int i = left, j = right - 1;
			for (;;) {
				while (array[++i] < pivot) { }
				while (array[--j] > pivot) { }
				if (i < j)
					swapReferences(array, i, j);
				else
					break;
			}

			swapReferences(array, i, right - 1); // Restore pivot

			quicksort(array, left, i - 1); // Sort small elements
			quicksort(array, i + 1, right); // Sort large elements
		} else {
			// Do an insertion sort on the subarray
			insertionSort(array, left, right);
		}
	}

	private final void swapReferences(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	private void insertionSort(int[] array, int left, int right) {
		int j;

		for (int p = left + 1; p < right - left + 1; p++) {
			int tmp = array[p];
			for (j = p; j > left && tmp < array[j - 1]; j--)
				array[j] = array[j - 1];
			array[j] = tmp;
		}
	}
}
