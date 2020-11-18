package HomeDZ_2;

import java.util.Scanner;

public class Start_lesson2 {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        Scanner useranswer = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int SIZE = useranswer.nextInt();

        String[][] myArray = new String[SIZE][SIZE];
        int summ = 0;

        /*Задаем тестовый массив вручную с необрабатываемыми элементами Ж */
        String[][] myArray2 = {{"1", "1", "1", "Ж"}, {"1", "1", "1", "1"}, {"1", "Ж", "1", "1"}, {"1", "1", "1", "Ж"}};

        checkSizeArray(myArray); /*Отправляем в метод массив, размер которого спросили и вызываем MyArraySizeException*/
        printArray(myArray2); /*Выводим на экран для удобства массив, определенный вручную*/
        doTryCatchExpection(summ, myArray2); /*метод для обработки исключения NumberFormatException через try-catch*/
        doCustomExpection(summ, myArray2); /*метод для обработки исключения NumberFormatException и вызова MyArrayDataException */

    }

    /*******************************************************************************************/

    private static void doTryCatchExpection(int summ, String[][] myArray2) {
        for (int i = 0; i < myArray2.length; i++) {
            for (int j = 0; j < myArray2.length; j++) {
                try {
                    summ = summ + Integer.parseInt(myArray2[i][j]);
                } catch (NumberFormatException e) {
                    System.out.println("Злодей затаился на позиции ij: " + i + j);
                }
            }
        }
        System.out.println("Сумма цифр элементов массива после преобразования: " + summ);
    }

    private static void doCustomExpection(int summ, String[][] myArray2) throws MyArrayDataException {
        System.out.println("Исключение, заданное пользователем: \n");
        for (int i = 0; i < myArray2.length; i++) {
            for (int j = 0; j < myArray2.length; j++) {
                try {
                    summ = summ + Integer.parseInt(myArray2[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);

                }
            }

        }
    }


    private static void checkSizeArray(String[][] myArray) throws MyArraySizeException {
        if (myArray.length != 4) {
            throw new MyArraySizeException("Пользователь ввел размер массива отличный от 4");
        }
    }


    private static void printArray(String[][] myArray2) {
        System.out.println("Массив для проверки:");
        for (int i = 0; i < myArray2.length; i++) {
            for (int j = 0; j < myArray2.length; j++) {
                System.out.print(myArray2[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

