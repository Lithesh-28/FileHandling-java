package fileHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WritingToFile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        try{
            FileWriter fw = new FileWriter("Test.txt",true);

            System.out.println("Enter the text (enter exit to stop)");
            String line;

            while(true){
                line = sc.nextLine();
                if (line.equalsIgnoreCase("exit")) break;
                fw.append(line);
                fw.write('\n');
            }
            fw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try{
            FileReader fr = new FileReader("Test.txt");
            int c;
            int count = 0;
            int line = 0;
            while((c = fr.read()) != -1){
                count++;
                if(c == '\n')
                    line++;
                if (c == 'h') continue;
                System.out.print((char)c);
            }
            System.out.println("number of characters "+count);
            System.out.println("number of Lines "+line);
            fr.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }
}
