package learn.l1;
import java.util.Arrays;

public class SortIntArray {

	public static void main(String[] args) {
		int[] array = new int[]{2,5,1,0,89,34,12,-1,56,100,22,3,5,1};
		mergeSortIntArray(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));

	}
	
	public static void mergeSortIntArray(int[] array, int min, int max) {
	    if (max <= min) return;
	    int mid = (min+max)/2;
	    mergeSortIntArray(array, min, mid);
	    mergeSortIntArray(array, mid+1, max);
	    merge(array, min, mid, max);
	}
	
	public static void merge(int[] array, int min, int mid, int max) {
	    int leftArray[] = new int[mid - min + 1];
	    int rightArray[] = new int[max - mid];

	    for (int i = 0; i < leftArray.length; i++)
	        leftArray[i] = array[min + i];
	    for (int i = 0; i < rightArray.length; i++)
	        rightArray[i] = array[mid + i + 1];

	    int leftIndex = 0;
	    int rightIndex = 0;

	    for (int i = min; i < max + 1; i++) {
	        if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
	            if (leftArray[leftIndex] < rightArray[rightIndex]) {
	               array[i] = leftArray[leftIndex];
	               leftIndex++;
	            } else {
	                array[i] = rightArray[rightIndex];
	                rightIndex++;
	            }
	        } else if (leftIndex < leftArray.length) {
	            array[i] = leftArray[leftIndex];
	            leftIndex++;
	        } else if (rightIndex < rightArray.length) {
	            array[i] = rightArray[rightIndex];
	            rightIndex++;
	        }
	    }
	}

}
