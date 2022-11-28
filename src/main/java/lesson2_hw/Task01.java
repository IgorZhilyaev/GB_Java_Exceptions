package lesson2_hw;
//Реализуйте метод, который запрашивает у пользователя ввод дробного
// числа (типа float),и возвращает введенное значение.
//Ввод текста вместо числа не должно приводить к падению приложения,
// вместо этого, необходимо повторно запросить
//у пользователя ввод данных.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {

        System.out.println(getFloatNumber());

    }
    public static float getFloatNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        String str = sc.nextLine();
        float num;
        try {
             num = Float.parseFloat(str);
         }
         catch (NumberFormatException e){
             System.out.println("Введено не число.");
             return getFloatNumber();
         }
        return num;
    }
}
