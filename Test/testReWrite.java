package ua.com.prologistic;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class JavaFileScanner {
    public static void main(String[] args) throws IOException {
        /**         *  Задаем путь к файлу         */        String fileName = "C:/Test/test.txt";
 Path path = Paths.get(fileName);
 Scanner scanner = new Scanner(path);
        String lineString = "    ";
  int tabScore = 0;
        //построчно считываем файл        scanner.useDelimiter(System.getProperty("line.separator"));
        while(scanner.hasNext()){
            String stringAnalyz = scanner.next();
            int len = stringAnalyz.length ();
            System.out.println("Строка: " + stringAnalyz + len);
            char[] chArray = stringAnalyz.toCharArray();
            for(int i = 0;
 i<len;
 i++){
                switch (chArray[i]) {
                    case 'F' :                        tabScore++;
                        System.out.println ();
                        System.out.print (lineString*tabScore);
                    break;
                    case 'E':                        tabScore--;
                        System.out.println();
                        System.out.print(lineString*tabScore);
                    break;
                    case ';
' :                        System.out.println();
                        System.out.print(lineString*tabScore);
                    break;
                }
                System.out.print(chArray[i]);
}
}
        scanner.close();
        //читаем с System.in;
        scanner = new Scanner(System.in);
    }
}
