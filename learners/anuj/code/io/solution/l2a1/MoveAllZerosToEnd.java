package io.solution.l2a1;

import java.util.Arrays;

/**
 * Solution to MoveZerosToend Assignment
 * @author Anuj Jain
 */
public class MoveAllZerosToEnd {

    public void moveZeros(int arr[]) {

        int slow =0;
        int fast =0;

        while(fast < arr.length){
            if(arr[fast] == 0){
                fast++;
                continue;
            }
            arr[slow] = arr[fast];
            slow++;
            fast++;
        }
        while(slow < arr.length){
            arr[slow++] = 0;
        }
    }
    
    public static void main(String args[]){
        MoveAllZerosToEnd maz  = new MoveAllZerosToEnd();
        int arr[] = {0,0,1,2,0,5,6,7,0};
        maz.moveZeros(arr);
        System.out.println(Arrays.toString(arr));        
    }
}
