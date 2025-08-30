package serializeDemo;

import java.io.*;

public class SerializeAndDeserialize implements Serializable {

    public String name;
    public int id;

    public SerializeAndDeserialize(String name, int id){
        this.name = name;
        this.id = id;
    }
    public static void main(String[] args) {
        try(ObjectOutputStream Oos = new ObjectOutputStream(new FileOutputStream("hello.txt"))) {
            SerializeAndDeserialize s1 = new SerializeAndDeserialize("lithe", 102);
            Oos.writeObject(s1);
            System.out.println("Object Serialized ");
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(ObjectInputStream Ois = new ObjectInputStream(new FileInputStream("hello.txt"))){
            SerializeAndDeserialize s2 = (SerializeAndDeserialize)Ois.readObject();
            System.out.println("Deserialized "+s2.name+" "+s2.id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
