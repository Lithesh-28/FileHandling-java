package serializeDemo;

import java.io.*;

public class VersionUIdDemo implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;
    String gender = "male";  // new field

    public VersionUIdDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        VersionUIdDemo v1 = new VersionUIdDemo("Lithesh", 21);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("example.txt"));
            oos.writeObject(v1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("example.txt"));
            VersionUIdDemo v2 = (VersionUIdDemo) ois.readObject();
            System.out.println("Name: "+v2.name+" Age: "+v2.age);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
