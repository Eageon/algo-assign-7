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
			if(array[i-1]> array[i])
				return false;
		}
		
		return true;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
