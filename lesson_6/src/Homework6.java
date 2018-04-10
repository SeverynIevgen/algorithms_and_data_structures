//  Created on: 9 апр. 2018 г.
//  Author: Евгений Северин

import java.util.Arrays;
import java.util.Scanner;

//  1. Реализовать простейшую хэш-функцию. На вход функции подается строка,
//  на выходе сумма кодов символов.
//  2. Переписать программу, реализующее двоичное дерево поиска.
//        а) Добавить в него обход дерева различными способами;
//        б) Реализовать поиск в двоичном дереве поиска;
public class Homework6 {

    private static final int TASK_AMOUNT = 2;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int selection;
        do {
            menu();
            selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    System.out.println("Task 1:");
                    task1();
                    break;
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

//  1. Реализовать простейшую хэш-функцию. На вход функции подается строка,
//  на выходе сумма кодов символов.
    private static void task1() {
        System.out.print("Print the symbols set: ");
        String word = scanner.next();
        char[] charWord = word.toCharArray();
        long hashCode = 0;
        for (int i = 0; i < charWord.length; i++) {
            hashCode += Math.pow((long) charWord[i], i);
        }
        System.out.println("My hash code is " + hashCode);
    }

//  2. Переписать программу, реализующее двоичное дерево поиска.
//        а) Добавить в него обход дерева различными способами;
//        б) Реализовать поиск в двоичном дереве поиска;
    private static void task2() {
        int[] tree = new int[]{-1, 10, 5, 15, 3, 7, 12, 17, 2, 4, 6, 8, 11, 13, 16, 18, 1};
        System.out.println("Original massive: " + Arrays.toString(tree));
        System.out.println("Pre-order recursive bypass of binary tree:");
        preOrderTravers(1, tree);
        System.out.println("\nIn-order recursive bypass of binary tree:");
        inOrderTravers(1, tree);
        System.out.println("\nPost-order recursive bypass of binary tree:");
        postOrderTravers(1, tree);
        System.out.print("\nEnter the number for searching in binary tree: ");
        int number = scanner.nextInt();
        binarySearch(number, tree);
    }

    private static void preOrderTravers(int node, int[] tree) {
        if (node < tree.length && tree[node] != -1) {
            System.out.print(tree[node] + " ");
            preOrderTravers(node * 2, tree);
            preOrderTravers(node * 2 + 1, tree);
        }
    }

    private static void inOrderTravers(int node, int[] tree) {
        if (node < tree.length && tree[node] != -1) {
            inOrderTravers(node * 2, tree);
            System.out.print(tree[node] + " ");
            inOrderTravers(node * 2 + 1, tree);
        }
    }

    private static void postOrderTravers(int node, int[] tree) {
        if (node < tree.length && tree[node] != -1) {
            postOrderTravers(node * 2, tree);
            postOrderTravers(node * 2 + 1, tree);
            System.out.print(tree[node] + " ");
        }
    }

    private static void binarySearch(int number, int[] tree) {
        int node = 1;
        while (node < tree.length && tree[node] != -1) {
            if (number > tree[node]) {
                // Если искомое значение больше, идем направо
                node = node * 2 + 1;
            }
            else if (number < tree[node]) {
                // Если искомое значение меньше, идем налево
                node = node * 2;
            }
            else if (number == tree[node]) {
                // Если равны, то останавливаемся
                System.out.println("The node is " + node);
                break;
            }
            else {
                // Если число отсутствует в бинарном дереве:
                System.out.println("The number is absent in binary tree");
                break;
            }
        }
        // Если число за пределами бинарного дерева (больше максимального числа в дереве):
        if (node >= tree.length) System.out.println("The number is absent in binary tree");
    }
}