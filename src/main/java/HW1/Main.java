package HW1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
Напишите программу, которая использует Stream API для обработки списка чисел.
Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */
public class Main {
    public static void main(String[] args) {
    List<Integer> ints = new ArrayList<>();
        Random random = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            ints.add(random.nextInt(0, 10));


        }
        System.out.println("Изначальный массив:    " + ints);
        List<Integer> evenNumbers  = ints.stream().filter(number -> number % 2 == 0).toList();
        System.out.println("\nСписок четных чисел:   " + evenNumbers);

        int average = evenNumbers.stream().mapToInt(i -> i).sum() / evenNumbers.size();
        System.out.println("\nСреднее значение четных чисел: " + average);

    }

}
