package fileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class ReplaceString{
    public static void main(String[] args) {
        try {
            File file = new File("test.txt");
            Scanner sc = new Scanner(file);
            StringBuilder word = new StringBuilder();
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                line = line.replaceAll("hii","hello");
                word.append(line).append('\n');

            }
            sc.close();
            FileWriter fr = new FileWriter(file);
            fr.write(word.toString());


            fr.close();
            System.out.println("String replaced Successfully");

        }catch (IOException e){

        }
    }
}