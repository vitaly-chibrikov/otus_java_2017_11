package ru.otus.l081.io;

import java.io.IOException;

/**
 * Created by tully.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Main().writeObject();
        new Main().writeTextFile();
    }

    private void writeObject() throws IOException, ClassNotFoundException {
        Student student = new Student(42, "tully", "java");
        System.out.println(student);
        String file = "student.out";

        JavaIOHelper.writeObject(file, student);

        Person readStudent1 = JavaIOHelper.readObject(file, Person.class);
        System.out.println(readStudent1);

        byte[] bytes = JavaIOHelper.serialize(student);
        JavaIOHelper.writeToFile(bytes, file);

        bytes = JavaIOHelper.readFromFile(file);
        Person readStudent2 = (Person) JavaIOHelper.deserialize(bytes);
        System.out.println(readStudent2);
    }

    private void writeTextFile() throws IOException {
        String textFile = "hello.txt";
        String text = "Hello Java";
        byte[] textBytes = text.getBytes("UTF-8");
        JavaIOHelper.writeToFile(textBytes, textFile);

        textBytes = JavaIOHelper.readFromFile(textFile);
        String readString = new String(textBytes);
        System.out.println(readString);
    }

}
