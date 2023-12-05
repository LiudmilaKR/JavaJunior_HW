package seminar2.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;

public class Program {
        /*
        * Создайте абстрактный класс "Animal" с полями "name" и "age".
        * Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
        * Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
        * Выведите на экран информацию о каждом объекте.
        * Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
         */
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Animal> animalList = new ArrayList<>();

        Class<?> dog = Class.forName("seminar2.task1.Dog");
        Constructor<?>[] dogConstuctor = dog.getConstructors();
        Object dog1 = dogConstuctor[0].newInstance("Шарик", 3, true);
        Object dog2 = dogConstuctor[0].newInstance("Дружок", 1, false);
        Object dog3 = dogConstuctor[0].newInstance("Маркиза", 2, true);
        animalList.add((Dog) dog1);
        animalList.add((Dog) dog2);
        animalList.add((Dog) dog3);
        Class<?> cat = Class.forName("seminar2.task1.Cat");
        Constructor<?>[] catConstructor = cat.getConstructors();
        Object cat1 = catConstructor[0].newInstance("Пушок", 1, true);
        Object cat2 = catConstructor[0].newInstance("Рыжик", 2, false);
        animalList.add((Cat) cat1);
        animalList.add((Cat) cat2);

        for (Animal anim : animalList) {
            System.out.println("=================================");
            System.out.printf("Животное %s =>\n", anim.getClass().getName().substring(15));
            showFields(anim);

            System.out.print("Вызов метода makeSound() => ");
            try {
                Method displaySoundForAnim = anim.getClass().getDeclaredMethod("makeSound");
                displaySoundForAnim.invoke(anim);
            } catch (NoSuchMethodException e) {
                System.out.println("Метод makeSound() у данного класса отсутствует.");
            }
        }
    }

    private static <T> void showFields(T obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();
        Class<?> objSuperClass = objClass.getSuperclass();
        Field[] f1 = objSuperClass.getDeclaredFields();
        Field[] f2 = objClass.getDeclaredFields();
        Field[] f = new Field[f1.length + f2.length];
        System.arraycopy(f1, 0, f, 0, f1.length);
        System.arraycopy(f2, 0, f, f1.length, f2.length);
        for (Field field : f) {
            field.setAccessible(true);
            System.out.printf("   %s: %s\n", field.getName(), field.get(obj));
        }
    }
}
