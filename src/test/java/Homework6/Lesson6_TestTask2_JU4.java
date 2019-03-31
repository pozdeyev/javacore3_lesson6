package Homework6;

//JUnit 4

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lesson6_TestTask2_JU4 {

    private lesson6_homework task2;;

    @Before
    public void prep() {
        //Создаем экземпляр тестируемого класса lesson6_homework
        task2 = new lesson6_homework();
    }

    //Ожидаем false, так как передаем пустой массив
    @Test
    public void test_task2_empty_array() {
        Assert.assertThat(task2.task2_number1and4(new int[]{}), Is.is(false));
    }

    //Ожидаем true, так как передаем массив в котором есть 1 и 4
    @Test
    public void test_task2_only_1_and_4() {
        Assert.assertThat(task2.task2_number1and4(new int[]{1, 1, 4, 4}), Is.is(true));
    }

    //Ожидаем false, так как есть число отличное от 1 и 4
    @Test
    public void test_task2_1_and_4_and_others() {
        Assert.assertThat(task2.task2_number1and4(new int[]{1, 4, 23, 1}), Is.is(false));
    }

    //Ожидаем false, так как нет 1 и 4
    @Test
    public void test_task2_without_1_and_4() {
        Assert.assertThat(task2.task2_number1and4(new int[]{2, 3}), Is.is(false));
    }

    //Ожидаем false, так как нет 4
    @Test
    public void test_task2_only_1() {
        Assert.assertThat(task2.task2_number1and4(new int[]{1, 1, 1}), Is.is(false));
    }

    //Ожидаем false, так как нет 1
    @Test
    public void test_task2_only_4() {
        Assert.assertThat(task2.task2_number1and4(new int[]{4, 4, 4}), Is.is(false));
    }

}
