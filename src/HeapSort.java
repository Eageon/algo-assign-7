public class HeapSort implements Sorter {

	@Override
	public void sort(int[] array) {
		for (int i = array.length / 2 - 1; i >= 0; i--)
			/* buildHeap */
			percDown(array, i, array.length);
		for (int i = array.length - 1; i > 0; i--) {
			swapReferences(array, 0, i); /* deleteMax */
			percDown(array, 0, i);
		}
	}

	private static int leftChild(int i) {
		return 2 * i + 1;
	}

	private void percDown(int[] array, int i, int n) {
		int child;
		int tmp;

		for (tmp = array[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			if (child != n - 1 && array[child] < array[child + 1])
				child++;
			if (tmp < array[child])
				array[i] = array[child];
			else
				break;
		}
		array[i] = tmp;
	}
	
	private final void swapReferences(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
}
