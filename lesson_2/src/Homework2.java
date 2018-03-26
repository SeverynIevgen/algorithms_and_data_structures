//  Created on: 23 мар. 2018 г.
//  Author: Евгений Северин

import java.util.Scanner;

//  1. Реализовать функцию перевода чисел из десятичной системы в двоичную, используя рекурсию.
//  2. Реализовать функцию возведения числа a в степень b:
//      a. Без рекурсии.
//      b. Рекурсивно.
//      c. *Рекурсивно, используя свойство чётности степени.
//  3. **Исполнитель «Калькулятор» преобразует целое число, записанное на экране. У исполнителя
//      две команды, каждой присвоен номер:
//      1. Прибавь 1.
//      2. Умножь на 2.
//      Первая команда увеличивает число на экране на 1, вторая увеличивает его в 2 раза. Сколько
//      существует программ, которые число 3 преобразуют в число 20:
//      а. С использованием массива.
//      b. *С использованием рекурсии.

//  Записывайте в начало программы условие и свою фамилию. Все решения создавайте в одной программе. Задания со звёздочками выполняйте в том случае, если решили задачи без звёздочек

public class Homework2 {

    private static final int TASK_AMOUNT = 3;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int selection;
        do
        {
            menu();
            selection = scanner.nextInt();
            switch (selection)
            {
                case 1:
                    System.out.println("Task 1:");
                    task1();
                    break;
                case 2:
                    System.out.println("Task 2:");
                    task2();
                    break;
                case 3:
                    System.out.println("Task 3:");
                    task3();
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

//  Выбор номера задания:    
    private static void menu() {
        System.out.println("\nChoose the number of task:");
        for (int i = 1; i <= TASK_AMOUNT; i++)
            System.out.println(i + " - task " + i);
        System.out.println("Or print 0 for exit");
    }

//  1. Реализовать функцию перевода чисел из десятичной системы в двоичную, используя рекурсию.
    private static void task1() {
        System.out.print("Input a number: ");
        int num = scanner.nextInt();
        System.out.println("The number " + num + " equals " + toBin(num) + " in binary numeral system");
    }

    private static int toBin(int x) {
        if (x == 0) return 0;
        int a = x % 2;
        x /= 2;
        return toBin(x) * 10 + a;
    }

//  2. Реализовать функцию возведения числа a в степень b:
//      a. Без рекурсии.
//      b. Рекурсивно.
//      c. *Рекурсивно, используя свойство чётности степени.
    private static void task2() {
        System.out.print("Input a number: ");
        int num = scanner.nextInt();
        System.out.print("Input a power: ");
        int pow = scanner.nextInt();
        System.out.println("Without recursion:");
        System.out.println("The number " + num + " in power " + pow + " equals "+ quickPow(num, pow));
        System.out.println("With recursive call:");
        System.out.println("The number " + num + " in power " + pow + " equals "+ recPow1(num, pow));
        System.out.println("With recursive call by using property of power parity:");
        System.out.println("The number " + num + " in power " + pow + " equals "+ recPow2(num, pow));
    }

    private static long quickPow(int a, int b) {
        long num = 1;
        while (b != 0) {
            if (b % 2 == 1) {
                b--;
                num *= a;
            } else {
                a *= a;
                b /= 2;
            }
        }
        return num;
    }

    private static long recPow1(int a, int b) {
        if (b == 0) return 1;
        b--;
        return recPow1(a, b) * a;
    }

    private static long recPow2(int a, int b) {
        if (b == 0) return 1;
        while (b != 0) {
            if (b % 2 == 1) {
                b--;
                return recPow2(a, b) * a;
            } else {
                a *= a;
                b /= 2;
            }
        }
        return recPow2(a, b);
    }

//  3. **Исполнитель «Калькулятор» преобразует целое число, записанное на экране. У исполнителя
//      две команды, каждой присвоен номер:
//      1. Прибавь 1.
//      2. Умножь на 2.
//      Первая команда увеличивает число на экране на 1, вторая увеличивает его в 2 раза. Сколько
//      существует программ, которые число 3 преобразуют в число 20:
//      а. С использованием массива.
//      b. *С использованием рекурсии.
    private static void task3() {
        int a = 3;
        int b = 20;
        System.out.println("Calculator by using massive:");
        System.out.println("The number of program from " + a + " to " + b + " is " + fun1(a, b));
        System.out.println("Calculator by using recursion:");
        System.out.println("The number of program from " + a + " to " + b + " is " + fun2(a, b));
        }

    private static int fun1(int from, int to) {
        int[] arr = new int[to + 1];
        for (int i = to; i >= from; i--) {
            if (i > to / 2) arr[i] = 1;
            else arr[i] = arr[i + 1] + arr[2 * i];
        }
        return arr[from];
    }

        private static int fun2(int from, int to) {
        if (from > to / 2) return 1;
        else return fun2(from + 1, to) + fun2(from * 2, to);
    }
}
