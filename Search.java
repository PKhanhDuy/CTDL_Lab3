package lab_3;

import java.util.Arrays;

public class Search {
	private int[] array;

	public Search(int[] array) {
		super();
		this.array = array;
	}

	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target)
				return i;
		}
		return -1;
	}

// phương thức bổ trợ tìm kiếm tuyến tính dùng đệ quy 
	public int recursiveLinearSearch(int target) {
		if (array[0] == target)
			return 0;
		return recursive(target, array.length - 1);
	}

// phương thức bổ trợ tìm kiếm đệ quy
	public int recursive(int target, int size) {
		if (size < 1)
			return -1;
		if (array[size] == target)
			return size;
		return recursive(target, size - 1);
	}

// phương thức tìm kiếm nhị phân tuyến tính.s
	public int iterativeBinarySearch(int target) {
		Arrays.sort(array);
		int start = 0;
		int end = array.length - 1;
		int mid = -1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (array[mid] == target)
				return mid;
			if (array[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

// tìm kiếm một phần tử trong một mảng bằng kiểu tìm kiếm nhị phân dùng đệ quy
	public int recursiveBinarySearch(int target) {
		Arrays.sort(array);
		for (int i : array) {
			System.out.print(i + " ");
		}
		return recursiveBinary(target, 0, array.length - 1);
	}

//phương thức bổ trợ dùng để tìm kiếm phần tử trong một mảng theo tìm kiếm nhị phân dùng đệ quy.
	public int recursiveBinary(int target, int start, int end) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		if (target == array[mid])
			return mid;
		if (target < array[mid]) {
			return recursiveBinary(target, start, mid - 1);
		} else {
			return recursiveBinary(target, mid + 1, end);
		}
	}

	public static void main(String[] args) {
		int[] array = { 12, 32, 24, 5, 2, 65, 2, 13, 14 };
		Search searchArray = new Search(array);
//		System.out.println(searchArray.iterativeLinearSearch(14));
//		System.out.println(searchArray.recursiveLinearSearch(2));
//		System.out.println(searchArray.iterativeBinarySearch(32));
		System.out.println(searchArray.recursiveBinarySearch(5));

	}

}
