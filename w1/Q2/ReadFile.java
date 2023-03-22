package w1.Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        String filename = "D:\\Desktop\\UM\\Y2S2\\wia2001-demo\\w1\\Q2\\text1.txt";
        try{
            Scanner sc = new Scanner(new File(filename));

            String output_str = "";
            while(sc.hasNextLine()){
                //read line and split it, storing into output_str
                String input_str = sc.nextLine();
                String[] splitted_string = input_str.split(",");
                for (String s: splitted_string){
                    output_str+=s;
                }
                //finish reading a line, add newline
                output_str+="\n";
            }
            
            System.out.print("Total number of characters in text1.txt: ");
            System.out.println(output_str.replace("\n", "").length());

            System.out.println(output_str);

            sc.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}