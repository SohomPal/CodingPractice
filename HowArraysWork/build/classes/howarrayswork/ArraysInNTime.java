package howarrayswork;

public class ArraysInNTime {

    public static void main(String[] args){
        int[][] numArray = new int[16][16];
        int size2 = numArray.length * numArray[0].length;
        int size = numArray.length;


        for(int i = 0; i < size2; i++){
            numArray[i/size][i%size] = (i+1);
        }

        PrintArray(numArray);
        System.out.print("\n\n");

        numArray = Transpose(numArray);
        PrintArray(numArray);





    }

    public static void PrintArray(int[][] numArray){
        int size = numArray.length;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.printf("%03d",numArray[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    public static int[][] Transpose(int[][] arr){
        for(int i=0; i< arr.length; i++){
            for (int j= i+1; j < arr[0].length; j++){
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }

        }
        return arr;
    }


}
