package Study;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {12, 56, 78, 65, 7, 45, 6, 85};
		
		bubbleSort(arr);
		
		System.out.println("Sorted array:");
		for (int value : arr) {
			System.out.print(value + " ");
		}
		
	}
	static void bubbleSort(int[] arr) {
		int n = arr.length;
		boolean swapped;
		
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for(int j= 0; j < n - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					// Swap arr[j] and arr[j + 1]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			// If no element were swapped, array is sorted
			if (! swapped) break;
		}
		
		

	}

}
