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
public class Quick_sort {

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
        arr = quicksort(arr);
        //printing
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }   

    private static int[] quicksort(int[] arr) {
        quicksort(arr,0,arr.length-1);
        return arr;
    }

    private static void quicksort(int[] arr, int left, int right) {
        if(left>=right){
            return;
        }
        int pivot = arr[(left+right)/2];
        int index = partiontion(arr,left,right,pivot);
        //System.out.println(pivot+" "+index);
        //print(arr);
        quicksort(arr,left,index-1);
        quicksort(arr,index,right);
    }

    private static int partiontion(int[] arr, int left, int right, int pivot) {
        while(left<=right){
            while(arr[left]<pivot){
                left++;
            }
            while(arr[right]>pivot){
                right--;
            }
            if(left<=right){
                int temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
