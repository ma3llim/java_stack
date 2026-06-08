package practise_files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReaderDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a number: ");

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bufferR = new BufferedReader(in);

        String num = bufferR.readLine();
        System.out.println(num);

        bufferR.close();
    }
}
