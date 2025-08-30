package serializeDemo;

import java.io.*;

public class TransientDemo implements Serializable {
    public String name;
    public transient int age;

    public TransientDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        TransientDemo t = new TransientDemo("Lithe",21);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("example.txt"));
            oos.writeObject(t);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("example.txt"));
            TransientDemo t2 = (TransientDemo) ois.readObject();
            System.out.println("name: "+t2.name+" age: "+t2.age);
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(t.age);
    }
}
