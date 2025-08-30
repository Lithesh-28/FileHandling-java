package serializeDemo;

import java.io.*;

public class SerializingInheritenceDemo implements Serializable {
    String name;
    int age;

    public SerializingInheritenceDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

class Student extends SerializingInheritenceDemo{

    String gender;

    public Student(String name, int age, String gender) {
        super(name, age);
        this.gender= gender;
    }

}

class Main{
    public static void main(String[] args) {
        Student s = new Student("Lithe",21,"male");

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("example.txt"));
            oos.writeObject(s);
            oos.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("example.txt"));
            Student s2 = (Student) ois.readObject();
            System.out.println("Name: "+s2.name+" Age: "+s2.age+" Gender: "+s2.gender);
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
