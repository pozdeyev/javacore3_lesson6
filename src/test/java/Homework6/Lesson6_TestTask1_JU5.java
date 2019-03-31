package Homework6;

//JUNIT5

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;



public class Lesson6_TestTask1_JU5 {



    private lesson6_homework task1;

    @BeforeEach
    public void prepare() {
        task1 = new lesson6_homework();
    }


    //Ожидаем RuntimeException, так как передаем пустой массив
    @Test
    public void test_task1_empty_array() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            task1.task1_after4(new int[]{});
        });
    }

    //Ожидаем RuntimeException, так как нет 4
    @Test
    public void test_task1_without_4() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            task1.task1_after4(new int[]{12, 34, 3});
        });
    }

    //Проверяем корректность отработки на примере массива, который содержит 4 не в начале и не в конце
    @Test
    public void test_task1_where_4_is_not_last() {
        int[] data = {12, 1, 3, 4, 7, 15, 7};
        Assertions.assertArrayEquals(new int[]{7, 15, 7}, task1.task1_after4(data));
    }

    //Проверяем корректность отработки на примере массива, который содержит 4 в разных местах
    @Test
    public void test_task1_with_some_4() {
        int[] arr = {10, 4, 6, 4, 76, 54, 4};
        Assertions.assertArrayEquals(new int[]{}, task1.task1_after4(arr));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test_task1_with_params(int[] arr, int[] result) {
        Assertions.assertArrayEquals(result, task1.task1_after4(arr));
    }

    private static Stream parameters() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 4},  //вход
                        new int[]{}),           //результат
                Arguments.of(
                        new int[]{1, 4, 3, 4},  //вход
                        new int[]{}),           //результат
                Arguments.of(
                        new int[]{1, 4, 3, 5},  //вход
                        new int[]{3, 5})        //результат
        );
    }






}
