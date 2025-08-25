package serializeDemo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeCollection {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(1);
        list.add(9);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("example.txt"));
            oos.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("example.txt"));
            List<Integer> list2 = (List<Integer>) ois.readObject();
            System.out.println(list2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
