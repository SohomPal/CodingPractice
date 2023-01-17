package howarrayswork;

public class FoldingArray {
    public static void main(String[] args){
        int[][] numArray = new int[10][10];
        Populate2DArray(numArray);
        PrintArray(numArray);
        System.out.print("\n");
        numArray = FoldDiagonally(numArray, true);
        PrintArray(numArray);
    }

    public static void Populate2DArray(int[][] arr){

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = (arr.length * i) + j +1;
            }
        }
    }

    public static void PrintArray(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
               System.out.print(arr[i][j] + ", ");
            }
            System.out.print("\n");
        }
    }

    public static int[][] FoldDiagonally(int[][] arr, boolean foldRight){
        int numRows = arr.length - 1;
        int numColumns = arr[0].length - 1;

        if(foldRight) {
            for (int sourceRow = 0; sourceRow < arr.length; sourceRow++) {
                for (int sourceColumn = 0; sourceColumn < arr.length - sourceRow; sourceColumn++) {
                    //arr[sourceRow][sourceColumn] = arr[sourceRow][sourceColumn] + arr[numRows-sourceColumn][numColumns-sourceRow];
                    int temp = arr[sourceRow][sourceColumn];
                    arr[sourceRow][sourceColumn] = arr[numRows - sourceColumn][numColumns - sourceRow];
                    arr[numRows - sourceColumn][numColumns - sourceRow] = temp;
                }
            }
            return arr;
        }

        for (int sourceRow = 0; sourceRow < arr.length; sourceRow++) {
            for (int sourceColumn = sourceRow; sourceColumn < arr.length; sourceColumn++) {
                int temp = arr[sourceRow][sourceColumn];
                arr[sourceRow][sourceColumn] = arr[sourceColumn][sourceRow];
                arr[sourceColumn][sourceRow] = temp;
            }
        }
        return arr;

    }

}
