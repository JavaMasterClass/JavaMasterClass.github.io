package learn.l2;

import java.util.Arrays;

public class ArrayAssignment {
	
	public static void main(String[] args) {
		
		int[]	values =  {2,0,4,99,0,7,6,0,8,10};
		 System.out.println("ActualArray :" + Arrays.toString(values));
		 
		 ArrayAssignment arrayAssignObj = new  ArrayAssignment();
		 int[]	zeroatRightValues = arrayAssignObj.moveZerosToRight(values);
		 System.out.println(" Array with Zero at right : "+ Arrays.toString(zeroatRightValues));
		 arrayAssignObj.sort(zeroatRightValues);
		 System.out.println(" Sorted Array : "+ Arrays.toString(values));
		 
	
	}
	
	//L2A1
	public int[] moveZerosToRight(int[] arrValues)
	{
		   int slow =0;
	        int fast =0;
	        for (int i :arrValues) {	        	
	            if(arrValues[fast] == 0){
	                fast++;
	                continue;
	            }
	            arrValues[slow] = arrValues[fast];
	            slow++;
	            fast++;
	        }
	       while(slow < arrValues.length){
	        	arrValues[slow++] = 0;
	        }
	       
	       return arrValues;
	} 
	
	// L2A2

	public  int[] sort(int[] values)
	{
		Arrays.sort(values);
			
		return values;
		
	}

	
	
}

