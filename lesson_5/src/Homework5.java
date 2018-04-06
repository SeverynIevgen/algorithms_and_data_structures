//  Created on: 5 апр. 2018 г.
//  Author: Евгений Северин

import java.util.Stack;

public class Homework5 {

//  4. *Реализовать алгоритм перевода из инфиксной записи арифметического выражения в постфиксную.
    public static void main(String[] args) {
        String infix = "12 + ( 34 - 56 ) / ( 78 * 90 )";
        String postfix = convert(infix);
        System.out.println(postfix);
    }

    private static String convert (String expression) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> op = new Stack<>();
//      Переведём String в массив символов:
        char[] chars = expression.toCharArray();
        int N = chars.length;
        for (int i = 0; i < N; i++) {
            char ch = chars[i];
//          Если символ является цифрой, то добавляем его в результат перевода (в постфиксную запись):
            if (Character.isDigit(ch)) {
                while (Character.isDigit(chars[i])) {
                    sb.append(chars[i++]);
                }
//              После чего добавляем пробел, как разделитель:
                sb.append(' ');
//            Если не цифра, то определимся со скобками.
//            Скобки слева добавляем в стек:
            } else if (ch == '(') {
                op.push(ch);
//            Скобки справа извлекаем и добавляем в результат перевода
//            (в постфиксную запись) до тех пор, пока не встречается скобка слева:
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    sb.append(op.pop()).append(' ');
                }
//              И извлекаем левую скобку со стека:
                op.pop();
            } else if (isOperator(ch)) {
//              Извлекаем сначала все операторы с более высоким приоритетом,
//              а затем добавляем их в стек:
                while (!op.isEmpty() && priority(op.peek()) >= priority(ch)) {
                    sb.append(op.pop()).append(' ');
                }
                op.push(ch);
            }
        }
//      Извлекаем оставшиеся символы со стека, и добавляем в итоговый результат перевода (в постфиксную запись):
        while(!op.isEmpty()) {
            sb.append(op.pop()).append(' ');
        }
        return sb.toString();
    }

//  Является ли символ определенным символом математических операций:
    private static boolean isOperator(char ch) {
        return ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }

//  Определим приоритет операторов (математических символов и операций, ими выполняемых):
    private static int priority(char operator) {
        switch (operator) {
            case '^' : return 3;
            case '*' : case '/' : return 2;
            case '+' : case '-' : return 1;
        }
        return 0;
    }
}
