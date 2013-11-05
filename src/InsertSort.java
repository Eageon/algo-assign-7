public class InsertSort implements Sorter {

	@Override
	public void sort(int[] array) {
		int j;

		for (int p = 1; p < array.length; p++) {
			int tmp = array[p];
			for (j = p; j > 0 && tmp < array[j - 1]; j--)
				array[j] = array[j - 1];
			array[j] = tmp;
		}
	}
}
