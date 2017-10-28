package ua.com.prologistic;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.*;

public class JavaFileScanner {

    public static void main(String[] args) throws IOException {
        /**
         *  Задаем путь к файлу
         */
        String fileName = "C:/Test/test.java";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        /**
         * Подключаем FileWriter и настраиваем его на перезапись файла создаваемого файла.
         */
        FileWriter writer = new FileWriter("C:/Test/testReWrite.java", false);
        String lineString = "    ";



        //построчно считываем файл
        scanner.useDelimiter(System.getProperty("line.separator"));
        while(scanner.hasNext()){
            String stringAnalyz = scanner.next();
            /**
             * Определяем длинну строки для того чтобы в дальнейшим разбить ее на массив символов
             */
            int len = stringAnalyz.length ();
            /**
             * Счетчик TABов определяем
             */

            int tabScore = 0;
            /**
             * Переводим прочитанную строку в массив символов. Для того чтобы проще было анализировать
             * каждый символ
             */
            char[] chArray = stringAnalyz.toCharArray();
            for(int i = 0; i<len; i++){
                /**
                 * Ищем среди символов нужные нам и меняем счетчик табуляции в завивимости от открывающегося
                 * и закрывающегося символа {}
                 */
                switch (chArray[i]) {
                    case '{' :
                        tabScore++;
                        /**
                         * Увеличили на 4 пробела количество пробелов в отступу.
                         * Далее выводим все на экран и записываем в ФАЙЛ
                         */
                        System.out.print ('{');
                        writer.write("{\n");
                        System.out.println ();
                        for (int j = 0; j<=tabScore; j++) {
                            System.out.print(lineString);
                        }
                    break;
                    case '}':
                        tabScore--;
                        System.out.print ('}');
                        writer.write("}\n");
                        System.out.println ();
                        for (int j = 0; j<=tabScore; j++) {
                            System.out.print(lineString);
                        }
                    break;
                    case ';' :
                        System.out.print (';');
                        writer.write(";\n");
                        System.out.println ();
                        for (int j = 0; j<=tabScore; j++) {
                            System.out.print(lineString);
                        }
                    break;
                    default:
                        System.out.print(chArray[i]);
                        writer.write(chArray[i]);
                }

            }

        }
        scanner.close();
        writer.close();

        //читаем с System.in;
        scanner = new Scanner(System.in);

    }


}


