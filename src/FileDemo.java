import java.io.*;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("example.txt");
        try {
            if (file.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileWriter fw = new FileWriter("example.txt", true)) {
                fw.append("hello world, this is lithesh");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("example.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String s;
        try {
            while((s=br.readLine())!=null){
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
