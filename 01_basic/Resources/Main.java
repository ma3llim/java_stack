package Resources;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try(FileReader fileReader = new FileReader("F:\\java\\01_basic\\Resources\\test.txt")) {
            System.out.println(fileReader.readAllLines());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
