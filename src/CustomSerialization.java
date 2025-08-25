import java.io.*;

public class CustomSerialization implements Serializable {
    private String userName;
    private String password;
    private int id;

    public CustomSerialization(String userName, String password, int id) {
        this.userName = userName;
        this.password = password;
        this.id = id;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(userName);
        out.writeInt(id);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
         userName = (String) in.readObject();
         id = in.readInt();
         password = "not-serialized";
    }

    @Override
    public String toString() {
        return "CustomSerialization[" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ']';
    }

    public static void main(String[] args) {
        CustomSerialization u1 = new CustomSerialization("Lithesh123","lith@123",101);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("example.txt"));
            oos.writeObject(u1);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("example.txt"));
            CustomSerialization u2 = (CustomSerialization) ois.readObject();
            System.out.println("After deserialization: "+u2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



    }
}
