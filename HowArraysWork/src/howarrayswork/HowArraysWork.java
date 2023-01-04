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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numArray = new int[1000000];
        
        for(int i = 0; i < 100000; i++){
            int num = (int)(Math.random() * 999999 + 1);
            if(numArray[num] == 0){
                numArray[num] = num;
            }
            else{
                i--;
            }
        }
        
        int i = 0;
        while(i < 100000){
            if(numArray[i] == 0){
                int j = i+1;
                while(true){
                    if(numArray[j] != 0){
                        numArray[i] = numArray[j];
                        numArray[j] = 0;
                        i++;
                        break;
                    }
                    else{
                        j++;
                    }
                }
            }
        }
        
        for(int k = 0; k < numArray.length; k++){
            System.out.print(numArray[k] + ", ");
            
        }
        
        
        
    }
    
}
