/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foldingarrays;

/**
 *
 * @author sohom
 */
public class FoldingArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] numArray = new int[10][10];
        PopulateArray(numArray);
        PrintArray(numArray);
        FoldArrayDiagonally(numArray);
        PrintArray(numArray);
    }
    
     private static void PopulateArray(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = (arr[i].length * i) + (j+1);
            }
        }
    }
     
     private static void PrintArray(int[][] arr){
        for(int k = 0; k < arr.length; k++){
            for(int l = 0; l < arr[k].length; l++){
                System.out.print(arr[k][l] + ", ");
            }
            System.out.println("\n");
        }
            
            
        }
     
     private static boolean isSquare(int[][] arr){
         if(arr.length == arr[0].length){
             return true;
         }
         return false;
      }
     
     private static void FoldArray(int[][] arr){
        
         if(isSquare(arr) == false){
             return;
         }
         
        for(int k = 0; k < arr.length;k++){ 
            int half = (int) (Math.ceil((arr[k].length/2.0)));

            for(int i = 0; i < half; i++){
                int j = arr[k][i];
                arr[k][i] = arr[k][(arr.length - 1)-i];
                arr[k][(arr.length - 1)-i] = j;
            }
     }
        
        
    }
     
     private static void FoldArrayDiagonally(int[][] arr){
        
         int firstHalf = (int) (Math.ceil((arr.length/2.0)));
            for(int i = 0; i < firstHalf; i++){
                int[] j = arr[i];
                arr[i] = arr[(arr.length - 1)-i];
                arr[(arr.length - 1)-i] = j;
            }

        
        for(int k = 0; k < arr.length;k++){ 
            int half = (int) (Math.ceil((arr[k].length/2.0)));

            for(int i = 0; i < half; i++){
                int j = arr[k][i];
                arr[k][i] = arr[k][(arr.length - 1)-i];
                arr[k][(arr.length - 1)-i] = j;
            }
        }
     }

    
}
