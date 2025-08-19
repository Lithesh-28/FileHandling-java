package fileHandling;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {
    public static void main(String[] args) {
        File file = new File("Test.txt");

        try{
            if(file.createNewFile())
                System.out.println("Created a new file Successfully");
            else
                System.out.println("File already Exists");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
