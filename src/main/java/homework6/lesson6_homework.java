package homework6;
import java.util.Arrays;

/**
 * Java. Level 3. Lesson 6.
 * @version 31.03.2019
 */

/*
Задание №1
Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо
выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

Задание №2
Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
*/


public class lesson6_homework {

    //Задание №1
    //Метод возвращающий новый массив, путем возврата элемементов после 4
    public int[] task1_after4(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                return Arrays.copyOfRange(array, i + 1, array.length); //возвращаем все, что после 4
            }
        }
        throw new RuntimeException("Аrray doesn't have number 4"); //Если нет ни одной 4 - возврващаем ошибку
    }

    //Задание №2
    public boolean task2_number1and4(int[] array) {
        boolean number1 = false; //По умолчанию булевы перемены характеризующие наличие цифр 1 и 4 - false
        boolean number4 = false;

        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case 1:
                    number1 = true;
                    break;
                case 4:
                    number4 = true;
                    break;
                default:
                    return false;
            }
        }
        return number1 && number4;  //возвращаем true только когда в массиве есть 1 и 4
    }
}