package w1.Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileEdit {
    public static void main(String[] args) {
        String[] filenames = {"D:\\Desktop\\UM\\Y2S2\\wia2001-demo\\w1\\Q2\\text1.txt",
                            "D:\\Desktop\\UM\\Y2S2\\wia2001-demo\\w1\\Q2\\text2.txt",
                            "D:\\Desktop\\UM\\Y2S2\\wia2001-demo\\w1\\Q2\\text3.txt",
                            "D:\\Desktop\\UM\\Y2S2\\wia2001-demo\\w1\\Q2\\text4.txt"};
        String[] delimiters = {",",
                            ", ",
                            "; ",
                            "\\d+"};
        try{
            for(int i = 0; i < filenames.length; i++){
                Scanner sc = new Scanner(new File(filenames[i]));

                String output_str = "";
                while(sc.hasNextLine()){
                    //read line and split it, storing into output_str
                    String input_str = sc.nextLine();
                    String[] splitted_string = input_str.split(delimiters[i]);
                    for (String s: splitted_string){
                        output_str+=s;
                    }
                    //finish reading a line, add newline
                    output_str+="\n";
                }
                
                System.out.printf("Total number of characters in %s: ", filenames[i]);
                System.out.println(output_str.replace("\n", "").length());

                System.out.println(output_str);

                sc.close();
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}