/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author reddy
 */
public class Shell_sort {

    public static void main(String[] sai) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Size of input array : ");
        int num = Integer.parseInt(bf.readLine());
        int[] arr = new int[num];
        //enter numbers separated with comma(,)
        System.out.println("Enter numbers separated with comma(,)");
        String str = bf.readLine();
        String[] sarr = str.split(",");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(sarr[i]);
        }
        //sorting
        arr = shellsort(arr);
        //printing
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }    

    private static int[] shellsort(int[] arr) {
        int n = arr.length;
        for(int gap = n/2;gap>0;gap/=2){
            for(int i=gap; i<n ;i++){
                int temp = arr[i];
                int j;
                for(j=i;j>=gap && arr[j-gap]>temp ;j-=gap){
                    arr[j] = arr[j-gap];
                }
                arr[j]=temp;
            }
        }
        return arr;
    }
}
