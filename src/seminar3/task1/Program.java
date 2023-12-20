package seminar3.task1;

import java.io.*;

public class Program {
    /*
    Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
    Обеспечьте поддержку сериализации для этого класса.
    Создайте объект класса Student и инициализируйте его данными.
    Сериализуйте этот объект в файл. Десериализуйте объект обратно в программу из файла.
    Выведите все поля объекта, включая GPA, и обсудите, почему значение GPA не было сохранено/восстановлено.
     */
    public static void main(String[] args) {
        Student student = new Student("Василий Иванов", 19, 4.7);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stud.txt"))) {
            oos.writeObject(student);
            System.out.println("Объект Student сериализован.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stud.txt"))) {
            student = (Student) ois.readObject();
            System.out.println("Объект Student десериализован.");
            System.out.println(student.getName());
            System.out.println("возраст: " + student.getAge());
            System.out.println("средний бал: " + student.getGPA());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
