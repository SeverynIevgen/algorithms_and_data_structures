//  Created on: 30 мар. 2018 г.
//  Author: Евгений Северин

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Homework3 {

    private static final int TASK_AMOUNT = 5;
    private static final int ARRAY_SIZE = 10;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        int selection;
        do
        {
            menu();
            selection = scanner.nextInt();
            switch (selection)
            {
//                case 1:
//                    System.out.println("Task 1:");
//                    task1();
//                    break;
                case 2:
                    System.out.println("Task 2:");
                    task2();
                    break;
//                case 3:
//                    System.out.println("Task 3:");
//                    task3();
//                    break;
//                case 4:
//                    System.out.println("Task 4:");
//                    task4();
//                    break;
                case 5:
                    System.out.println("Task 5:");
                    task5();
                    break;
                case 0:
                    System.out.println("Bye-bye");
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        } while (selection != 0);
        scanner.close();
    }

    private static void menu() {
        System.out.println("\nChoose the number of task:");
        for (int i = 1; i <= TASK_AMOUNT; i++)
            System.out.println(i + " - task " + i);
        System.out.println("Or print 0 for exit");
    }

//  2. *Реализовать шейкерную сортировку.
    private static void task2() {
        int[] array = new int[ARRAY_SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(ARRAY_SIZE);
        }
        System.out.println("Array before sorting:");
        System.out.print(Arrays.toString(array) + "\n");
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
            for (int k = array.length - 2 - i; k > i; k--) {
                if (array[k - 1] > array[k]) {
                    int temp = array[k];
                    array[k] = array[k - 1];
                    array[k - 1] = temp;
                }
            }
        }
        System.out.println("Array after sorting:");
        System.out.print(Arrays.toString(array));
    }

//  5. **Реализовать сортировку вставками, используя бинарный поиск.
    private static void task5() {
        int[] arrayBefore = new int[ARRAY_SIZE];
        for (int i = 0; i < arrayBefore.length; i++) {
            arrayBefore[i] = random.nextInt(ARRAY_SIZE);
        }
        int[] arrayAfter = new int[ARRAY_SIZE];
        arrayAfter[0] = arrayBefore[0];
        for (int i = 1; i < arrayBefore.length; i++) {
            int index;
            if (arrayBefore[i] <= arrayAfter[0])
                index = 0;
            else if ((arrayBefore[i] >= arrayAfter[0] && arrayBefore[i] <= arrayAfter[1]) ||
                     (arrayBefore[i] >= arrayAfter[0] && i == 1))
                index = 1;
            else {
                int left = 0;
                int right = i;
                int middle = left + (right - left) / 2;
                if (arrayBefore[i] < arrayAfter[middle - 1] || arrayBefore[i] > arrayAfter[middle]) {
                    do {
                        if (arrayBefore[i] < arrayAfter[middle])
                            right = middle - 1;
                        else left = middle + 1;
                        middle = left + (right - left) / 2;
                    }
                    while (left < right || (arrayBefore[i] < arrayAfter[middle - 1] && arrayBefore[i] > arrayAfter[middle]));
                }
                index = middle;
            }
            arrayAfter[i] = arrayBefore[i];
            for (int j = i; j > index; j--) {
                int temp = arrayAfter[j];
                arrayAfter[j] = arrayAfter[j - 1];
                arrayAfter[j - 1] = temp;
            }
        }
        System.out.println("Array before sorting:");
        System.out.println(Arrays.toString(arrayBefore));
        System.out.println("Array after sorting:");
        System.out.println(Arrays.toString(arrayAfter));
    }

}
