package ejemplos_TP02.generico;

import java.util.Arrays;

public class Portfolio<T> {
	private T[] data;

	public Portfolio(int capacity) {
//		data = new T[capacity]; // illegal; compiler error
		data = (T[]) new Object[capacity]; // legal, but compiler warning
	}

	public T get(int index) {
		return data[index];
	}

	public void set(int index, T element) {
		data[index] = element;
	}

	public void reverse() {
		int low = 0, high = data.length - 1;
		while (low < high) { // swap data[low] and data[high]
			T temp = data[low];
			data[low++] = data[high]; // post-increment of low
			data[high--] = temp; // post-decrement of high
		}
	}

	public int find(T find) {
		for (int i=0; i<data.length; i++)
			if (data[i].equals(find))
				return i;
		return -1;		
	}
	
	public void swap(int i, int j) {
		T temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	@Override
	public String toString() {
		return "Portfolio [data=" + Arrays.toString(data) + "]";
	}
	
}
