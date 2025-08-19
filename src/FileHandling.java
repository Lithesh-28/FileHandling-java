import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        File file = new File("test.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("New file created Successfully");
            } else {
                System.out.println("File already exits ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Scanner sc = new Scanner(System.in);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            System.out.println("Enter the text to write on the file (type exit to stop)");
            while (true) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("exit")) break;

                bw.write(line);
                bw.newLine();
            }
            sc.close();
            bw.close();
        }catch (Exception e){
            System.out.println();
        }

        try {
            BufferedReader br =  new BufferedReader(new FileReader("hello.txt"));
            String line;
            System.out.println("The text inside the file is: ");
            while((line = br.readLine())!= null){
                System.out.println(line);
            }

            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (file.delete()){
            System.out.println("File Deleted Successfully: ");
        }else{
            System.out.println("File does not exist");
        }
    }
}
