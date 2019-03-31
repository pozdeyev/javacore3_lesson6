package Homework6;

//JUnit 4

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


//Тесты для задания №1 (возврат массива после 4)

public class Lesson6_TestTask1_JU4 {

    private lesson6_homework task1;

    @Before
    public void prep() {
        task1 = new lesson6_homework(); //Создаем экземпляр тестируемого класса lesson6_homework
    }

    //Ожидаем RuntimeException, так как передаем пустой массив
    @Test(expected = RuntimeException.class)
    public void test_task1_empty() {
        task1.task1_after4(new int[]{});
    }

    //Ожидаем RuntimeException, так как передаем массив и этот массив не содержит число 4
    @Test(expected = RuntimeException.class)
    public void test_task1_without_4() {
        task1.task1_after4(new int[]{121, 21, 33});
    }

    //Проверяем корректность отработки на примере массива, который содержит 4 не в начале и не в конце
    @Test
    public void test_task1_4_is_not_last() {
        int[] arr = {11, 22, 33, 4, 40, 6, 7};
        Assert.assertArrayEquals(new int[]{40, 6, 7}, task1.task1_after4(arr));
    }

    //Проверяем корректность отработки на примере массива, который содержит 4 в разных местах
    @Test
    public void test_task1_with_some_4() {
        int[] data = {100, 4, 33, 4, 54, 61, 4};
        Assert.assertArrayEquals(new int[]{}, task1.task1_after4(data));
    }


    //Проверяем корректность отработки на примере массива, который содержит 4 в конце
    @Test
    public void test_task1_with_end_4() {
        int[] data = {100, 21, 33, 43, 54, 61, 4};
        Assert.assertArrayEquals(new int[]{}, task1.task1_after4(data));
    }

}
