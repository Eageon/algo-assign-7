import java.util.Random;

public class Array {
	int[] array;

	public Array(int n) {
		array = new int[n];
	}

	public void initialize() {
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
	}

	public void shuffle() {
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			// The parameter specify the up limit of random but exclusive.
			// To make the i inclusive, use i+1 as parameter, i+1 is exclusive
			int swap = array[i];
			array[i] = array[j];
			array[j] = swap;
		}
	}

	public void sort(Sorter sorter) {
		sorter.sort(array);
	}

	public boolean verify() {
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] > array[i])
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int runTimes = 1000;
		int[] ns = { 10000, 50000, 100000, 200000, 400000, 800000 };
		long[][] runningTimeOfNtimes = new long[4][ns.length];
		Array array;

		for (int i = 0; i < ns.length; i++) {
			int n = ns[i];
			array = new Array(n);
			array.initialize();
			for (int j = 0; j < runTimes; j++) {
				array.shuffle();
				runningTimeOfNtimes[0][i] += TestofAlgorithm(array,
						new HeapSort());
				if (!array.verify()) {
					System.out
							.println("HeapSort is not correct for array size "
									+ n);
					break;
				}
				if ((j + 1) % 100 == 0)
					System.out.println((j / 100) * 100
							+ " times for HeapSort of " + n);
			}

			for (int j = 0; j < runTimes; j++) {
				array.shuffle();
				runningTimeOfNtimes[1][i] += TestofAlgorithm(array,
						new InsertSort());
				if (!array.verify()) {
					System.out
							.println("InsertSort is not correct for array size "
									+ n);
					break;
				}
				if ((j + 1) % 100 == 0)
					System.out.println((j / 100) * 100
							+ " times for InsertSort of " + n);
			}

			for (int j = 0; j < runTimes; j++) {
				array.shuffle();
				runningTimeOfNtimes[2][i] += TestofAlgorithm(array,
						new MergeSort());
				if (!array.verify()) {
					System.out
							.println("MergeSort is not correct for array size "
									+ n);
					break;
				}
				if ((j + 1) % 100 == 0)
					System.out.println((j / 100) * 100
							+ " times for MergeSort of " + n);
			}

			for (int j = 0; j < runTimes; j++) {
				array.shuffle();
				runningTimeOfNtimes[3][i] += TestofAlgorithm(array,
						new QuickSort());
				if (!array.verify()) {
					System.out
							.println("QuickSort is not correct for array size "
									+ n);
					break;
				}
				if ((j + 1) % 100 == 0)
					System.out.println((j / 100) * 100
							+ " times for QuickSort of " + n);
			}
		}

		System.out.println(runningTimeOfNtimes);
	}

	public static final long TestofAlgorithm(Array array, Sorter sorter) {
		long startTime = System.currentTimeMillis();
		array.sort(sorter);
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
}
