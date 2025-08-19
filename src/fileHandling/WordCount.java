package fileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class wordCount{
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("hello.txt"));
            Scanner sc = new Scanner(br);
            String word;
            int wordCount = 0;
            while(sc.hasNext()){
                word = sc.next();
                wordCount++;

                if (word.equalsIgnoreCase("lithesh"))
                    continue;
                System.out.print(word+" ");

            }
            System.out.println("\n"+wordCount);
        }catch(IOException e){

        }

    }
}
