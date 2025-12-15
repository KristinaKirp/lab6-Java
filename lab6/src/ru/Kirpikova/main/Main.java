package ru.Kirpikova.main;

import ru.Kirpikova.Annotation.AnnotationProcessor;
import ru.Kirpikova.Class.Cat;
import ru.Kirpikova.Class.Coordinates2D;
import ru.Kirpikova.Class.Coordinates3D;
import ru.Kirpikova.Class.Student;
import ru.Kirpikova.validator.Validation;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите номер задания: ");
            System.out.println("Задание 1.1");
            System.out.println("Задание 1.2");
            System.out.println("Задание 1.3");
            System.out.println("Задание 1.4");
            System.out.println("Задание 1.5");
            System.out.println("Задание 1.6");
            System.out.println("Задание 2.4");
            System.out.println("Задание 2.6");

            String choice = scanner.next();
            switch (choice) {
                case "1.1":
                    try {
                        System.out.println("@Invoke.\n" +
                                "Разработайте аннотацию @Invoke, со следующими характеристиками:\n" +
                                "Целью может быть только МЕТОД\n" +
                                "Доступна во время исполнения программы\n" +
                                "Не имеет свойств\n" +
                                "Создайте класс, содержащий несколько методов, и проаннотируйте хотя бы один из них\n" +
                                "аннотацией @Invoke.\n" +
                                "Реализуйте обработчик (через Reflection API), который находит методы, отмеченные\n" +
                                "аннотацией @Invoke, и вызывает их автоматически.");
                        System.out.println("Введите имя студента:");
                        String name = scanner.next();
                        Validation.validateName(name);

                        System.out.println("Введите количество оценок для студента:");
                        int arrSize = scanner.nextInt();
                        Validation.validateSize(arrSize);

                        Student student = new Student(name, arrSize);
                        for (int i = 0; i < arrSize; i++) {
                            System.out.println("Введите оценку №" + (i + 1) + " (от 2 до 5):");
                            int grade = scanner.nextInt();
                            student.addGrade(grade);
                        }
                        AnnotationProcessor.processInvoke(student);
                    }
                    catch (RuntimeException ex) {
                        System.out.println("Ошибка: " + ex.getMessage());
                    }
                    break;
                case "1.2":
                    System.out.println("@Default.\n" +
                            "Разработайте аннотацию @Default, со следующими характеристиками:\n" +
                            "Целью может быть ТИП или ПОЛЕ\n" +
                            "Доступна во время исполнения программы\n" +
                            "Имеет обязательное свойство value типа Class\n" +
                            "Проаннотируйте какой-либо класс данной аннотацией, указав тип по умолчанию.\n" +
                            "Напишите обработчик, который выводит имя указанного класса по умолчанию.");
                    System.out.print("Введите X: ");
                    int x = scanner.nextInt();

                    System.out.print("Введите Y: ");
                    int y = scanner.nextInt();

                    Coordinates2D point2d = new Coordinates2D(x, y);
                    System.out.println("Точка: " + point2d);
                    AnnotationProcessor.processDefault(point2d);
                    break;
                case "1.3":
                    System.out.println("@ToString.\n" +
                            "Разработайте аннотацию @ToString, со следующими характеристиками:\n" +
                            "Целью может быть ТИП или ПОЛЕ\n" +
                            "Доступна во время исполнения программы\n" +
                            "Имеет необязательное свойство valuec двумя вариантами значений: YES или NO\n" +
                            "Значение свойства по умолчанию: YES\n" +
                            "Проаннотируйте класс аннотацией @ToString, а одно из полей – с @ToString(Mode.NO).\n" +
                            "Создайте метод, который формирует строковое представление объекта, учитывая только те поля,\n" +
                            "где @ToString имеет значение YES.");
                    System.out.print("Введите имя кота: ");
                    String name = scanner.next();
                    Validation.validateName(name);
                    System.out.println("Введите породу кота: ");
                    String breed = scanner.next();
                    Validation.validateName(breed);
                    System.out.println("Введите возраст кота: ");
                    int age = scanner.nextInt();
                    Validation.validateSize(age);
                    Cat cat = new Cat(name,age,breed);
                    System.out.println(AnnotationProcessor.toString(cat));
                    break;
                case "1.4":
                    System.out.println("@Validate.\n" +
                            "Разработайте аннотацию @Validate, со следующими характеристиками:\n" +
                            "Целью может быть ТИП или АННОТАЦИЯ\n" +
                            "Доступна во время исполнения программы\n" +
                            "Имеет обязательное свойство value, типа Class[]\n" +
                            "Проаннотируйте класс аннотацией @Validate, передав список типов для проверки.\n" +
                            "Реализуйте обработчик, который выводит, какие классы указаны в аннотации.");
                    System.out.print("Введите X: ");
                    int x1 = scanner.nextInt();

                    System.out.print("Введите Y: ");
                    int y1 = scanner.nextInt();

                    System.out.print("Введите Z: ");
                    int z1 = scanner.nextInt();
                    Coordinates3D point3d = new Coordinates3D(x1, y1, z1);
                    System.out.println("Точка: " + point3d);
                    AnnotationProcessor.validateProcess(point3d);
                    break;
                case "1.5":
                    System.out.println("@Two.\n" +
                            "Разработайте аннотацию @Two, со следующими характеристиками:\n" +
                            "Целью может быть ТИП\n" +
                            "Доступна во время исполнения программы\n" +
                            "Имеет два обязательных свойства: first типа String и second типа int\n" +
                            "Проаннотируйте какой-либо класс аннотацией @Two, передав строковое и числовое значения.\n" +
                            "Реализуйте обработчик, который считывает и выводит значения этих свойств.");
                    System.out.print("Введите имя кота: ");
                    String catName = scanner.next();
                    Cat kitty = new Cat(catName);
                    AnnotationProcessor.twoProcess(kitty);
                    break;
                case "1.6":
                    System.out.println("@Cache.\n" +
                            "Разработайте аннотацию @Cache, со следующими характеристиками:\n" +
                            "Целью может быть ТИП\n" +
                            "Доступна во время исполнения программы\n" +
                            "Имеет необязательное свойство value, типа String[]\n" +
                            "Значение свойства по умолчанию: пустой массив\n" +
                            "Проаннотируйте класс аннотацией @Cache, указав несколько кешируемых областей.\n" +
                            "Создайте обработчик, который выводит список всех кешируемых областей или сообщение, что\n" +
                            "список пуст.");
                    System.out.print("Введите X: ");
                    int x2 = scanner.nextInt();

                    System.out.print("Введите Y: ");
                    int y2 = scanner.nextInt();

                    Coordinates2D point = new Coordinates2D(x2, y2);
                    System.out.println("Точка: " + point);
                    AnnotationProcessor.cacheProcess(point);
                    break;
                case "2.4":
                    System.out.println("Написать тест, используя фреймворк JUnit, который проверяет корректность работы механизма\n" +
                            "валидации классов, отмеченных аннотацией @Validate.\n" +
                            "Создать класс с аннотацией @Validate, указывающей массив типов для проверки.\n" +
                            "Использовать тест, который вызывает обработчик и проверяет, что список классов,\n" +
                            "переданный в аннотации, корректно извлекается и при передаче пустого массива\n" +
                            "выбрасывается исключение IllegalArgumentException.\n" +
                            "В тесте использовать аннотацию @Test с параметром expected (или assertThrows в JUnit 5).");
                    System.out.println("Задание в пакете Тест");
                    break;
                case "2.6":
                    System.out.println("Разработайте тест, используя фреймворк JUnit, проверяющий корректность обработки\n" +
                            "аннотации @Two, если её свойства заданы некорректно. Например, строковое свойство first пустое\n" +
                            "(\"\"), а числовое second отрицательное.\n" +
                            "Создайте вспомогательный класс с аннотацией @Two(first = \"\", second = -1).\n" +
                            "В тесте реализуйте метод, который через Reflection считывает значения аннотации.\n" +
                            "Если одно из свойств нарушает ожидаемые условия (first – пустая строка, second < 0), то\n" +
                            "должен быть выброшен IllegalArgumentException.\n" +
                            "Используйте assertThrows() из JUnit для проверки выбрасываемого исключения.");
                    System.out.println("Задание в пакете Тест");
                    break;
                default:
                    System.out.println("Неверный выбор!");
                    break;
            }
        }

    }
}