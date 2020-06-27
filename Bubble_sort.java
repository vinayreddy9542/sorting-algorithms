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
public class Bubble_sort {

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
        arr = bubblesort(arr);
        //print
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int[] bubblesort(int[] arr) {
        int len = arr.length;
        while (len-- > 0) {
            for (int i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }
}
