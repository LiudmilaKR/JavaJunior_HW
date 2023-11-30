package seminar1;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class task1 {
    public static void main(String[] args) {
        /*
        * Напишите программу, которая использует Stream API для обработки списка чисел.
        * Программа должна вывести на экран среднее значение всех четных чисел в списке.
         */
//        List<Integer> numList = IntStream.range(1, 10).boxed().collect(Collectors.toList());
//        Collections.shuffle(numList);
//        System.out.println("Первоначальный список => " + numList);

        List<Integer> numList1 = new Random().ints(1, 30)
                .limit(10).boxed().toList();
        System.out.println("Первоначальный список => " + numList1);
        List<Integer> numList2 = numList1.stream().filter(num -> num % 2 == 0).toList();
        System.out.println(numList2);
        int sum = numList2.stream().mapToInt(Integer::intValue).sum();
        int count = (int) numList2.stream().count();
        System.out.printf("Среднее значение = %.2f", (sum * 1.0 / count));
    }
}
