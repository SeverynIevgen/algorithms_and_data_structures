//  Created on: 30 мар. 2018 г.
//  Author: Евгений Северин

package extension;

import java.util.Scanner;

public class Homework4Extension {

    private static final int TASK_AMOUNT = 5;
    private static Scanner scanner = new Scanner(System.in);

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
//                case 5:
//                    System.out.println("Task 5:");
//                    task5();
//                    break;
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

//  2. *Решить задачу о нахождении длины максимальной последовательности с помощью матрицы.
    private static void task2() {
        System.out.println("Input two words for comparison:");
        String word1 = scanner.next();
        String word2 = scanner.next();
        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();
        int[][] lcsLength = new int[array1.length + 1][array2.length + 1];

        for (int i = 0; i < array1.length; i++) {
            lcsLength[i][0] = 0;
            for (int j = 0; j < array2.length; j++) {
                lcsLength[0][j] = 0;
                if (array1[i] == array2[j]) lcsLength[i + 1][j + 1] = lcsLength[i][j] + 1;
                else lcsLength[i + 1][j + 1] = Math.max(lcsLength[i + 1][j], lcsLength[i][j + 1]);
            }
        }
        System.out.println("Longest common subsequence: " + lcsLength[array1.length][array2.length]);
    }
}
