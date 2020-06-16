import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File input = new File("D:/mapsa/FileTest/StudentsScore.txt");
        try {
            Scanner sc = new Scanner(input);
            StringBuilder sb = new StringBuilder();
            while(true){
                String name = sc.next();
                if("#".equals(name))
                    break;
                double average = 0.0;
                for (int i=0; i<4; i++)
                    average += sc.nextDouble();
                average /= 4;
                sb.append(name + " " + average + System.getProperty("line.separator"));
            }
            sc.close();
            File output = new File("D:/mapsa/FileTest/StudentsAverage.txt");
            if(!output.exists()){
                output.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(output);
            fileWriter.write(sb.toString());
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        } catch (IOException e) {
            System.err.println("Result file could'nt created.");
        }
    }
}
