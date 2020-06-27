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
public class Radix_sort {

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
        arr = radixsort(arr);
        //printing
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }    

    private static int[] radixsort(int[] arr) {
        int max = getmax(arr);
        for(int i = 1;max/i>0;i*=10){
            sort(arr,i);
        }
        return arr;
    }

    private static int getmax(int[] arr) {
        int max = arr[0];
        for(int a : arr){
            if(a>max){
                max = a;
            }
        }
        return max;
    }

    private static void sort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int count[] = new int[10];
        int index[] = new int[10];
        for(int i=0;i<n;i++){
            count[(arr[i]/exp)%10]++;
        }
        index[0] = 0;
        for(int i=1;i<10;i++){
            count[i]+=count[i-1];
            index[i] = count[i-1];
        }
        for(int i=0;i<n;i++){
            int rim = (arr[i]/exp)%10;
            output[index[rim]] = arr[i];
            index[rim]++;
        }
        for(int i=0;i<n;i++){
            arr[i] = output[i];
        }
    }
}
