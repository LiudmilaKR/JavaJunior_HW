package seminar1;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
        System.out.println();
//        numList1.stream().filter(num -> num % 2 == 0).map(i -> Integer.valueOf(i)).forEach(System.out::println);
//        numList1.stream().filter(num -> num % 2 == 0).map(Integer::valueOf).forEach(System.out::println);
//        int sum1 = numList1.stream().filter(num -> num % 2 == 0).reduce((a, b) -> (a + b)).get();
        int sum1 = numList1.stream().filter(num -> num % 2 == 0).reduce(Integer::sum).get();
        System.out.println("sum1 = " + sum1);

        System.out.println(numList1.stream().collect(
                Collectors.groupingBy(
                        num -> num % 2 == 0,
                        Collectors.averagingInt(Integer::intValue)
                )
        ));
        double num5 = numList1.stream().filter(num -> num % 2 == 0).collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("среднее - ещё вариант => " + num5);
//        Stream<Integer>, Optional<Integer>
    }
}
