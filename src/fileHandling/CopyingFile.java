package fileHandling;

import java.io.FileReader;
import java.io.FileWriter;

public class CopyingFile {
    public static void main(String[] args) {
        try{
            FileReader fr = new FileReader("Test.txt");
            FileWriter fw = new FileWriter("hello.txt");
            int c;
            while ((c = fr.read()) != -1){
                fw.write((char)c);
            }

            System.out.println("File copied Successfully");
            fr.close();
            fw.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
