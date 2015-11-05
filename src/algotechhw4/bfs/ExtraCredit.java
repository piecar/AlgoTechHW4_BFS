package algotechhw4.bfs;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pieca
 */
public class ExtraCredit {
    public static void main(String[] args) throws FileNotFoundException{
        //Scanner scan = new Scanner(System.in);   
        Scanner scan = new Scanner(new File("SampleInput.txt"));
        int numElem = scan.nextInt();
        int[] input = new int[numElem];
        boolean sorted = true;
        int disc1 =-1;
        int disc2 =-1;
        int slope = 1;
        for(int i=0; i < numElem; i++)
        {
            input[i] = scan.nextInt();
        }
        for(int i=1; i <= numElem; i++)
        {
            if(input[i] < input[i-1]){
                sorted = false;
                if(i+1 < input.length && input[i] < input [i+1] && disc1 == -1){
                    disc1 = i;
                    slope =1;
                }
                else if(i+1 < input.length && input[i] > input [i+1] && disc1 == -1){
                    disc1 = i;
                    slope = -1;
                }
                else if(i+1 < input.length && slope == 1 && disc2 == -1){
                    disc2 = i;
                    if(canSwap(input, disc1, disc2)){
                        swap(input, disc1, disc2);
                    }
                }
                else if(i+1 < input.length && slope == -1 && disc2 == -1){
                    disc2 = i;
                    if(canReverse(input, disc1, disc2)){
                        reverse(input, disc1, disc2);
                    }
                }
                else{
                    //Can't be swapped or reversed
                }
                
            }
        }
    }

    private static boolean canSwap(int[] input, int disc1, int disc2) {
        if (input[disc2] < input[disc1 - 1]){
        
    }
    }
    
}
