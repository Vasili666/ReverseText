import java.io.*;
import java.util.ArrayList;
// 1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.

public class ReverseText {
    public static void main(String[] args) throws IOException {
        String fileName = "c:/MyTemp/all song.txt";

        ArrayList orderText=readTextFromFile(fileName);
        writeTextToFile(orderText);
    }



    public static ArrayList readTextFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> orderTextTemp=new ArrayList<String>();
        int i=0;
        while((line = br.readLine()) != null){
           orderTextTemp.add(i, line);
           i++;
        }
        br.close();
        fr.close();
     return orderTextTemp;
    }

    public static void writeTextToFile(ArrayList text){
               try {
             FileWriter writer = new FileWriter("c:/MyTemp/all song.txt", true);
             String s ="В обратном порядке: ";
             writer.write(s);

             try {
                 for (int i=text.size()-1; i>-1;i--){              //Начинаем с конца списка записывать в файл
                     writer.write(String.valueOf(text.get(i)));
                     writer.append('\n');
                 }
                 writer.flush();
             } finally {
                 writer.close();
             }
         }
         catch(IOException ex){

             System.out.println(ex.getMessage());
         }

     }

}
