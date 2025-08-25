package serializeDemo;

import java.io.*;

public class Externalization implements Externalizable {
    private String name;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
    }

    public static void main(String[] args) {
        Externalization s = new Externalization();
        s.setId(10);
        s.setName("Lithesh");

        try {
            FileOutputStream fos = new FileOutputStream("test.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s);

            System.out.println("Object Serialized ");
        }catch (IOException e){}

        try{
            FileInputStream fis = new FileInputStream("test.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Externalization e = (Externalization)ois.readObject();

            System.out.println("Deserialization is done ");
            System.out.println("Student id "+e.getId());
            System.out.println("Student name "+e.getName());
        }catch (IOException | ClassNotFoundException e){}


    }
}
