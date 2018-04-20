//  Created on: 19 апр. 2018 г.
//  Author: Евгений Северин

import java.util.Arrays;

public class Homework8 {

    public static void main(String[] args) {
        int[] newArray = {38, 27, 43, 3, 9, 82, 10};
        System.out.println(Arrays.toString(sortingShell(newArray)));
    }

    private static int[] sortingShell(int[] array) {
        int i, j, k, h;
        int m = 0;
        int b = array.length;
        int[] d = {1, 4, 10, 23, 57, 132, 301, 701, 1750};
        //Длины промежутков (эмпирическая последовательность Марцина Циура

        while (d[m] < b) ++m;
        while (--m >= 0) {
            k = d[m]; //Сортировка
            for (i = k; i < b; i++) {
                j = i;
                h = array[i];
                while (j >= k && array[j - k] > h) {
                    array[j] = array[j - k];
                    j -= k;
                }
                array[j] = h;
            }
        }
        return array;
    }
}
