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
public class merge_sort {

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
        //also known as divide and conquer
        arr = mergesort(arr);
        //print
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int[] mergesort(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        mergesort(arr, l, r);
        return arr;
    }

    static void mergesort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergesort(arr, l, mid);
        mergesort(arr, mid + 1, r);
        mergehalves(arr, l, r);
    }

    private static void mergehalves(int[] arr, int l, int r) {
        int mid = (l + r) / 2;
        int[] temp = new int[arr.length];
        int left = l;
        int right = mid + 1;
        int index = l;
        while (left <= mid && right <= r) {
            if (arr[left] < arr[right]) {
                temp[index] = arr[left];
                index++;
                left++;
            } else {
                temp[index] = arr[right];
                index++;
                right++;
            }
        }
        System.arraycopy(arr, left, temp, index, mid - left + 1);
        System.arraycopy(arr, right, temp, index, r - right + 1);
        System.arraycopy(temp, l, arr, l, r - l + 1);
    }
}
