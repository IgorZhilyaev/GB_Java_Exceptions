package lesson2_hw;

//Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

import java.util.Scanner;

public class Task04 {

    public static void main(String[] args) {

        getString();

    }
    static void getString(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String str = sc.nextLine();
        if (str.isEmpty()) {
            throw new RuntimeException("Вы ввели путую строку.");
        }
    }


}
