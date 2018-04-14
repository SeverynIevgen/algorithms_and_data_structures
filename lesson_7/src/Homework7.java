//  Created on: 13 апр. 2018 г.
//  Author: Евгений Северин

import java.util.Scanner;


//  Переписать программу алгоритма Дейкстры на свой язык программирования.
public class Homework7 {

    private static final int TASK_AMOUNT = 2;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int selection;
        do {
            menu();
            selection = scanner.nextInt();
            switch (selection) {
//                case 1:
//                    System.out.println("Task 1:");
//                    task1();
//                    break;
                case 2:
                    System.out.println("Task 2:");
                    task2();
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

//  Переписать программу алгоритма Дейкстры на свой язык программирования.
    private static void task2() {

        int [][] array = {
                {0, 7, 8, 0, 0, 0, 0},
                {7, 0, 0, 4, 0, 6, 17},
                {8, 0, 0, 3, 0, 0, 0},
                {0, 4, 3, 0, 11, 0, 0},
                {0, 0, 0, 11, 0, 1, 0},
                {0, 6, 0, 0, 1, 0, 9},
                {0, 17, 0, 0, 0, 9, 0}};
        System.out.println("Start point: ");
        int startPoint = scanner.nextInt();
        Dijkstra dk = new Dijkstra(array, startPoint - 1);
        dk.expression();
    }
}