package howarrayswork;

public class MatrixMultiplication {

    public static void main(String[] args){
        int[][] arr1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr2 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        PrintArray(arr1);
        System.out.print("\n");
        PrintArray(arr2);
        System.out.print("\n");

        int[][] crossProduct = CrossProduct(arr1, arr2);
        PrintArray(crossProduct);
        System.out.print("\n");

        int[][] dotProduct = DotProduct(arr1, 5);
        PrintArray(dotProduct);

    }


    public static void PrintArray(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + ", ");
            }
            System.out.print("\n");
        }
    }

    public static int[][] DotProduct(int[][] arr1, int scalar){
        int[][] product = new int[arr1.length][arr1[0].length];
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr1[i].length; j++){
                product[i][j] = arr1[i][j] * scalar;
            }
        }
        return product;
    }

    public static int[][] CrossProduct(int[][] arr1, int[][] arr2){
        int[][] product = new int[arr1.length][arr2[0].length];

        if(arr1[0].length != arr2.length){
            return product;
        }

        int sum = 0;

        for(int k = 0; k < arr2[0].length; k++){
            for(int i = 0; i < arr1.length; i++){
                for(int j = 0; j < arr1[i].length; j++){
                    sum = sum + (arr1[i][j] * arr2[j][k]);
                }
                product[i][k] = sum;
                sum = 0;
            }
        }
        return product;
    }
}
