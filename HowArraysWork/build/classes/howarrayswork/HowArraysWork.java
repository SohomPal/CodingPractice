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
    private static int POPULATION = 500000;

    private static int OCCUPANTS = 0;
    
    public static void main(String[] args) {
        int[] numArray = new int[MAX_NUMBER];
        PopulateArray(numArray, POPULATION, MAX_NUMBER);
        System.out.println("Current Occupancy Rate: " + OccupancyPercentage(numArray) + "\n");

        //Delete 50000 Elements
        numArray = BulkRemove(MAX_NUMBER, numArray, 50000);
        System.out.println("Current Occupancy Rate: " + OccupancyPercentage(numArray) + "\n");

        //Insert 250000 Elements
        PopulateArray(numArray, 250000, numArray.length);
        System.out.println("Current Occupancy Rate: " + OccupancyPercentage(numArray) + "\n");

        //Delete 250000 Elements
        numArray = BulkRemove(MAX_NUMBER, numArray, 250000);
        System.out.println("Current Occupancy Rate: " + OccupancyPercentage(numArray) + "\n");

        //Get Size Of Array
        System.out.println("Size of Array: " + numArray.length);




        //OLD CODE
        /*
        PrintArray(numArray);

        System.out.println("Occupancy Rate: " + OccupancyPercentage(numArray));

        long startTime = System.currentTimeMillis();
        numArray = CompactArray(numArray, POPULATION);
        //CompactArrayUnoptimized(numArray);
        long elapsedTime = System.currentTimeMillis() - startTime;

        PrintArray(numArray);
        System.out.println("Sum of Array: " + Sum(numArray) + "\nTime Elapsed: " + elapsedTime);

        System.out.println(AddElement(1, numArray));
        System.out.println(SearchAndReplace(6, 5, numArray));
        PrintArray(numArray);

        System.out.println("Occupancy Rate: " + OccupancyPercentage(numArray));

         */
  
    }
    
    private static int GetRandom(int maxNumber){
        return (int)(Math.random() * maxNumber);
    }
    
    private static void PopulateArray(int[] arr, int population, int maxNumber){
        for(int i = 0; i < population; i++){
            int num = GetRandom(maxNumber);
            if(arr[num] == 0 || arr[num] == Integer.MIN_VALUE ){
                arr[num] = num;
                OCCUPANTS++;
            }
            else{
                i--;
            }
        }
    }

    private static double OccupancyPercentage(int[] arr){
        return ((double) OCCUPANTS) / arr.length;
    }

    private static int Lookup(int value, int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }

    private static void Remove(int value, int[] arr){
        int location = Lookup(value, arr);
        if(location != -1){
            arr[location] = 0;
            OCCUPANTS --;
        }
    }

    private static int[] BulkRemove(int maxValue, int[] arr, int iterations){
        for(int i=0; i<iterations; i++) {
                Remove(GetRandom(maxValue), arr);
            }
        if(OccupancyPercentage(arr) < 0.5){
            return CompactArray(arr, 0.6);
        }
        return arr;
    }

    private static boolean SearchAndReplace(int removeValue, int newValue, int[] arr){
        int location = Lookup(removeValue, arr);
        if(location == -1){
            return false;
        }
        arr[location] = newValue;
        return true;
    }
    
    private static void CompactArrayUnoptimized(int[] arr){
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

    private static int[] CompactArray(int[] arr, double targetOccupancyRatio){
        int newSize = (int) (arr.length * (OccupancyPercentage(arr) / targetOccupancyRatio));
        int[] compactArray = new int[newSize];
        int i = 0;
        int j = 0;
        while(i < arr.length){
            if(arr[i] != 0){
                compactArray[j] = arr[i];
                j++;
            }
            i++;
        }

        return compactArray;
    }

    private static Boolean AddElement(int value, int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0 || arr[i] == Integer.MIN_VALUE){
                arr[i] = value;
                return true;
            }
        }
        return false;
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
