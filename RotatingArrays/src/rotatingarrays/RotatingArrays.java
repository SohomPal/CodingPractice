/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotatingarrays;

/**
 *
 * @author sohom
 */
public class RotatingArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numArray = new int[50000];
        PopulateArray(numArray);
        PrintArray(numArray);
//        RotateArray(numArray);
//        PrintArray(numArray);
        RotateHalfArray(numArray);
        PrintArray(numArray);
    }
    
    private static void PopulateArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }
    }
    
    private static void PrintArray(int[] arr){
        for(int k = 0; k < arr.length; k++){
            System.out.print(arr[k] + ", ");
            
        }
        
        System.out.println(" \n");
    }
    
    
    private static void RotateArray(int[] arr){
        int last = arr[arr.length - 1];
        for(int i = arr.length-1; i > 0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = last;
    }
    
    private static void RotateHalfArray(int[] arr){
        int half = (int) (Math.ceil((arr.length/2.0)));
        
        for(int i = 0; i < half; i++){
            int j = arr[i];
            arr[i] = arr[(arr.length - 1)-i];
            arr[(arr.length - 1)-i] = j;
        }
    }
    
}
