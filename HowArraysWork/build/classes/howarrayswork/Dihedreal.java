package howarrayswork;

public class Dihedreal {
    public static void main (String[] args){
        int[][] numArray = new int[][] {{1,3,3,1}, {3,5,5,3}, {3,5,5,3}, {1,3,3,1}};
        PrintArray(numArray);
        System.out.print("\n");
        System.out.println("Is it vertically symmetrical? " + VerticalSymmetry(numArray));
        System.out.println("Is it horizontally symmetrical? " + HorizontalSymmetry(numArray));
        System.out.println("Is it diagonally symmetrical? " + (RightDiagonalSymmetry(numArray) && LeftDiagonalSymmetry(numArray)));
        System.out.println("Is this a dihedral? " + IsDihedral(numArray));
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

    public static boolean IsDihedral(int[][] arr){
        if(HorizontalSymmetry(arr) && VerticalSymmetry(arr) && LeftDiagonalSymmetry(arr) && RightDiagonalSymmetry(arr)) {
            return true;
        }
        return false;
    }

    public static boolean HorizontalSymmetry(int[][] arr){
        for(int i = 0; i < arr.length/2; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] != arr[arr.length - 1 - i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean VerticalSymmetry(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length/2; j++){
                if(arr[i][j] != arr[i][arr[i].length -1 - j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean RightDiagonalSymmetry(int[][] arr){
        int numRows = arr.length - 1;
        int numColumns = arr[0].length - 1;

        for (int sourceRow = 0; sourceRow < arr.length; sourceRow++) {
            for (int sourceColumn = 0; sourceColumn < arr.length - sourceRow; sourceColumn++) {
                if(arr[sourceRow][sourceColumn] != arr[numRows - sourceColumn][numColumns - sourceRow]){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean LeftDiagonalSymmetry(int[][] arr){
        for (int sourceRow = 0; sourceRow < arr.length; sourceRow++) {
            for (int sourceColumn = sourceRow; sourceColumn < arr.length; sourceColumn++) {
                if(arr[sourceRow][sourceColumn] != arr[sourceColumn][sourceRow]){
                    return false;
                }
            }
        }
        return true;
    }


}
