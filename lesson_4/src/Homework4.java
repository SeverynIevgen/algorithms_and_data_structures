//  Created on: 1 апр. 2018 г.
//  Author: Евгений Северин

public class Homework4 {

    private static final int N = 8;
    private static final int M = 8;
    private static int[][] board = new int[N][M];
//  Массив всех возможных ходов фигуры (буквой Г)
    private static  final int MOVE_TYPES = 8;
    private static int possible_moves[][] =
        {{-1, -2}, {-2, -1}, {-2, 1}, {1, -2}, {-1, 2}, {2, -1}, {1, 2}, {2, 1}};

    public static void main(String[] args) {
        searchSolution(0,0,1);
        printBoard(N, M, board);
    }

    private static boolean searchSolution(int row, int col, int moveNumber) {
//      Если данное поле уже использовалось, то выдает false.
        if (board[row][col] != 0) return false;
        board[row][col] = moveNumber;
//      Всю доску обошли. Решение найдено
        if (moveNumber == M * N) return true;
//      Расширяем цикл проверки всех возможных ходов
        for (int i = 0; i < MOVE_TYPES; i++) {
            int nextRow = row + possible_moves[i][0];
            int nextCol = col + possible_moves[i][1];
//          Рекурсивно проверяем, ведет ли это к решению.
            if (positionPossible(nextRow, nextCol) && searchSolution(nextRow, nextCol,moveNumber + 1)) return true;
        }
//      Если мы дошли до этой строки, данное частичное решение не приводит к полному.
        board[row][col] = 0;
        return false;
    }

    private static boolean positionPossible(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

//  Выводим доску на экран
    private static void printBoard (int n, int m, int a[][]) {
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j] + "\t");
            }
        }
    }
}
