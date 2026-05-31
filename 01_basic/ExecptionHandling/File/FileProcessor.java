package ExecptionHandling.File;

import java.io.*;

public class FileProcessor {
    String filePath = "ExecptionHandling/test.txt";
    public void readFile(){
       try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
           String line;
           while ((line = reader.readLine()) != null){
               System.out.println(line);
           }
       } catch (IOException e){
           System.out.println("Error while reading file: " + e.getMessage());
       }
    }

    public void writeFile(String content){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error while writing file: " + e.getMessage());
        }
    }
}
