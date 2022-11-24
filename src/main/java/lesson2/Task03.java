package lesson2;
//Запишите в файл следующие строки:
//   Анна=4
//   Елена=5
//   Марина=6
//   Владимир=?
//   Константин=?
//   Иван=4
//   Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив
//   (либо HashMap, если студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных,
//   если сохранено значение ?, заменить его на соответствующее число.Если на каком-то месте встречается символ,
//   отличный от числа или ?, бросить подходящее исключение.Записать в тот же файл данные с замененными символами ?.


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task03 {

    public static void main(String[] args) {
        writeToFile();
        String[][] array = saveToArr();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);
            }
            System.out.println();
        }
    }

    public static void writeToFile(){
        try(FileWriter writer = new FileWriter("file.txt")){
            writer.write("Анна=4\nЕлена=5\nМарина=6\nВладимир=?\nКонстантин=?\nИван=4");
        } catch (IOException e) {
            System.out.println("an error ocurred");
        }
    }

    public static String[][] saveToArr(){
        String[][] arr = new String[6][2];
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))){
            String line;
            while ((line = br.readLine()) != null && i < arr.length){
                String[] array = line.split("=");
                arr[i][0] = array[0];
                if("?".equals(array[1])) {
                    arr[i][1] = String.valueOf(arr[i][0].length());
                }
                else{
                    arr[i][1] = array[1];
                }
                i++;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return arr;
    }
}
