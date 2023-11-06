package FileHandling;

import java.io.*;
import java.util.Scanner;

public class FIleDemo {
    public static void main(String[] args){
        File file = new File("abc.txt");

        try{
            file.createNewFile();
        } catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("file created...");

        // try {
        //     FileWriter fw = new FileWriter(file);
        //     fw.write("This is first line into the file...");
        //     fw.close();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // try {
        //     char [] s = new char[100];
        //     FileReader fr = new FileReader(file);
        //     fr.read(s);
        //     System.out.println(s);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                System.out.println(str);
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
}
