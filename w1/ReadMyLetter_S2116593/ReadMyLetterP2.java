import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadMyLetterP2 {
    public static void main(String[] args) {
        //String filename = "KooSongLe_S2116593.txt";
        String filename = "D:\\Desktop\\UM\\Y2S2\\wia2001-demo\\w1\\ReadMyLetter_S2116593\\KooSongLe_S2116593.txt";

        String[] str = new String[10];
        try{
            //read letter
            Scanner sc = new Scanner(new File(filename));
            int i = 0;
            while(sc.hasNextLine()){
                String nextline = sc.nextLine();
                System.out.println(nextline);
                if(!nextline.equals("")){
                    str[i] = nextline.strip();
                    i++;
                }
                /*
                 * Or you can use a string to store everything including new line
                 * String str = "";
                 * str+=nextline;
                 */
            }
            sc.close();

            //receive input for second
            Scanner input = new Scanner(System.in);
            System.out.println("Enter date of second part of letter: ");
            str[i++] = input.nextLine();
            System.out.println("Enter second part of letter: ");
            str[i++] = input.nextLine();
            /*
             * Or you can use a string to store everything including new line
             * str+=input.nextLine();
             */
            input.close();

            //save
            System.out.println("\nPrinting letter:");
            FileWriter writer = new FileWriter(filename);
            for(String st: str){
                if (st == null)
                    break;
                System.out.println(st+"\n");
                writer.write(st);
                writer.write("\n\n");
            }
            writer.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
