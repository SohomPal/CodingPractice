/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package howarrayswork;

/**
 *
 * @author sohom
 */
public class HowArraysWork {


    private static int MAX_NUMBER = 1000000;
    private static int POPULATION = 100000;
    
    public static void main(String[] args) {
        int[] numArray = new int[1000000];
        PopulateArray(numArray, POPULATION);
        PrintArray(numArray);
        CompactArray(numArray);
        PrintArray(numArray);
        System.out.println("Sum of Array: " + Sum(numArray));
  
    }
    
    private static int GetRandom(int maxNumber){
        return (int)(Math.random() * maxNumber);
    }
    
    private static void PopulateArray(int[] arr, int population){
        for(int i = 0; i < population; i++){
            int num = GetRandom(MAX_NUMBER);
            if(arr[num] == 0 || arr[num] == Integer.MIN_VALUE ){
                arr[num] = num;
            }
            else{
                i--;
            }
        }
    }
    
    private static void CompactArray(int[] arr){
        int i = 0;
        while(i < POPULATION){
            if(arr[i] == 0){
                int j = i+1;
                while(j < MAX_NUMBER){
                    if(arr[j] != 0){
                        arr[i] = arr[j];
                        arr[j] = 0;
                        i++;
                        break;
                    }
                    else{
                        j++;
                    }
                }
            }
        }
    }
    
    private static void PrintArray(int[] arr){
        for(int k = 0; k < arr.length; k++){
            System.out.print(arr[k] + ", ");
            
        }
        
        System.out.println(" \n");
    }
    
    private static long Sum(int[] arr){
        long sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        return sum;
    }
    
}
