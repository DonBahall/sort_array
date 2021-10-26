package com.company;
import java.util.Arrays;

public class Main{

    public static void main(String[] args) {
        System.out.println("Изначальный массив" );
        int[] array = new int[15];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int) (Math.random() * 31) - 15);
            System.out.print(array[i] + " ");

        }

        System.out.println("");


        bubbleSort(array);
        System.out.println("Сортировка пузырьком");
        System.out.print(Arrays.toString(array));
        System.out.println("");
        int n= array.length;
//        System.out.println("сортировка пирамидкой");
//        printArr(array, n);
//        System.out.println("");
        System.out.println("Изначальный массив 2");
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int) (Math.random() * 31) - 15);

            System.out.print(array[i] + " ");
        }
        System.out.println("");
        System.out.println("Sort piramidka");

        HeapSoft(array);

        System.out.println(Arrays.toString(array));

        int low = 0;
        int high = array.length -1 ;
        System.out.println("quickSort");
        quickSort(array, low, high);

        System.out.print(Arrays.toString(array));
    }

    public static int[] bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return  arr;
    }


    public static int[] HeapSoft ( int[] arr){
        int n = arr.length;
        for (int i = n / 2 - 1; i > 0; i--) {
            heapify(arr, n, i);
        }
        return arr;
    }
    static int[] heapify ( int arr[], int k, int i){
        int left = i * 2;
        int right = 2 * i + 1;
        int largest;//корень
        if (left <= k && arr[left] > arr[i]) {
            largest = left;
        } else {
            largest = i;
        }
        if (right <= k && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int larg = arr[i];
            arr[i] = arr[largest];
            arr[largest] = larg;
            heapify(arr, k, largest);
        }
        return arr;
    }
public  static  int[] HeadSoft(int[] arr){
        HeapSoft(arr);
    int n = arr.length;
    int k =0;
        for (int i=n-2; i>0;i--){
            int laag =arr[1];
            arr[1]=arr[k];
            arr[k]=laag;
            k=k-1;

        }
        return  heapify(arr, k, 1);

}
    public static int[] quickSort(int[] array, int low, int high) {
        int middle = low + (high - low) / 2;
        int opora = array[middle];
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    return array;
    }

}

