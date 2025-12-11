package ru.Kirpikova.Class;

import ru.Kirpikova.Annotation.Invoke;
import ru.Kirpikova.Annotation.Validate;
import ru.Kirpikova.validator.InvalidGradeException;
import ru.Kirpikova.validator.InvalidSize;
import ru.Kirpikova.validator.Validation;
import javax.naming.InvalidNameException;
import java.util.Arrays;
/**
 * Класс, представляющий студента.
 * <p>
 * Хранит имя, массив оценок и средний балл (GPA).
 * Использует аннотацию {@link Validate} для указания классов для проверки.
 * </p>
 *
 * @see Validate
 */
@Validate({String.class, int[].class, double.class})
public class Student {
    private final String name;
    private int[] grades;
    private int gradeCount;
    private double gpa;
    /**
     * Создает студента с именем и массивом оценок.
     *
     * @param name имя студента
     * @param gradeArraySize размер массива оценок
     * @throws InvalidNameException если имя некорректно
     * @throws InvalidSize если размер массива отрицательный
     */
    public Student(String name, int gradeArraySize) {
        Validation.validateName(name);
        Validation.validateSize(gradeArraySize);

        this.name = name;
        this.grades = new int[gradeArraySize];
        this.gradeCount = 0;
    }
    public Student(String name) {
        Validation.validateName(name);
        this.name = name;
    }
    /**
     * Добавляет оценку студенту.
     *
     * @param grade оценка (2–5)
     * @throws RuntimeException если массив оценок заполнен или размер равен 0
     * @throws InvalidGradeException если оценка недопустима
     */
    public void addGrade(int grade) {
        Validation.validateGrade(grade);

        if (grades.length == 0) {
            throw new RuntimeException("Нельзя добавить оценку: массив имеет размер 0.");
        }
        if (gradeCount >= grades.length) {
            throw new RuntimeException("Массив оценок заполнен!");
        }

        grades[gradeCount++] = grade;
        AverageGrade();
    }

    private void AverageGrade() {
        if (this.gradeCount == 0) {
            gpa = 0.0;
        }
        int sum = 0;
        for (int i = 0; i < this.gradeCount; i++) {
            sum += this.grades[i];
        }
        gpa = (double) sum/this.gradeCount;
    }

    public double getGpa() {
        return gpa;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Студент: " + name +
                ", оценки: " + Arrays.toString(grades) +
                ", средний балл: " + gpa ;
    }
    /**
     * Выводит информацию о студенте.
     * <p>
     * Метод помечен аннотацией {@link Invoke}, используется AnnotationProcessor.
     * </p>
     *
     * @see Invoke
     */
    @Invoke
    public void printInfo() {
        System.out.println("Информация о студенте:");
        System.out.println(this.toString());
    }
}
