import java.util.*;

public class IntegerArray Runnable {
	private static int INITIAL_SIZE=100;
	private int[] array;
	private int count;
	private boolean isSorted;
	
	public IntegerArray() {
		count=0;
		array = new int[INITIAL_SIZE];
		for (int i=0; i<INITIAL_SIZE;i++) {
			array[i]=0;
		}
		isSorted=true;
	}
	
	public void add(int newItem) {
		if (count>array.length-2) {
			createBiggerArray();
		}
		array[count]=newItem;
		count++;
		isSorted=false;
	}
	
	public int get(int value) {
		if (!isSorted) {
			sort();
		}

		for (int i=0;i<count;i++) {
			if (array[i]==value) {
				return value;
			}
		}
		return -1;
	}
	
	public void sort() {
		// the array is padded with zeros for empty cells and so remove them before sorting
		int[] newArray = new int[count];
		for (int i=0;i<array.length;i++) {
			if (array[i]!=0) {
				newArray[i]=array[i];
			}
		}
		mergeSortArray(newArray);
		for (int i=0;i<newArray.length;i++) {
			array[i]=newArray[i];
		}
		//now fill out empty array elements with zeros
		for ( int i=newArray.length ; i<array.length; i++ ) {
			array[i]=0;
		}
	}
	
	public void mergeSortArray(int[] array) {
		//this program edits the incoming array in situ i.e. it destroys its input
		// would normally try to avoid this
		if (array.length<=1) {
			return;
		} else {
			int[] leftArray = splitArray(0, array.length/2, array);
			int[] rightArray = splitArray(array.length/2,array.length, array);
			mergeSortArray(leftArray);
			mergeSortArray(rightArray);
			merge(array, leftArray, rightArray);
		}
	}
	
	public void merge(int[] array, int[] leftArray, int[] rightArray) {
		int a=0; // to navigate array
		int l=0; // to navigate leftArray
		int r=0; // to navigate rightArray
		
		while (a<array.length) {
			if ( (l<leftArray.length) && (r<rightArray.length) ) { 
				// have elements remaining in both arrays so move smallest to target array
				if (leftArray[l]<rightArray[r]) {
					array[a] = leftArray[l];
					l++;
				} else {
					array[a] = rightArray[r];
					r++;
				}
				a++;
			} else {
				if (l<leftArray.length) {
					// only left array elements remain so just insert them into target in order
					while (l<leftArray.length) {
						array[a]=leftArray[l];
						a++;
						l++;
					}
				} else {
					// only right array elements remain so just insert them into target in order
					while (r<rightArray.length) {
						array[a]=rightArray[r];
						a++;
						r++;
					}
				}
			}
		}
	}
	
	public int[] splitArray(int start, int end, int[] array) {
		int newSize = end-start;
		int[] newArray = new int[newSize];
		for (int i=0; i<newSize;i++) {
			newArray[i]=array[start+i];
		}
		return newArray;
	}
	
	public void printArray() {
		if (array.length>0)
			System.out.print(array[0]);
			
		for (int i=1;i<array.length;i++) {
			System.out.print("," + array[i]);
		}
		System.out.println("");
	}
	
	public void createBiggerArray() {
		int[] newArray = new int[count*2];
		for (int i=0; i<count;i++) {
			newArray[i]=array[i];
		}
		for (int i=count; i<newArray.length;i++) {
			newArray[i]=0;
		}
		array=newArray;
	}
}