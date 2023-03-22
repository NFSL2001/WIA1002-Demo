import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadMyLetter {
    public static void main(String[] args) {
        //String filename = "KooSongLe_S2116593.txt";
        String filename = "D:\\Desktop\\UM\\Y2S2\\wia2001-demo\\w1\\ReadMyLetter_S2116593\\KooSongLe_S21165930.txt";
        try{
            Scanner sc = new Scanner(new File(filename));
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
